package Javapractice;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class Employee {
    Logger logger = Logger.getLogger("Employee");

    private List<String> getAll(String data) {
        String[] str = data.split("@");
        List<String> dataList = Arrays.asList(str);
        for(String s: dataList) {
            logger.info(s);
        }
        return dataList;
    }
    public static void abc() {

    }
    public static void change() {

    }
}
