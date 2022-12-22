package by.clevertec.testTask.parser.impl;

import by.clevertec.testTask.parser.Parser;
import by.clevertec.testTask.util.InputParameters;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.clevertec.testTask.constant.Constants.*;

public class WebParser implements Parser {
    private final Map<String, String> reqParam;

    public WebParser(Map<String, String> reqParam) {
        this.reqParam = reqParam;
    }

    public InputParameters pars() {
        InputParameters input = new InputParameters();

        Pattern patternItemId = Pattern.compile(ITEM_REG);

        for (String key : reqParam.keySet()) {
            Matcher matcherParam = patternItemId.matcher(key);
            String quantity;
            if (matcherParam.find() && (quantity = reqParam.get(QUANTITY + matcherParam.group(ITEM_REG_GROUP_ID))) != null) {
                input.addIdQuantityParam(
                        Integer.parseInt(reqParam.get(key)),
                        Integer.parseInt(quantity));
            }
        }

        input.setCardNumber(reqParam.get(CARD) == null ? null : Integer.parseInt(reqParam.get(CARD)));
        input.setCardFile(reqParam.get(CARD_FILE));
        input.setProductFile(reqParam.get(PRODUCT_FILE));

        return input;
    }
}
