package 배열과_컬렉션프레임워크.배열;

public class CommandLineArgumentExam {
    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("사용법 : CommandLineArgumentExam 값 값 ....");
            System.exit(0); // return;으로 변경가능
        }

        for(String arg : args){
            System.out.println(arg);
        }
    }
}

/*

Hello.java 파일 작성하고
javac Hello.java

명령을 실행할 때 성공하면 아무런 메세지도 출력하지 않는다. -> Unix 철학.

작은 명령들을 조합해서 또 다른 명령을 만든다. (쉘 스크립트 작성)

작은 명령들이 실행되고 종료될 때.
*/
