package collection.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BasicMap {

    public static void main(String[] args) {
        Map<String, String> data = new HashMap<>();
        data.put("A","A");
        data.put("B","B");
        data.put("C","C");
        data.put("D","D");
        data.put("E","E");
        data.put(null,null);
        System.out.println(data);

        System.out.println(data.get("E"));

        System.out.println(data.get(null));

        System.out.println(data.getOrDefault("W","not"));

        System.out.println(data.containsKey("W"));

        Set<Map.Entry<String,String>> entryData = data.entrySet();
        entryData.forEach(System.out::println);

        String nullValue = data.remove(null);
        System.out.println(nullValue);
        System.out.println(data);
    }
}
