package collection.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleDict {
    public static void main(String[] args) {
        Map<String, List<String>> dict = new HashMap<>();
        List<String> listA = new ArrayList<>();
        listA.add("apple");
        listA.add("abandon");
        listA.add("adopt");
        listA.add("adult");

        List<String> listB = new ArrayList<>();
        listB.add("banner");
        listB.add("bug");
        listB.add("bush");
        listB.add("banana");

        List<String> listC = new ArrayList<>();
        listC.add("car");
        listC.add("crush");
        listC.add("cut");
        listC.add("cat");

        dict.put("a",listA);
        dict.put("b",listB);
        dict.put("c",listC);

        for (Map.Entry<String,List<String>> entry:dict.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
