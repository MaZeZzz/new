package collection.arraylist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BasicList {
    public static void main(String[] args) {
        List<String> vowels = new ArrayList<>();

        vowels.add("E");
        vowels.add("I");
        vowels.add(0,"A");
        System.out.println(vowels);


    }
}
