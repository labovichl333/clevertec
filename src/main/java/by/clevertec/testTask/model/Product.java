package by.clevertec.testTask.model;

import java.util.Objects;

public class Product {
    private final String name;
    private final int id;
    private final int price;
    private final boolean discount;

    public Product(int id, String name, int price, boolean discount) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public boolean isDiscount() {
        return discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && discount == product.discount
                && name.equals(product.name) && price == product.price;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result += 17 * result + Objects.hash(discount);
        result += 31 * result + price;
        result += 19 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}
