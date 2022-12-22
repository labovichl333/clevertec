package by.clevertec.testTask.parser.impl;

import by.clevertec.testTask.util.InputParameters;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WebParserTest {

    @Test
    void pars() {
        Map<String, String> reqParam = new HashMap<>();
        reqParam.put("item1", "3");
        reqParam.put("quantity1", "2");
        reqParam.put("item2", "2");
        reqParam.put("quantity2", "5");
        reqParam.put("item3", "1");
        reqParam.put("quantity3", "6");
        reqParam.put("card", "452");
        reqParam.put("productFile", "products.txt");
        reqParam.put("cardFile", "cards.txt");
        InputParameters actual = new WebParser(reqParam).pars();
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