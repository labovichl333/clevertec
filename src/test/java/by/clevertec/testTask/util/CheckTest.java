package by.clevertec.testTask.util;

import by.clevertec.testTask.model.DiscountCard;
import by.clevertec.testTask.model.Product;
import by.clevertec.testTask.util.Check;
import by.clevertec.testTask.util.Price;
import by.clevertec.testTask.util.Purchase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckTest {
    Check check;

    @BeforeEach
    void setUp() {
        List<Purchase> purchases = new ArrayList<>();
        Purchase purchase1 = new Purchase(new Product(1, "Milk", 170, true), 11);
        Purchase purchase2 = new Purchase(new Product(2, "Beer", 210, false), 5);
        Purchase purchase3 = new Purchase(new Product(4, "Sausage", 560, false), 10);
        purchases.add(purchase1);
        purchases.add(purchase2);
        purchases.add(purchase3);
        check = new Check(purchases, new DiscountCard(0, 10));
    }

    @Test
    void getStringCheck() {
        assertTrue(check.getStringCheck().contains(
                "11   Milk              1.70       18.70\n" +
                        "                     share price: 16.82\n" +
                        "5    Beer              2.10       10.50\n" +
                        "10   Sausage           5.60       56.00\n" +
                        "----------------------------------------\n" +
                        "Taxable TOT.                      83.32\n" +
                        "VAT 10 %                           8.33\n" +
                        "TOTAL                             74.99"));
    }

    @Test
    void getTaxableTot() {
        assertEquals(new Price(83, 32), check.getTaxableTot());
    }

    @Test
    void getVat() {
        assertEquals(new Price(8, 33), check.getVat());
    }

    @Test
    void getTotal() {
        assertEquals(new Price(74, 99), check.getTotal());
    }

}
