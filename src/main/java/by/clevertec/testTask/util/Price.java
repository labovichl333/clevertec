package by.clevertec.testTask.util;

import java.util.Objects;

public class Price {
    private final int value;

    public Price(int value) {
        this.value = value;
    }

    public Price(int rubs, int coins) {
        this(rubs * 100 + coins);
    }

    public Price sub(Price price) {
        return new Price(value - price.value);
    }

    public Price add(Price price) {
        return new Price(value + price.value);
    }

    public Price mul(double value) {
        return new Price((int) (this.value * value));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price byn = (Price) o;
        return value == byn.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.format("%d.%02d", value / 100, value % 100);
    }
}
