package by.clevertec.testTask.factory;

import by.clevertec.testTask.dao.ProductDao;
import by.clevertec.testTask.dao.impl.FileProductDao;
import by.clevertec.testTask.dao.impl.MemoryProductDao;
import by.clevertec.testTask.exeption.FactoryConfigExeprion;
import by.clevertec.testTask.exeption.IllegalDaoTypeExeption;

import java.util.Optional;

import static by.clevertec.testTask.constant.Constants.FILE_NAME_KEY;


public class ProductDaoFactory {

    public ProductDao getProductImpl(Config config) {
        ProductDao toReturn = null;
        switch (config.getType()) {
            case FILE:
                toReturn = new FileProductDao(Optional.ofNullable(config
                                .getParam(FILE_NAME_KEY))
                                .orElseThrow(() -> new FactoryConfigExeprion("param: " + FILE_NAME_KEY + " is null")));
                break;
            case MEMORY:
                toReturn = new MemoryProductDao();
                break;
            default:
                throw new IllegalDaoTypeExeption("Illegal Dao type for ProductDaoFactory");
        }
        return toReturn;
    }


    private ProductDaoFactory() {
    }

    public static ProductDaoFactory getInstance() {
        return ProductDaoFactory.Holder.HOLDER_INSTANCE;
    }

    private static class Holder {
        public static final ProductDaoFactory HOLDER_INSTANCE = new ProductDaoFactory();
    }
}
