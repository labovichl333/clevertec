package by.clevertec.testTask.util;

import by.clevertec.testTask.model.DiscountCard;
import by.clevertec.testTask.model.Product;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static by.clevertec.testTask.constant.Constants.*;

public class Check {
    private final String header = HEADER;
    private final String nameShop = NAME_SHOP;
    private final String phone = PHONE;
    private final List<Purchase> purchases;
    private Optional<DiscountCard> discountCard;

    public Check(Map<Integer, Integer> params, List<Product> products, DiscountCard discountCard) {
        this.purchases = products.stream()
                .map(product -> new Purchase(product, params.get(product.getId())))
                .collect(Collectors.toList());
        this.discountCard = Optional.ofNullable(discountCard);
    }

    public Check(Map<Integer, Integer> params, List<Product> products) {
        this.purchases = products.stream()
                .map(product -> new Purchase(product, params.get(product.getId())))
                .collect(Collectors.toList());
        this.discountCard = Optional.empty();
    }

    public Check(List<Purchase> purchases, DiscountCard discountCard) {
        this.purchases = purchases;
        this.discountCard = Optional.ofNullable(discountCard);
    }

    public String getStringCheck() {
        StringBuilder check = new StringBuilder();
        check
                .append(header)
                .append(nameShop)
                .append(phone)
                .append(new SimpleDateFormat(DATE_REG).format(new Date()))
                .append("\n")
                .append(PurchaseTable.getTitleLine())
                .append(DELIMITER_CHECK);
        purchases.forEach(purchase -> check.append(purchase.getLine()).append(purchase.getDiscountLine()));
        check.append(DELIMITER_CHECK);
        if (discountCard.isPresent()) {
            check
                    .append(String.format(PurchaseTable.getFormatResults(),
                            TAXABLE_TOT,
                            getTaxableTot()))
                    .append(String.format(PurchaseTable.getFormatResults(),
                            String.format(VAT_REG, discountCard.get().getDiscount()),
                            getVat()))
                    .append(String.format(PurchaseTable.getFormatResults(), TOTAL, getTotal()));
        } else {
            check.append(String.format(PurchaseTable.getFormatResults(), TOTAL, getTaxableTot()));
        }

        return check.toString();
    }

    public void setDiscountCard(DiscountCard discountCard) {
        this.discountCard = Optional.ofNullable(discountCard);
    }

    public String getHeader() {
        return header;
    }

    public String getNameShop() {
        return nameShop;
    }

    public String getPhone() {
        return phone;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public Price getTaxableTot() {
        return purchases.stream().map(Purchase::getNetWorth).reduce(Price::add).get();
    }

    public Price getVat() {
        return getTaxableTot().mul((float) discountCard.get().getDiscount() / 100);
    }

    public Price getTotal() {
        return getTaxableTot().sub(getVat());
    }

}
