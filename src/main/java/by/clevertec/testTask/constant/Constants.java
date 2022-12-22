package by.clevertec.testTask.constant;

public class Constants {

    //General
    public final static String DATE_REG = "yyyy.MM.dd 'at' HH:mm:ss";
    public final static String HEADER = "CASH RECEIPT\n";
    public final static String NAME_SHOP = "Green\n";
    public final static String PHONE = "Tel: +375299022497\n";
    public final static String DELIMITER_CHECK = "----------------------------------------\n";
    public final static String TAXABLE_TOT = "Taxable TOT.";
    public final static String VAT_REG = "VAT %d %%";
    public final static String TOTAL = "TOTAL";

    public final static String SHARE_PRICE = "share price";

    public final static String DELIMITER_TXT = ";";

    public final static String FILE_FOR_WRITING = "check.txt";

    //DAO
    public final static int IND_CARD_NUMBER = 0;
    public final static int IND_CARD_DISCOUNT = 1;

    public final static int IND_PRODUCT_ID = 0;
    public final static int IND_PRODUCT_NAME = 1;
    public final static int IND_PRODUCT_PRICE = 2;
    public final static int IND_PRODUCT_IS_DISCOUNT = 3;

    //WebParser
    public final static String QUANTITY = "quantity";
    public final static String CARD = "card";
    public final static String CARD_FILE = "cardFile";
    public final static String PRODUCT_FILE = "productFile";

    public final static String ITEM_REG = "^item(\\d*)$";
    public final static int ITEM_REG_GROUP_ID = 1;

    //ConsoleParser
    public final static String TXT_REG = "^.+\\.txt$";
    public final static String PRODUCT_COUNT_REG = "^(\\d*)-(\\d*)$";
    public final static int PRODUCT_ID_REG_GROUP_NUMBER = 1;
    public final static int PRODUCT_QUANTITY_REG_GROUP_NUMBER = 2;
    public final static String CARD_REG = "^card-(\\d*)$";
    public final static int CARD_REG_GROUP_NUMBER = 1;

    //ConfigParams
    public final static String FILE_NAME_KEY = "file_name";


}
