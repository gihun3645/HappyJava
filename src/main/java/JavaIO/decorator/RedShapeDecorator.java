package JavaIO.decorator;

public class RedShapeDecorator extends ShapeDecorator{

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape) {
        System.out.println("Red ================  Start ");

        decoratedShape.draw();

        System.out.println("Red ================  End ");
    }
}
