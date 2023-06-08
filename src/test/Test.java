package test;

public class Test {
   public static void main(String[] args) {
      Circle circle = new Circle(5);
      Triangle triangle = new Triangle(3, 4, 5);
      Pillar pillar = new Pillar(circle, 1);
      Pillar pillar2 = new Pillar(triangle, 1);
      System.out.println(pillar.getVolume());
      System.out.println(pillar2.getVolume());
   }
}
