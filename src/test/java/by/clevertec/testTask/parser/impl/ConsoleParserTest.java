package by.clevertec.testTask.parser.impl;

import by.clevertec.testTask.util.InputParameters;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleParserTest {

    @Test
    void pars() {
        String[] args = {"3-2", "2-5", "1-6", "card-452", "products.txt", "cards.txt"};
        InputParameters actual = new ConsoleParser(args).pars();
        InputParameters expected = new InputParameters();
        expected.addIdQuantityParam(3, 2);
        expected.addIdQuantityParam(2, 5);
        expected.addIdQuantityParam(1, 6);
        expected.setCardNumber(452);
        expected.setCardFile("cards.txt");
        expected.setProductFile("products.txt");
        assertEquals(expected, actual);
    }

}