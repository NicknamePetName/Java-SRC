package test;

public class Test {
       public static void main(String args[]) {
              String hello = "你好";
              String testOne = "你" + "好"; // 【代码1】
              int address = System.identityHashCode("你好");
              System.out.printf("\"你好\"的引用:%x\n", address);
              address = System.identityHashCode(hello);
              System.out.printf("hello的引用:%x\n", address);
              address = System.identityHashCode(testOne);
              System.out.printf("testOne的引用:%x\n", address);
              System.out.println(hello == testOne); // 输出结果是true
              System.out.println("你好" == testOne); // 输出结果是true
              System.out.println("你好" == hello); // 输出结果是true
              String you = "你";
              String hi = "好";
              String testTwo = you + hi; // 【代码2】
              address = System.identityHashCode("你");
              System.out.printf("\"你\"的引用:%x\n", address);
              address = System.identityHashCode("好");
              System.out.printf("\"好\"的引用:%x\n", address);
              address = System.identityHashCode(testTwo);
              System.out.printf("testTwo的引用:%x\n", address);
              System.out.println(hello == testTwo); // 输出结果是false
       }
}
