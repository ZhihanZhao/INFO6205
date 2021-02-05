package edu.neu.coe.info6205.sort.simple;

import edu.neu.coe.info6205.sort.GenericSort;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import io.cucumber.java.en_pirate.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class SortTime {

    @Test
    public void SortTime() {

        final int N = 100;
        List<Double> randomSortedTime = new ArrayList<>();
        List<Double> orderedSortedTime = new ArrayList<>();
        List<Double> partiallyOrderedSortedTime = new ArrayList<>();
        List<Double> reverseOrderedSortedTime = new ArrayList<>();

        for (int n = 100; n <= N * Math.pow(2, 5); n = n * 2) {

            // random
            List<Integer> randomList = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < n; i++) {
                randomList.add(random.nextInt(n));
            }


            // ordered
            List<Integer> orderedList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                orderedList.add(i);
            }


            // partially-ordered
            List<Integer> partiallyOrderedList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (n < n / 2) {
                    partiallyOrderedList.add(i);
                } else {
                    partiallyOrderedList.add((random.nextInt(n)));
                }
            }


            // reverse-ordered
            List<Integer> reverseOrderedList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                reverseOrderedList.add(n - i);
            }


            // sort random list
            GenericSort insertionSort = new InsertionSort();
            util.Benchmark<Integer> benchmark = new Benchmark_Timer<>("hw2 part3 test start...",
                    blank -> {
                        insertionSort.sort(randomList);
                    });
            benchmark.run(0, 10);
            double res = 0;
            for (int i = 0; i < 10; i++) {
                res += benchmark.run(0, 10);
            }
            randomSortedTime.add(res / 10);

            // sort ordered list
            benchmark = new Benchmark_Timer<>("hw2 part3 test start...",
                    blank -> {
                        insertionSort.sort(orderedList);
                    });
            benchmark.run(0, 10);
            res = 0;
            for (int i = 0; i < 10; i++) {
                res += benchmark.run(0, 10);
            }
            orderedSortedTime.add(res / 10);

            // sort partially-ordered list
            benchmark = new Benchmark_Timer<>("hw2 part3 test start...",
                    blank -> {
                        insertionSort.sort(partiallyOrderedList);
                    });
            benchmark.run(0, 10);
            res = 0;
            for (int i = 0; i < 10; i++) {
                res += benchmark.run(0, 10);
            }
            partiallyOrderedSortedTime.add(res / 10);

            // sort reverse order list
            benchmark = new Benchmark_Timer<>("hw2 part3 test start...",
                    blank -> {
                        insertionSort.sort(reverseOrderedList);
                    });
            benchmark.run(0, 10);
            res = 0;
            for (int i = 0; i < 10; i++) {
                res += benchmark.run(0, 10);
            }
            reverseOrderedSortedTime.add(res / 10);
        }

        System.out.println("RandomSortedTime:"+randomSortedTime);
        System.out.println("PartiallyOrderedSortedTime:"+partiallyOrderedSortedTime);
        System.out.println("OrderedSortedTime:"+orderedSortedTime);
        System.out.println("ReverseOrderedSortedTime:"+reverseOrderedSortedTime);


    }

}
