package hw8.goodList;

import java.util.HashMap;
import java.util.Map;

public class Buyer {

    String name;
    Map<String,Integer> good;

    Buyer (String name){
        this.name = name;
        good = new HashMap<>();
    }
    void addGood (String smth, int qty){
        if (good.containsKey(smth)) {
            good.put(smth, good.get(smth) + qty);
        }
        else {
            good.put(smth, qty);
        }
    }
}
