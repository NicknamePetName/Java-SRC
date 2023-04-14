package os.fourmethod;
import java.util.Scanner;

public class FCFS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("请输入进程数：");
        int n = input.nextInt();

        int[] processTime = new int[n]; // 存储每个进程的执行时间
        int[] waitTime = new int[n]; // 存储每个进程的等待时间
        int[] turnaroundTime = new int[n]; // 存储每个进程的周转时间

        for (int i = 0; i < n; i++) {
            System.out.print("请输入进程" + (i + 1) + "的执行时间：");
            processTime[i] = input.nextInt();
        }

        //关闭输入
        input.close();
        
        // 计算每个进程的等待时间和周转时间
        int sum = 0;
        for (int i = 0; i < n; i++) {
            waitTime[i] = sum;
            turnaroundTime[i] = sum + processTime[i];
            sum += processTime[i];
        }

        // 输出每个进程的等待时间和周转时间
        System.out.println("进程\t执行时间\t等待时间\t周转时间");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "\t\t" + processTime[i] + "\t\t" + waitTime[i] + "\t\t" + turnaroundTime[i]);
        }
    }
}
