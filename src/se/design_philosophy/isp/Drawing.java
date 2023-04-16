package se.design_philosophy.isp;

public class Drawing {
    private ICircleInterface iCircleInterface;
    private ITriangleInterface iTriangleInterface;
    private IRectangleInterface iRectangleInterface;

    public Drawing(ICircleInterface iCircleInterface, ITriangleInterface iTriangleInterface, IRectangleInterface iRectangleInterface) {
        this.iCircleInterface = iCircleInterface;
        this.iTriangleInterface = iTriangleInterface;
        this.iRectangleInterface = iRectangleInterface;
    }

    public void drawCircle() {
        iCircleInterface.drawCircle();
    }

    public void drawTriangle() {
        iTriangleInterface.drawTriangle();
    }

    public void drawRectangle() {
        iRectangleInterface.drawRectangle();
    }
}
