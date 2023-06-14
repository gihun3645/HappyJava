package JavaIO.composite;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Node{
    // Node를 여러개 가질 수 있다.
    private List<Node> nodes;

    public Folder(String name) {
        super(name);
        // nodes 를 초기화
        nodes = new ArrayList<>();
    }

    // 오버로딩
    public void add(File file) {nodes.add(file);}

    public void add(Folder folder) {nodes.add(folder);}

    @Override
    public long getSize() {
        long total = 0L;
        for(int i=0; i< nodes.size(); i++) {
            total = total + nodes.get(i).getSize();
        }
        return total;
    }

    @Override
    public boolean isFolder() {
        return true;
    }
}
