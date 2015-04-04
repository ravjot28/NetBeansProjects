import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class GettingLocation
{
    // Create a hash table
    Map map = new HashMap();

    String key;

    public GettingLocation(String k)
    {
        this.key = k;
    }

    public String[] getValue()
    {
        String values[] = new String[map.size()];
        Iterator it = map.keySet().iterator();
        int i = 0;
        while (it.hasNext())
        {
            values[i] = it.next().toString();
            i++;
        }
        return values;
    }
    public void createMap()
    {
        map = new TreeMap();        // sorted map
        // Add key/value pairs to the map
        map.put("J&K", "2601");
        map.put("HIMACHAL", "2602");
        map.put("PUNJAB", "2603");
        map.put("UTTARANCHAL", "2604");
        map.put("HARYANA", "2605");
        map.put("DELHI", "2606");
        map.put("RAJASTHAN", "2607");
        map.put("UP", "2608");
        map.put("ARUNACHAL", "2701");
        map.put("ASSAM", "2702");
        map.put("NAGALAND", "2703");
        map.put("MANIPUR", "2704");
        map.put("MIROZAM", "2705");
        map.put("MEGHALAYA", "2706");
        map.put("BIHAR", "2707");
        map.put("JHARKHAND", "2708");
        map.put("WESTBENGAL", "2709");
        map.put("GUJARAT", "2801");
        map.put("MP", "2802");
        map.put("CHHATTISGARH", "2803");
        map.put("MAHARASHTRA", "2804");
        map.put("KERALA", "2901");
        map.put("TAMIL", "2902");
        map.put("KARNATAKA", "2903");
        map.put("AP", "2904");
        map.put("GOA", "2905");
        map.put("ORISSA", "2906");
    }

    public String getLocation()
    {
        return map.get(key).toString();
    }

    /*public static void main(String as[])
    {
        GettingLocation gl = new GettingLocation("GOA");
        gl.createMap();
        String values[] = gl.getValue();
    }*/
}
