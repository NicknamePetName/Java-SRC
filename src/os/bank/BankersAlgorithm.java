package os.bank;

import java.util.*;

public class BankersAlgorithm {
    private int[][] need;
    private int[][] allocation;
    private int[] available;
    private int numberOfProcesses;
    private int numberOfResources;

    public BankersAlgorithm(int[][] need, int[][] allocation, int[] available) {
        this.need = need;
        this.allocation = allocation;
        this.available = available;
        this.numberOfProcesses = need.length;
        this.numberOfResources = available.length;
    }

    public boolean isSafe() {
        boolean[] finished = new boolean[numberOfProcesses];
        int[] work = Arrays.copyOf(available, numberOfResources);

        while (true) {
            boolean found = false;
            for (int i = 0; i < numberOfProcesses; i++) {
                if (!finished[i] && canFinish(i, work)) {
                    found = true;
                    finished[i] = true;
                    for (int j = 0; j < numberOfResources; j++) {
                        work[j] += allocation[i][j];
                    }
                }
            }
            if (!found) {
                break;
            }
        }
        for (boolean f : finished) {
            if (!f) {
                return false;
            }
        }
        return true;
    }

    private boolean canFinish(int process, int[] work) {
        for (int i = 0; i < numberOfResources; i++) {
            if (need[process][i] > work[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] allocation = {{0, 1, 0}, {2, 0, 0}, {3, 0, 2}, {2, 1, 1}, {0, 0, 2}};
        int[][] need = {{7, 4, 3}, {1, 2, 2}, {6, 0, 0}, {0, 1, 1}, {4, 3, 1}};
        int[] available = {3, 3, 2};
        BankersAlgorithm bankersAlgorithm = new BankersAlgorithm(need, allocation, available);
        if (bankersAlgorithm.isSafe()) {
            System.out.println("The state is safe.");
        } else {
            System.out.println("The state is unsafe.");
        }
    }
}
