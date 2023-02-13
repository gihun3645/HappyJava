package 자바_기본_문법;


public class LabelExam1 {
    public static void main(String[] args) {
        outter:
        for(int i=0; i<3; i++) {
            for(int k=0; k<3; k++) {
                if(i==0 && k ==2)
                    break outter;
                System.out.println(i+", "+k);
            }
        }
    }
}
