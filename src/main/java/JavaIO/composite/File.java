package JavaIO.composite;

public class File extends Node {
    private long size;

    public File(String name, long size) {
        // 부모의 필드를 초기화
        super(name);
        this.size = size;
    }

    @Override
    public long getSize() {return this.size;}

    @Override
    public boolean isFolder() {return false;}
}
