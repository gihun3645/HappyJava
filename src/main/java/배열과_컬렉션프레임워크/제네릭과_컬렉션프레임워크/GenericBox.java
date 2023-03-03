package 배열과_컬렉션프레임워크.제네릭과_컬렉션프레임워크;

public class GenericBox<T> {
    private T t;

    public void add(T obj) {
        this.t = obj;
    }

    public T get() {
        return this.t;
    }
}
