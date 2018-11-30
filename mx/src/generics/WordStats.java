package generics;

import java.util.HashMap;
import java.util.Objects;

public class WordStats {
    private static <K>HashMap<K,Integer> wordCount(K group[]){
        HashMap<K,Integer> map = new HashMap<>();
        for (K member:group) {
            if (Objects.isNull(map.get(member))){
                map.put(member,1);
            }else{
                map.put(member, map.get(member)+1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Integer demo[]= {9,2,3,4,5,6,122,2334,55,6};
        HashMap<?,Integer> mapNumber = wordCount(demo);
        System.out.println(mapNumber);

        String demo2 ="hhh shsgdg shjfba hhh";
        String [] words = demo2.split(" ");
        HashMap<?,Integer> mapWords = wordCount(words);
        System.out.println(mapWords);
    }
}
