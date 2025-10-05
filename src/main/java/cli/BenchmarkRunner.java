package cli;

import algorithms.InsertionSort;
import java.util.*;

public class BenchmarkRunner {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java -jar insertion-sort.jar <array_size> <input_type>");
            System.out.println("Example: java -jar insertion-sort.jar 10000 random");
            return;
        }

        int n = Integer.parseInt(args[0]);
        String type = args[1];
        int[] arr = generateArray(n, type);

        long start = System.nanoTime();
        InsertionSort.sort(arr);
        long end = System.nanoTime();

        System.out.println("Array sorted (" + type + ", n=" + n + ")");
        System.out.println("Time: " + (end - start) / 1_000_000.0 + " ms");
    }

    private static int[] generateArray(int n, String type) {
        Random rand = new Random();
        int[] arr = new int[n];

        switch (type.toLowerCase()) {
            case "sorted":
                for (int i = 0; i < n; i++) arr[i] = i;
                break;
            case "reversed":
                for (int i = 0; i < n; i++) arr[i] = n - i;
                break;
            case "nearly":
                for (int i = 0; i < n; i++) arr[i] = i;
                for (int i = 0; i < n / 10; i++) {
                    int a = rand.nextInt(n), b = rand.nextInt(n);
                    int tmp = arr[a]; arr[a] = arr[b]; arr[b] = tmp;
                }
                break;
            default:
                for (int i = 0; i < n; i++) arr[i] = rand.nextInt(n);
        }
        return arr;
    }
}
