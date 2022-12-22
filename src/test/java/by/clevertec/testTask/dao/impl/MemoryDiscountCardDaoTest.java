package by.clevertec.testTask.dao.impl;

import by.clevertec.testTask.model.DiscountCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MemoryDiscountCardDaoTest {

    @Test
    void getCard() {
        int number = 722;
        assertEquals(new DiscountCard(number, 10), new MemoryCardDao().getCard(number));
    }

    @Test
    void getCardNotNumber() {
        int number = 452;
        assertEquals(new DiscountCard(number, 17), new MemoryCardDao().getCard(number));
    }

}