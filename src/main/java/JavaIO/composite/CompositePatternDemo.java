package JavaIO.composite;

public class CompositePatternDemo {
    public static void main(String[] args) {
        File f1 = new File("file1", 10L);
        File f2 = new File("file2", 20L);
        File f3 = new File("file3", 30L);

        Folder folder1 = new Folder("folder1");
        Folder folder2 = new Folder("folder2");

        folder1.add(f1);
        folder1.add(folder2);

        folder2.add(f2);
        folder2.add(f3);

        System.out.println(folder1.getSize());
    }
}