package Main;

import java.util.HashMap;

public class DS {

    private HashMap hm;

    public DS(int initial, int last) {
        hm = new HashMap();
        for (int i = initial; i <= last; i++) {
            hm.put(i, 0);
        }
    }

    public boolean isThere(int key){
        return hm.containsKey(key);
    }

    public boolean isPresent(int key) {
        
            if (hm.get(key) == null) {
                return false;
            }
            if (Integer.parseInt(hm.get(key).toString()) != 0) {
                return true;
            }
            return false;
    }

    public int getValue(int key) {
        if (hm.get(key) == null) {
            return 0;
        }
        return Integer.parseInt(hm.get(key).toString());
    }

    public void addValue(int key, int value) {
        hm.put(key, value);
    }

    public void remove(int key) {
        hm.remove(key);
    }
}
