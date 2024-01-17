package class2;

import java.util.Arrays;

/**
 * ClassName: Algo_001_Social_Simulation
 * Package: PACKAGE_NAME
 * CreateTime: 2024/1/17 15:41
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */


public class Algo_002_Social_Simulation {

    public static void main (String[] args) {
        // 计算基尼系数
        int people = 100;
        int round = 100000;
        doExperiment(people, round);
        System.out.println("The experiment is over.");
    }

    public static void doExperiment (int n, int t) {
        double[] wealth = new double[n];
        Arrays.fill(wealth, 100);
        boolean[] hasMoney = new boolean[n];
        for (int i = 0; i < t; i++) {
            Arrays.fill(hasMoney, false);
            for (int j = 0; j < n; j++) {
                if (wealth[j] > 0) {
                    hasMoney[j] = true;
                }
            }
            for (int j = 0; j < n; j++) {
                if (hasMoney[j]) {
                    int other = j;
                    do {
                        other = (int) (Math.random() * n);
                    } while (other == j);
                    wealth[j]--;
                    wealth[other]++;
                }
            }
        }
        Arrays.sort(wealth);
        System.out.println("All people's wealth:");
        for (int i = 0; i < n; i++) {
            System.out.print((int)wealth[i] + " ");
            if (i % 10 == 9) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("The Gini is: " + calculateGini(wealth));
    }

    public static double calculateGini(double[] wealth) {
        double sumOfWealth = 0.0;
        double sumOfAbsoluteDiff = 0.0;
        int n = wealth.length;
        for (int i = 0; i < n; i++) {
            sumOfWealth += wealth[i];
            for (int j = 0; j < n; j++) {
                sumOfAbsoluteDiff += Math.abs(wealth[i] - wealth[j]);
            }
        }
        return sumOfAbsoluteDiff / (2 * n * sumOfWealth);
    }
}
