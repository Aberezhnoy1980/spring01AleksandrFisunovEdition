package ru.home.singleton;

import java.util.HashMap;
import java.util.Map;

public class LimitedMultiton {

    public enum Count {

        ONE, TWO, TREE;
    }

    private static Map instances = new HashMap();

    private static LimitedMultiton limitedMultitonInstance = null;

    public static LimitedMultiton getInstance(Enum key) {
        limitedMultitonInstance = (LimitedMultiton) instances.get(key);
        if (limitedMultitonInstance == null) {
            limitedMultitonInstance = new LimitedMultiton();
            instances.put(key, limitedMultitonInstance);
        }
        return limitedMultitonInstance;
    }

}
