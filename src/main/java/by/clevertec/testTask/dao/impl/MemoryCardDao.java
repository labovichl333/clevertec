package by.clevertec.testTask.dao.impl;

import by.clevertec.testTask.dao.CardDao;
import by.clevertec.testTask.exeption.CardNotFoundExeption;
import by.clevertec.testTask.model.DiscountCard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemoryCardDao implements CardDao {
    private List<DiscountCard> discountCards;

    public MemoryCardDao() {
        discountCards = new ArrayList<>(Arrays.asList(
                new DiscountCard(452, 17),
                new DiscountCard(722, 10),
                new DiscountCard(182, 5)));
    }

    @Override
    public DiscountCard getCard(int number) {
        return discountCards.stream().filter(card -> card.getNumber() == number)
                .findAny()
                .orElseThrow(() -> new CardNotFoundExeption("Card with number: " + number + " not found"));

    }
}
