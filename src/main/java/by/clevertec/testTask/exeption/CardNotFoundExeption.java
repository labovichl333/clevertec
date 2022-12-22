package by.clevertec.testTask.exeption;

public class CardNotFoundExeption extends DaoException {
    public CardNotFoundExeption(String message) {
        super(message);
    }
}
