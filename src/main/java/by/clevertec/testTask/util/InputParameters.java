package by.clevertec.testTask.util;

import java.util.*;

public class InputParameters {
    private Map<Integer, Integer> idQuantityParams;
    private Optional<Integer> cardNumber;
    private Optional<String> cardFile;
    private Optional<String> productFile;

    public InputParameters() {
        idQuantityParams = new HashMap<>();
        cardNumber = Optional.empty();
        cardFile = Optional.empty();
        productFile = Optional.empty();
    }

    public void addIdQuantityParam(Integer key, Integer value) {
        idQuantityParams.put(key, value);
    }

    public List<Integer> getIdProducts() {
        return new ArrayList<>(idQuantityParams.keySet());
    }

    public Map<Integer, Integer> getIdQuantityParams() {
        return idQuantityParams;
    }


    public Optional<Integer> getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = Optional.ofNullable(cardNumber);
    }

    public Optional<String> getCardFile() {
        return cardFile;
    }

    public void setCardFile(String cardFile) {
        this.cardFile = Optional.ofNullable(cardFile);
    }

    public Optional<String> getProductFile() {
        return productFile;
    }

    public void setProductFile(String productFile) {
        this.productFile = Optional.ofNullable(productFile);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputParameters that = (InputParameters) o;
        return Objects.equals(idQuantityParams, that.idQuantityParams) && Objects.equals(cardNumber, that.cardNumber)
                && Objects.equals(cardFile, that.cardFile) && Objects.equals(productFile, that.productFile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idQuantityParams, cardNumber, cardFile, productFile);
    }
}
