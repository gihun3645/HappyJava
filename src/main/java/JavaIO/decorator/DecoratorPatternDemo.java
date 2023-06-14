package JavaIO.decorator;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class DecoratorPatternDemo {
    public static void main(String[] args) throws Exception {
//        Circle circle = new Circle();
//
//
//        // 장식을 하고 싶당
//        RedShapeDecorator redShapeDecorator = new RedShapeDecorator(circle);
////        redShapeDecorator.draw();
//
//        GreenShapeDecorator greenShapeDecorator = new GreenShapeDecorator(redShapeDecorator);
//        greenShapeDecorator.draw();

        Shape shape = new GreenShapeDecorator(new RedShapeDecorator(new Rectangle()));
        shape.draw();

        // Shape ==> InputStream (추상 클래스)
        // Rectangle ==> FileInputStream
        InputStream in = new DataInputStream(new FileInputStream("a.txt"));
    }
}
