package 배열과_컬렉션프레임워크.배열;

public class EmptyCommandArgumentExam {
    public static void main(String[] args) {
        System.out.println(args.length);
    }
}

// String[] args = new String[0];
// main(args);

// javac EmptyCommandLineArgumentExam.java
// java EmptyCommandLineArgumentExam a b c d hello
// a b c d hello 5개의 배열이 문자로 들어감
// java  -javaagent:어떤설정 EmptyCommandLineArgumentExam a b c 중간은 자바 설정