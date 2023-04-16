package se.design_philosophy.lsp;

/* 由于 Shape 类是一个抽象类，它不能被实例化。因此，我们可以定义一个数组，
用来存储不同的形状对象。然后，我们可以使用循环来遍历数组，计算每个形状的面积，
并将结果输出到控制台。 */

public class Process {
    public static void main(String[] args) {
        AbstractShape[] shapes = new AbstractShape[2];
        shapes[0] = new Rectangle(5, 10);
        shapes[1] = new Triangle(6, 8);
        
        for (AbstractShape shape : shapes) {
            double area = shape.calculateArea();
            System.out.println("The area of the shape is: " + area);
        }
    }    
}


/* 这个主函数创建了一个包含两个元素的 Shape 类型的数组，分别表示一个矩形和一个三角形。
然后，它使用 for 循环遍历数组中的每个元素，并调用它们的 calculateArea() 方法来计算面积。
最后，它将计算结果输出到控制台。这样，我们就可以使用一个统一的接口来处理不同类型的对象，
而不必关心它们的具体实现。 */