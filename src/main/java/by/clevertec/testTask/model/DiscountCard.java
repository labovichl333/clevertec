package by.clevertec.testTask.model;

public class DiscountCard {
    private final int number;
    private final int discount;

    public DiscountCard(int number, int discount) {
        this.number = number;
        this.discount = discount;
    }

    public int getNumber() {
        return number;
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountCard discountCard = (DiscountCard) o;
        return number == discountCard.number && discount == discountCard.discount;
    }

    @Override
    public int hashCode() {
        int result = number;
        result += 31 * result + discount;
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "number=" + number +
                ", discount=" + discount +
                '}';
    }
}
