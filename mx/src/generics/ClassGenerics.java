package generics;

public class ClassGenerics<T> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public static void main(String[] args) {
        ClassGenerics<String> strType = new ClassGenerics<>();
        strType.setItem("xxx");
        System.out.println(strType.getItem());


    }

}
