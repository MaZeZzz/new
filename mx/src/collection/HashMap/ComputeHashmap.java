package collection.HashMap;

import java.util.HashMap;
import java.util.Map;

public class ComputeHashmap {


    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1","100");
        map.put("2","1000");
        map.put("3","10000");
        map.put(null,"100000");

        System.out.println(map);
        for (String key : map.keySet()){
            map.compute(key,(k,v)->k+v);
        }
        System.out.println(map);
        for (Map.Entry entry:map.entrySet()){
            map.put((String)entry.getKey(),(String)entry.getKey()+(String)entry.getValue());
        }
        System.out.println(map);
    }
}
