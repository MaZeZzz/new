package multithread.forkjoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class QuickSort{
    private static int partition(Long[] numbers, int low, int high){
        Long solider = numbers[low];
        while (low<high){
            while (low<high){
                if (numbers[high] < solider) {
                    numbers[low] = numbers [high];
                    break;
                }
                high--;
            }
            while (low< high){
                if (numbers[low] > solider) {
                    numbers[high] = numbers[low];
                    break;
                }
                low++;
            }
        }
        numbers[low] = solider;
        return low;
    }

    public static void qsort(Long[] numbers, int low, int high){
        if (low < high) {
            int solider = partition(numbers, low, high);
            qsort(numbers,low,solider-1);
            qsort(numbers,solider+1,high);
        }
    }
}

class ParallelQuickSort extends RecursiveAction{

    private int threahold = 30;
    private int low;
    private int high;
    private Long[] numbers;

    private static int partition(Long[] numbers, int low, int high){
        Long solider = numbers[low];
        while (low<high){
            while (low<high){
                if (numbers[high] < solider) {
                    numbers[low] = numbers [high];
                    break;
                }
                high--;
            }
            while (low< high){
                if (numbers[low] > solider) {
                    numbers[high] = numbers[low];
                    break;
                }
                low++;
            }
        }
        numbers[low] = solider;
        return low;
    }

    public ParallelQuickSort(int threahold, Long[] numbers) {
        this.threahold = threahold;
        this.low = 0;
        this.high = numbers.length - 1;
        this.numbers = numbers;
    }

    public ParallelQuickSort(int low, int high, Long[] numbers) {
        this.low = low;
        this.high = high;
        this.numbers = numbers;
    }

    @Override
    protected void compute() {
        if (high - low < threahold){
            QuickSort.qsort(numbers,low,high);
        }else{ 
            int solider = partition(numbers,low,high);
            ParallelQuickSort left = new ParallelQuickSort(low,solider-1,numbers);
            ParallelQuickSort right = new ParallelQuickSort(low,solider+1,numbers);
            invokeAll(left,right);
        }
    }
}


public class MainSort {
    private static Long[] generateRamdomNumbers(int n){
        Random random = new Random();
        Long[] numbers = new Long[n];

        for (int i = 0; i<n; i++){
            Long num = random.nextLong();
            if (num < 0) {
                num = Math.abs(num);
            }
            numbers[i] = num;
        }
        return numbers;
    }
    
    
    public static void main(String[] args) {
        final int Run_times = 10;
        final int Sort_Num = 10000000;
        
        final int ThreadShold = 36200;

        Long startTime;

        for (int i = 0; i<Run_times + 1; i++){
            System.out.println("The " + i + " run :");
            System.out.println("Generating " + Sort_Num + "numbers");

            Long[] qsNumbers = generateRamdomNumbers(Sort_Num);
            System.out.println("Executing Quicksort");
            startTime = System.currentTimeMillis();
            QuickSort.qsort(qsNumbers,0,qsNumbers.length-1);
            Long qsRunTime = System.currentTimeMillis() - startTime;
            System.out.println("Total use: " + qsRunTime + "ms");
            
            Long[] pqsNumbers = generateRamdomNumbers(Sort_Num);
            System.out.println("Executing Parallel QuickSort");
            ForkJoinPool pool = new ForkJoinPool();
            ParallelQuickSort parallelQuickSort = new ParallelQuickSort(ThreadShold, pqsNumbers);
            startTime = System.currentTimeMillis();
            pool.execute(parallelQuickSort);
            while (!parallelQuickSort.isDone()){}
            Long pqsRunTime = System.currentTimeMillis() - startTime;
            System.out.println("Total use: " + pqsRunTime + "ms\n");
        }
    }
}
