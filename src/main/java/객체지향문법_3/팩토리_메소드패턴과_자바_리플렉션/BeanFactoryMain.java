package 객체지향문법_3.팩토리_메소드패턴과_자바_리플렉션;

public class BeanFactoryMain {
    public static void main(String[] args) {
//        BeanFactory bf1 = new BeanFactory();
//        BeanFactory bf2 = new BeanFactory();
//        BeanFactory bf3 = new BeanFactory();
//        BeanFactory bf4 = new BeanFactory();
//        BeanFactory bf5 = new BeanFactory();

//        BeanFactory.instance = null;

        BeanFactory bf1 = BeanFactory.getInstance();
        BeanFactory bf2 = BeanFactory.getInstance();
        if(bf1 == bf2){
            System.out.println("bf1 == bf2");
        }

        // 객체의 생성과정은 BeanFactory 라는 객체를 통해 맡김
        Bus b1 = bf1.getBus();
        Bus b2 = bf1.getBus();

        // Bus b3 = new Bus();
    }
}
