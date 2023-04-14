package test_report.position;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        System.out.print("请输入二维数组的行数和列数：");
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();

        System.out.println("请输入数组的元素：");
        double[][] num = new double[row][column];
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                num[i][j] = scanner.nextDouble();
            }
        }
        scanner.close();

        // Location location /* = new Location() */;
        // location = Location.LocationLargetst(num);
        Location location = Location.LocationLargetst(num);
        System.out.print("最大元素及其下标是：" + location.maxValue + " ");
        System.out.println("在(" + location.row + "," + location.column + ")");
    }
}
