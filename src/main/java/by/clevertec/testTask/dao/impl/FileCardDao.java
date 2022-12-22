package by.clevertec.testTask.dao.impl;

import by.clevertec.testTask.dao.CardDao;
import by.clevertec.testTask.exeption.CardNotFoundExeption;
import by.clevertec.testTask.exeption.DaoException;
import by.clevertec.testTask.model.DiscountCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static by.clevertec.testTask.constant.Constants.*;

public class FileCardDao implements CardDao{
    private String fileName;

    public FileCardDao(String param) {
        fileName = param;
    }

    @Override
    public DiscountCard getCard(int number) throws DaoException {

        List<DiscountCard> discountCards = new ArrayList<>();

        try (Scanner sc = new Scanner(this.getClass().getResourceAsStream("/"+fileName))) {
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(DELIMITER_TXT);
                discountCards.add(new DiscountCard(Integer.parseInt(line[IND_CARD_NUMBER]), Integer.parseInt(line[IND_CARD_DISCOUNT])));
            }
            return discountCards.stream()
                    .filter(card -> card.getNumber() == number)
                    .findAny()
                    .orElseThrow(() -> new CardNotFoundExeption("Card with number: "+number+" not found"));
        }
    }
}
