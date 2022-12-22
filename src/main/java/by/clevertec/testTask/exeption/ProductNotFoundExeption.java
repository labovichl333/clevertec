package by.clevertec.testTask.exeption;

public class ProductNotFoundExeption extends DaoException {
    public ProductNotFoundExeption(String message) {
        super(message);
    }
}
