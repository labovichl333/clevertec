package by.clevertec.testTask.factory;

import by.clevertec.testTask.dao.CardDao;
import by.clevertec.testTask.dao.impl.FileCardDao;
import by.clevertec.testTask.dao.impl.MemoryCardDao;
import by.clevertec.testTask.exeption.FactoryConfigExeprion;
import by.clevertec.testTask.exeption.IllegalDaoTypeExeption;

import java.util.Optional;

import static by.clevertec.testTask.constant.Constants.FILE_NAME_KEY;

public class CardDaoFactory {

    public CardDao getCardImpl(Config config) {
        CardDao toReturn;
        switch (config.getType()) {
            case FILE:
                toReturn = new FileCardDao(Optional.ofNullable(config
                                .getParam(FILE_NAME_KEY))
                                .orElseThrow(() -> new FactoryConfigExeprion("param: " + FILE_NAME_KEY + " is null")));
                break;
            case MEMORY:
                toReturn = new MemoryCardDao();
                break;
            default:
                throw new IllegalDaoTypeExeption("Illegal Dao type for CardDaoFactory");
        }
        return toReturn;
    }

    private CardDaoFactory() {
    }

    public static CardDaoFactory getInstance() {
        return Holder.HOLDER_INSTANCE;
    }

    private static class Holder {
        public static final CardDaoFactory HOLDER_INSTANCE = new CardDaoFactory();
    }

}
