package by.clevertec.testTask.util;


import by.clevertec.testTask.model.Product;

import static by.clevertec.testTask.constant.Constants.SHARE_PRICE;

public class Purchase {
    private final static int DISCOUNT_PERCENT = 10;
    private final static int NUMBER_FOR_DISCOUNT = 5;
    private final Price worth;
    private final Price netWorth;
    private final Product product;
    private final int unitsNumber;

    public Purchase(Product product, int unitsNumber) {
        this.product = product;
        this.unitsNumber = unitsNumber;
        this.worth = new Price(product.getPrice()).mul(unitsNumber);
        this.netWorth = new Price(product.getPrice()).mul(unitsNumber)
                .mul(unitsNumber >= NUMBER_FOR_DISCOUNT && product.isDiscount() ?
                        (100 - (float) DISCOUNT_PERCENT) / 100 :
                        1);
    }

    public String getLine() {
        return String.format(PurchaseTable.getFormatPurchase(),
                unitsNumber,
                product.getName(),
                new Price(product.getPrice()),
                getWorth());
    }

    public String getDiscountLine() {
        if (product.isDiscount() && unitsNumber >= NUMBER_FOR_DISCOUNT) {
            return String.format(PurchaseTable.getFormatDiscountPurchase(), SHARE_PRICE + ": " + getNetWorth());
        }
        return "";
    }

    public Price getNetWorth() {
        return netWorth;
    }

    public Price getWorth() {
        return worth;
    }

    public Product getProduct() {
        return product;
    }

    public int getUnitsNumber() {
        return unitsNumber;
    }
}
