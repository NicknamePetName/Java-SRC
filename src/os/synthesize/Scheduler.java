package os.synthesize;

import java.util.Arrays;
import java.util.Comparator;

class Process {
    int id; // 进程ID
    int arrivalTime; // 到达时间
    int burstTime; // 执行时间
    int priority; // 优先级
    int remainingTime; // 剩余执行时间
    int waitingTime; // 等待时间
    int turnaroundTime; // 周转时间

    public Process(int id, int arrivalTime, int burstTime, int priority) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
    }
}

public class Scheduler {
    // FCFS进程调度算法
    public static void fcfs(Process[] processes) {
        int n = processes.length;

        // 按照到达时间排序
        Arrays.sort(processes, Comparator.comparingInt(p -> p.arrivalTime));

        // 计算等待时间和周转时间
        int currentTime = 0;
        for (int i = 0; i < n; i++) {
            processes[i].waitingTime = currentTime - processes[i].arrivalTime;
            processes[i].turnaroundTime = processes[i].waitingTime + processes[i].burstTime;
            currentTime += processes[i].burstTime;
        }
    }

    // PR进程调度算法
    public static void pr(Process[] processes) {
        int n = processes.length;

        // 按照优先级和到达时间排序
        Arrays.sort(processes,
                Comparator.comparingInt((Process p) -> p.priority).reversed().thenComparingInt(p -> p.arrivalTime));

        // 计算等待时间和周转时间
        int currentTime = 0;
        while (true) {
            Process nextProcess = null;
            for (int i = 0; i < n; i++) {
                if (processes[i].remainingTime > 0 && processes[i].arrivalTime <= currentTime
                        && (nextProcess == null || processes[i].priority > nextProcess.priority)) {
                    nextProcess = processes[i];
                }
            }
            if (nextProcess == null) {
                break;
            }
            nextProcess.waitingTime = currentTime - nextProcess.arrivalTime;
            nextProcess.turnaroundTime = nextProcess.waitingTime + nextProcess.burstTime;
            currentTime += nextProcess.burstTime;
            nextProcess.remainingTime = 0;
        }
    }

    // SPF进程调度算法
    public static void spf(Process[] processes) {
        int n = processes.length;

        // 按照剩余执行时间和到达时间排序
        Arrays.sort(processes,
                Comparator.comparingInt((Process p) -> p.remainingTime).thenComparingInt(p -> p.arrivalTime));

        // 计算等待时间和周转时间
        int currentTime = 0;
        while (true) {
            Process nextProcess = null;
            for (int i = 0; i < n; i++) {
                if (processes[i].remainingTime > 0 && processes[i].arrivalTime <= currentTime
                        && (nextProcess == null || processes[i].remainingTime < nextProcess.remainingTime)) {
                    nextProcess = processes[i];
                }
            }
            if (nextProcess == null) {
                break;
            }
            nextProcess.waitingTime = currentTime - nextProcess.arrivalTime;
            nextProcess.turnaroundTime = nextProcess.waitingTime + nextProcess.burstTime;
            currentTime += nextProcess.burstTime;
            nextProcess.remainingTime = 0;
        }
    }

    // RR进程调度算法
    public static void rr(Process[] processes, int quantum) {
        int n = processes.length;

        // 按照到达时间排序
        Arrays.sort(processes, Comparator.comparingInt(p -> p.arrivalTime));

        // 计算等待时间和周转时间
        int currentTime = 0;
        int[] remainingTime = new int[n];
        for (int i = 0; i < n; i++) {
            remainingTime[i] = processes[i].burstTime;
        }
        while (true) {
            boolean done = true;
            for (int i = 0; i < n; i++) {
                if (remainingTime[i] > 0 && processes[i].arrivalTime <= currentTime) {
                    done = false;
                    if (remainingTime[i] > quantum) {
                        currentTime += quantum;
                        remainingTime[i] -= quantum;
                    } else {
                        currentTime += remainingTime[i];
                        processes[i].waitingTime = currentTime - processes[i].burstTime - processes[i].arrivalTime;
                        processes[i].turnaroundTime = processes[i].waitingTime + processes[i].burstTime;
                        remainingTime[i] = 0;
                    }
                }
            }
            if (done) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Process[] processes = new Process[5];
        processes[0] = new Process(1, 0, 10, 3);
        processes[1] = new Process(2, 1, 1, 2);
        processes[2] = new Process(3, 2, 2, 1);
        processes[3] = new Process(4, 3, 1, 4);
        processes[4] = new Process(5, 4, 5, 5);

        System.out.println("FCFS:");
        fcfs(processes);
        printProcessInfo(processes);

        System.out.println("PR:");
        pr(processes);
        printProcessInfo(processes);

        System.out.println("SPF:");
        spf(processes);
        printProcessInfo(processes);

        System.out.println("RR:");
        rr(processes, 2);
        printProcessInfo(processes);
    }

    public static void printProcessInfo(Process[] processes) {
        int n = processes.length;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        for (int i = 0; i < n; i++) {
            totalWaitingTime += processes[i].waitingTime;
            totalTurnaroundTime += processes[i].turnaroundTime;
            System.out.printf("Process %d: waiting time = %d, turnaround time = %d\n", processes[i].id,
                    processes[i].waitingTime, processes[i].turnaroundTime);
        }
        double avgWaitingTime = (double) totalWaitingTime / n;
        double avgTurnaroundTime = (double) totalTurnaroundTime / n;
        System.out.printf("Average waiting time = %.2f, average turnaround time = %.2f\n", avgWaitingTime,
                avgTurnaroundTime);
    }
}
