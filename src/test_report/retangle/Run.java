package test_report.retangle;

public class Run {
    public static void main(String[] args) {
        Rectangle rectangleOne = new Rectangle(4,40);
        Rectangle rectangleTwo = new Rectangle(3.5,35.9);

        System.out.println("宽："+rectangleOne.getWidth()); 
        System.out.println("高："+rectangleOne.getHeight()); 
        System.out.println("面积："+rectangleOne.getArea()); 
        System.out.println("周长："+rectangleOne.getPerimeter()); 

        System.out.println("宽："+rectangleTwo.getWidth()); 
        System.out.println("高："+rectangleTwo.getHeight()); 
        System.out.println("面积："+rectangleTwo.getArea()); 
        System.out.println("周长："+rectangleTwo.getPerimeter()); 
    }
}
