package edu.neu.coe.info6205.union_find;;
import edu.neu.coe.info6205.util.Benchmark;
import edu.neu.coe.info6205.util.Benchmark_Timer;

import java.util.Random;

public class Benchmark2 {
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

    public static void WQUPC_Benchmark(final int N){
        WQUPC wqupc = new WQUPC(N);
        Random random = new Random();

        while (wqupc.count()!=1){
            int p = random.nextInt(N);
            int q = random.nextInt(N);

            if(!wqupc.connected(p,q)){
                wqupc.union(p,q);
            }
        }
    }

    public static void main(String[] args) {
        Benchmark<Integer> benchmark_WQU_Run = new Benchmark_Timer<>("WeightedUnionFindRun 10000", black -> {
            WQU_Benchmark(10000);
        });
        System.out.printf("N = 10000, run time is %.2f milliseconds\n",benchmark_WQU_Run.run(0,1000));


        Benchmark<Integer> benchmark_WQUPC_Run = new Benchmark_Timer<>("WeightedUnionFindRun 10000", black -> {
            WQUPC_Benchmark(10000);
        });
        System.out.printf("N = 10000, run time is %.2f milliseconds\n",benchmark_WQUPC_Run.run(0,1000));

    }


}
