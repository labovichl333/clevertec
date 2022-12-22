package by.clevertec.testTask.util;

import by.clevertec.testTask.util.Price;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceTest {
    @Test
    public void testSub() {
        Price syllable1 = new Price(150);
        Price syllable2 = new Price(50);
        Price actual = syllable1.sub(syllable2);
        Price expected = new Price(100);
        assertEquals(expected, actual);
    }


    @Test
    public void testAdd() {
        Price syllable1 = new Price(150);
        Price syllable2 = new Price(50);
        Price actual = syllable1.add(syllable2);
        Price expected = new Price(200);
        assertEquals(expected, actual);
    }

    @Test
    public void testMul() {
        Price syllable1 = new Price(150);
        double syllable2 = 10;
        Price actual = syllable1.mul(syllable2);
        Price expected = new Price(1500);
        assertEquals(expected, actual);
    }

}