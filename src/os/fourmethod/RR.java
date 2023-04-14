package os.fourmethod;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RR {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("请输入时间片大小：");
        int timeQuantum = input.nextInt();

        System.out.print("请输入进程数：");
        int n = input.nextInt();

        Queue<Integer> readyQueue = new LinkedList<>(); // 存储就绪队列
        int[] processTime = new int[n]; // 存储每个进程的执行时间
        int[] arrivalTime = new int[n]; // 存储每个进程的到达时间
        int[] waitTime = new int[n]; // 存储每个进程的等待时间
        int[] turnaroundTime = new int[n]; // 存储每个进程的周转时间


        for (int i = 0; i < n; i++) {
            System.out.print("请输入进程" + (i + 1) + "的到达时间：");
            arrivalTime[i] = input.nextInt();

            System.out.print("请输入进程" + (i + 1) + "的执行时间：");
            processTime[i] = input.nextInt();

            waitTime[i] = 0;
            turnaroundTime[i] = 0;
        }

        //关闭输入
        input.close();

        int currentTime = 0; // 当前时间
        int completed = 0; // 完成的进程数

        while (completed != n) {
            // 将到达时间小于等于当前时间的进程加入就绪队列
            for (int i = 0; i < n; i++) {
                if (arrivalTime[i] <= currentTime) {
                    readyQueue.add(i);
                }
            }

            // 如果就绪队列不为空，取出队头进程运行
            if (!readyQueue.isEmpty()) {
                int process = readyQueue.poll();

                // 如果进程的执行时间小于时间片大小，直接运行到完成
                if (processTime[process] <= timeQuantum) {
                    waitTime[process] = currentTime - arrivalTime[process];
                    turnaroundTime[process] = waitTime[process] + processTime[process];
                    currentTime += processTime[process];
                    processTime[process] = 0;
                    completed++;
                }
                // 如果进程的执行时间大于时间片大小，运行一段时间后加入就绪队列等待下次运行
                else {
                    waitTime[process] = currentTime - arrivalTime[process];
                    processTime[process] -= timeQuantum;
                    currentTime += timeQuantum;
                    readyQueue.add(process);
                }
            }
            // 如果就绪队列为空，时间加1
            else {
                currentTime++;
            }
        }

        // 输出每个进程的等待时间和周转时间
        System.out.println("进程\t到达时间\t执行时间\t等待时间\t周转时间");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "\t\t" + arrivalTime[i] + "\t\t" + processTime[i] + "\t\t\t" + waitTime[i]
                    + "\t\t" + turnaroundTime[i]);
        }
        // 计算平均等待时间和平均周转时间
        double averageWaitTime = 0;
        double averageTurnaroundTime = 0;
        for (int i = 0; i < n; i++) {
            averageWaitTime += waitTime[i];
            averageTurnaroundTime += turnaroundTime[i];
        }
        averageWaitTime /= n;
        averageTurnaroundTime /= n;

        System.out.println("平均等待时间为：" + averageWaitTime);
        System.out.println("平均周转时间为：" + averageTurnaroundTime);
    }

}
