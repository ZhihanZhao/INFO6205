package edu.neu.coe.info6205.union_find;

import edu.neu.coe.info6205.util.Benchmark;
import edu.neu.coe.info6205.util.Benchmark_Timer;

import java.util.Random;

public class Benchmark1 {

    public static void WQU_Benchmark(final int N){
        WQU wqu = new WQU(N);
        Random random = new Random();

        while (wqu.components()!=1){
            int p = random.nextInt(N);
            int q = random.nextInt(N);

            if(!wqu.connected(p,q)){
                wqu.union(p,q);
            }
        }
    }

    public static void WQU_Alter_Benchmark(final int N){
        WQU_Alter wqu_alter = new WQU_Alter(N);
        Random random = new Random();

        while (wqu_alter.components()!=1){
            int p = random.nextInt(N);
            int q = random.nextInt(N);

            if(!wqu_alter.connected(p,q)){
                wqu_alter.union(p,q);
            }
        }

    }

    public static void main(String[] args) {
        Benchmark<Integer> benchmark_WQU_Run = new Benchmark_Timer<>("WeightedUnionFindRun 10000", black -> {
            WQU_Benchmark(10000);
        });
        System.out.printf("N = 10000, run time is %.2f milliseconds\n",benchmark_WQU_Run.run(0,1000));

        Benchmark<Integer> benchmark_WQU_Alter_Run = new Benchmark_Timer<>("WeightedUnionFindRun 10000", black -> {
            WQU_Alter_Benchmark(10000);
        });
        System.out.printf("N = 10000, run time is %.2f milliseconds\n",benchmark_WQU_Alter_Run.run(0,1000));
    }

}
