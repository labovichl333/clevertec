package by.clevertec.testTask.factory;

import by.clevertec.testTask.dao.impl.FileCardDao;
import by.clevertec.testTask.exeption.FactoryConfigExeprion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DiscountCardFactoryTest {

    @Test
    void init() {
        String param = "file.csv";
        Config config = new Config(DaoType.FILE);
        config.addFileName(param);
        CardDaoFactory cardDaoFactory = CardDaoFactory.getInstance();
        System.out.println(cardDaoFactory.getCardImpl(config).getClass());

        assertTrue(cardDaoFactory.getCardImpl(config).getClass() == FileCardDao.class);
    }

    @Test
    void getCardDaoException() {
        CardDaoFactory cardDaoFactory = CardDaoFactory.getInstance();
        Config config = new Config(DaoType.FILE);
        assertThrows(FactoryConfigExeprion.class, () -> cardDaoFactory.getCardImpl(config));
    }

}