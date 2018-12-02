package generics;

public class MethodGenerics {
    private static <T> boolean isEqual(ClassGenerics<T> g1,ClassGenerics<T> g2){
        return g1.getItem().equals(g2.getItem());
    }

    private static <T extends Comparable<T>> int compare(T t1,T t2){
        return t1.compareTo(t2);
    }

    public static void main(String[] args) {
        ClassGenerics<String> g1 = new ClassGenerics<>();
        g1.setItem("shanxi");

        ClassGenerics<String> g2 = new ClassGenerics<>();
        g1.setItem("a");

        System.out.println(MethodGenerics.isEqual(g1,g2));

        System.out.println(MethodGenerics.compare(10,11));
    }
}
