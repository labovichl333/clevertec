package by.clevertec.testTask.parser.impl;

import by.clevertec.testTask.parser.Parser;
import by.clevertec.testTask.util.InputParameters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.clevertec.testTask.constant.Constants.*;

public class ConsoleParser implements Parser {
    private final String[] args;

    private final int indexOfProductFile;
    private final int indexOfCardFile;

    private final int numOfFiles = 2;

    public ConsoleParser(String[] args) {
        this.args = args;
        this.indexOfCardFile = args.length - 1;
        this.indexOfProductFile = args.length - 2;
    }

    public InputParameters pars() {
        InputParameters input = new InputParameters();

        Pattern patternParam = Pattern.compile(PRODUCT_COUNT_REG);
        Pattern patternCard = Pattern.compile(CARD_REG);
        for (String arg : args) {
            Matcher matcherParam = patternParam.matcher(arg);
            if (matcherParam.find()) {
                input.addIdQuantityParam(Integer.parseInt(matcherParam.group(PRODUCT_ID_REG_GROUP_NUMBER)),
                        Integer.parseInt(matcherParam.group(PRODUCT_QUANTITY_REG_GROUP_NUMBER)));
            }

            Matcher matcherCard = patternCard.matcher(arg);
            if (matcherCard.find()) {
                input.setCardNumber(Integer.parseInt(matcherCard.group(CARD_REG_GROUP_NUMBER)));
            }

        }

        if (args.length >= numOfFiles) {
            if (Pattern.matches(TXT_REG, args[indexOfCardFile])) {
                input.setCardFile(args[indexOfCardFile]);
            }
            if (Pattern.matches(TXT_REG, args[indexOfProductFile])) {
                input.setProductFile(args[indexOfProductFile]);
            }
        }

        return input;
    }
}
