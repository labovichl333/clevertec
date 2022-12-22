package by.clevertec.testTask.factory;

import by.clevertec.testTask.dao.impl.FileProductDao;
import by.clevertec.testTask.exeption.FactoryConfigExeprion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductFactoryTest {
    @Test
    void init() {
        String param = "file.txt";
        ProductDaoFactory productDaoFactory=ProductDaoFactory.getInstance();
        Config config=new Config(DaoType.FILE);
        config.addFileName(param);
        assertTrue(productDaoFactory.getProductImpl(config).getClass() == FileProductDao.class);
    }

    @Test
    void getCardDaoException() {
        ProductDaoFactory productDaoFactory=ProductDaoFactory.getInstance();
        Config config=new Config(DaoType.FILE);
        assertThrows(FactoryConfigExeprion.class,()->productDaoFactory.getProductImpl(config));
    }
}
