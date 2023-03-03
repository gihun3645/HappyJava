package 배열과_컬렉션프레임워크.제네릭과_컬렉션프레임워크;

public class ObjectBox {
    private Object object;

    public void set(Object obj) {
        this.object = obj;
    }

    public Object get() {
        return this.object;
    }
}