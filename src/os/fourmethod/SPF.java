package os.fourmethod;

import java.util.Scanner;

public class SPF {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("请输入进程数：");
        int n = input.nextInt();

        int[] processTime = new int[n]; // 存储每个进程的执行时间
        int[] arrivalTime = new int[n]; // 存储每个进程的到达时间
        int[] waitTime = new int[n]; // 存储每个进程的等待时间
        int[] turnaroundTime = new int[n]; // 存储每个进程的周转时间
        boolean[] isCompleted = new boolean[n]; // 存储每个进程是否完成


        for (int i = 0; i < n; i++) {
            System.out.print("请输入进程" + (i + 1) + "的到达时间：");
            arrivalTime[i] = input.nextInt();

            System.out.print("请输入进程" + (i + 1) + "的执行时间：");
            processTime[i] = input.nextInt();

            isCompleted[i] = false;
        }

        //关闭输入
        input.close();

        int currentTime = 0; // 当前时间
        int completed = 0; // 完成的进程数

        while (completed != n) {
            int shortestProcess = -1; // 最短进程的编号
            int shortestProcessTime = Integer.MAX_VALUE; // 最短进程的执行时间

            // 找到当前时间可以运行的最短进程
            for (int i = 0; i < n; i++) {
                if (!isCompleted[i] && arrivalTime[i] <= currentTime && processTime[i] < shortestProcessTime) {
                    shortestProcess = i;
                    shortestProcessTime = processTime[i];
                }
            }

            // 如果找到了最短进程，则运行它
            if (shortestProcess != -1) {
                waitTime[shortestProcess] = currentTime - arrivalTime[shortestProcess];
                turnaroundTime[shortestProcess] = waitTime[shortestProcess] + processTime[shortestProcess];
                isCompleted[shortestProcess] = true;
                completed++;
                currentTime += processTime[shortestProcess];
            }
            // 如果没有找到最短进程，则时间加1
            else {
                currentTime++;
            }
        }

        // 输出每个进程的等待时间和周转时间
        System.out.println("进程\t到达时间\t执行时间\t等待时间\t周转时间");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "\t\t" + arrivalTime[i] + "\t\t" + processTime[i] + "\t\t" + waitTime[i] + "\t\t" + turnaroundTime[i]);
        }
    }
}
