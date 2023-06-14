package JavaIO.decorator;

public class GreenShapeDecorator extends ShapeDecorator{

    public GreenShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape) {
        System.out.println("Green ***************  Start ");

        decoratedShape.draw();

        System.out.println("Green **************  End ");
    }
}
