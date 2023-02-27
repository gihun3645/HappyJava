package 배열과_컬렉션프레임워크.배열;

public class UnlimitedArgumentsExam {
    public static void main(String[] args) {
        System.out.println(sum(5, 10));
        System.out.println(sum(1,2,4,2));
        System.out.println(sum(3,2,1,3,4,1));
    }

    public static int sum(int... args){
        System.out.println("print1 메소드  - args 길이 : "+args.length);
        int sum = 0;
        for(int i=0; i<args.length; i++){
            sum += args[i];
        }
        return sum;
    }
}
