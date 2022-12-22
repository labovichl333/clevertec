package by.clevertec.testTask.factory;

import java.util.HashMap;
import java.util.Map;

import static by.clevertec.testTask.constant.Constants.FILE_NAME_KEY;

public class Config {

    private final Map<String,String> params;

    private final DaoType type;

    public Config(DaoType type) {
        this.type=type;
        this.params=new HashMap<>();
    }

    public void addParam(String key,String value) {
        params.put(key,value);
    }

    public void addFileName(String fileName){
        addParam(FILE_NAME_KEY,fileName);
    }

    public String getParam(String key) {
        return params.get(key);
    }

    public DaoType getType() {
        return type;
    }
}
