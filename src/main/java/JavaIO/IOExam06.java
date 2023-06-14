package JavaIO;


import java.io.StringWriter;

public class IOExam06 {
    public static void main(String[] args) throws Exception{
        StringWriter out = new StringWriter();
        out.write("hello");
        out.write("world");
        out.write("!!!");
        out.close();

        String str = out.toString();
        System.out.println(str);
    }
}