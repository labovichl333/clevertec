package by.clevertec.testTask.controller;

import by.clevertec.testTask.dao.CardDao;
import by.clevertec.testTask.dao.ProductDao;
import by.clevertec.testTask.factory.CardDaoFactory;
import by.clevertec.testTask.factory.Config;
import by.clevertec.testTask.factory.DaoType;
import by.clevertec.testTask.factory.ProductDaoFactory;
import by.clevertec.testTask.model.Product;
import by.clevertec.testTask.parser.Parser;
import by.clevertec.testTask.parser.impl.WebParser;
import by.clevertec.testTask.util.Check;
import by.clevertec.testTask.util.InputParameters;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/check")
public class CheckController {

    private final CardDaoFactory cardDaoFactory = CardDaoFactory.getInstance();
    private final ProductDaoFactory productDaoFactory = ProductDaoFactory.getInstance();

    @RequestMapping(method = RequestMethod.GET)
    public String getCheck(@RequestParam Map<String, String> reqParam) {

        Parser parser = new WebParser(reqParam);

        InputParameters inputParameters = parser.pars();
        ProductDao productDao = productDaoFactory.getProductImpl(new Config(DaoType.MEMORY));

        CardDao cardDao = cardDaoFactory.getCardImpl(new Config(DaoType.MEMORY));
        List<Product> products = productDao.getProducts(inputParameters.getIdProducts());
        Check check = new Check(inputParameters.getIdQuantityParams(), products);
        inputParameters.getCardNumber()
                .ifPresent(cardNum -> check.setDiscountCard(cardDao.getCard(cardNum)));

        return check.getStringCheck();
    }
}
