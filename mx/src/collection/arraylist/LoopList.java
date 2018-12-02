package collection.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LoopList {

    public static void main(String[] args) {
        List<String> stacks = new ArrayList<>();
        stacks.add("Google");
        stacks.add("Facebook");
        stacks.add("Microsoft");
        stacks.add("Apple");

        Consumer<Object> consumer = new LoopList().new MyConsumer<>();
        stacks.forEach(consumer);
    }

    class MyConsumer<Object> implements Consumer<Object>{

        @Override
        public void accept(Object o) {
            System.out.println("Consuming" + o);
        }
    }
}
