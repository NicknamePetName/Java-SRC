package os.fourmethod;

import java.util.Scanner;

public class PR {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("请输入进程数：");
        int n = input.nextInt();

        int[] processTime = new int[n]; // 存储每个进程的执行时间
        int[] priority = new int[n]; // 存储每个进程的优先级
        int[] waitTime = new int[n]; // 存储每个进程的等待时间
        int[] turnaroundTime = new int[n]; // 存储每个进程的周转时间

        for (int i = 0; i < n; i++) {
            System.out.print("请输入进程" + (i + 1) + "的执行时间：");
            processTime[i] = input.nextInt();

            System.out.print("请输入进程" + (i + 1) + "的优先级：");
            priority[i] = input.nextInt();
        }
        
        //关闭输入
        input.close();


        // 对进程按优先级进行排序
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (priority[i] > priority[j]) {
                    int temp = priority[i];
                    priority[i] = priority[j];
                    priority[j] = temp;

                    temp = processTime[i];
                    processTime[i] = processTime[j];
                    processTime[j] = temp;
                }
            }
        }

        // 计算每个进程的等待时间和周转时间
        int sum = 0;
        for (int i = 0; i < n; i++) {
            waitTime[i] = sum;
            turnaroundTime[i] = sum + processTime[i];
            sum += processTime[i];
        }

        // 输出每个进程的等待时间和周转时间
        System.out.println("进程\t执行时间\t优先级\t等待时间\t周转时间");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "\t\t" + processTime[i] + "\t\t" + priority[i] + "\t\t" + waitTime[i] + "\t\t" + turnaroundTime[i]);
        }
    }
}
