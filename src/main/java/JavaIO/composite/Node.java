package JavaIO.composite;

public abstract class Node {
    private String name;

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract long getSize();
    public abstract boolean isFolder();
}