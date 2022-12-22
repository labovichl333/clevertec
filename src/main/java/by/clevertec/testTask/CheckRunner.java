package by.clevertec.testTask;

import by.clevertec.testTask.dao.CardDao;
import by.clevertec.testTask.dao.ProductDao;
import by.clevertec.testTask.factory.CardDaoFactory;
import by.clevertec.testTask.factory.Config;
import by.clevertec.testTask.factory.DaoType;
import by.clevertec.testTask.factory.ProductDaoFactory;
import by.clevertec.testTask.model.Product;
import by.clevertec.testTask.output.CheckOutput;
import by.clevertec.testTask.output.impl.ConsoleCheckOutput;
import by.clevertec.testTask.output.impl.FileCheckOutput;
import by.clevertec.testTask.parser.Parser;
import by.clevertec.testTask.parser.impl.ConsoleParser;
import by.clevertec.testTask.util.Check;
import by.clevertec.testTask.util.InputParameters;

import java.util.List;

import static by.clevertec.testTask.constant.Constants.FILE_FOR_WRITING;

public class CheckRunner {
    public static void main(String[] args) {

        CardDaoFactory cardDaoFactory = CardDaoFactory.getInstance();
        ProductDaoFactory productDaoFactory = ProductDaoFactory.getInstance();

        try {
            Parser parser = new ConsoleParser(args);
            InputParameters inputParameters = parser.pars();

            ProductDao productDao = productDaoFactory.getProductImpl(new Config(DaoType.MEMORY));
            CardDao cardDao = cardDaoFactory.getCardImpl(new Config(DaoType.MEMORY));

            List<Product> products = productDao.getProducts(inputParameters.getIdProducts());
            Check check = new Check(inputParameters.getIdQuantityParams(), products);
            inputParameters.getCardNumber()
                    .ifPresent(cardNum -> check.setDiscountCard(cardDao.getCard(cardNum)));

            CheckOutput consoleCheckOutput = new ConsoleCheckOutput();
            consoleCheckOutput.output(check.getStringCheck());

            CheckOutput fileCheckOutput = new FileCheckOutput(FILE_FOR_WRITING);
            fileCheckOutput.output(check.getStringCheck());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
