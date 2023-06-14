package JavaIO.decorator;

public abstract class ShapeDecorator extends Shape {
    protected Shape decoratedShape;


    // 내가 장식 할 대상을 생성자로 받아들임
    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    public void draw() {
        decoratedShape.draw();
    }
}
