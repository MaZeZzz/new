package generics;

public class Triple<T extends Number & Comparable<T>> {
    private T value1;
    private T value2;
    private T value3;

    public Triple(T value1,T value2,T value3){
        this.value1=value1;
        this.value2=value2;
        this.value3=value3;
    }

    public T getValue1() {
        return value1;
    }

    public void setValue1(T value1) {
        this.value1 = value1;
    }

    private T addValues(){
        Double result = value1.doubleValue()+value2.doubleValue()+value3.doubleValue();
        return (T)result;
    }

    private T largest(){
        T result = value1;
        if (value3.compareTo(result)>0){
            result = value3;
        }
        if (value2.compareTo(result)>0){
            result = value2;
        }
        return result;

    }

    public static void main(String[] args) {
        Triple<Integer> t =new Triple<>(222,333,444);
        System.out.println(t.getValue1());
        System.out.println(t.addValues());
    }
}
