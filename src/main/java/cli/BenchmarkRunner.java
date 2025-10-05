package cli;

import algorithms.InsertionSort;
import metrics.PerformanceTracker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Locale;

public class BenchmarkRunner {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java -jar insertion-sort.jar <array_size> <input_type>");
            System.out.println("Input types: random, sorted, reversed, nearly");
            System.out.println("Example: java -jar insertion-sort.jar 10000 random");
            return;
        }

        int n = Integer.parseInt(args[0]);
        String type = args[1];
        int[] arr = generateArray(n, type);

        InsertionSort sorter = new InsertionSort();

        long start = System.nanoTime();
        sorter.sort(arr);
        long end = System.nanoTime();

        double timeMs = (end - start) / 1_000_000.0;
        PerformanceTracker tracker = sorter.getTracker();

        System.out.println("Array sorted (" + type + ", n=" + n + ")");
        System.out.println("Time: " + timeMs + " ms");
        System.out.println(tracker);

        saveResultsToCsv(n, type, timeMs, tracker);
    }

    private static void saveResultsToCsv(int n, String type, double timeMs, PerformanceTracker tracker) {
        String csvFile = "benchmarks/results.csv";
        File file = new File(csvFile);
        file.getParentFile().mkdirs(); 

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile, true))) {
            if (file.length() == 0) {
                writer.write("array_size,input_type,time_ms,comparisons,swaps,array_accesses\n");
            }
            String line = String.format(java.util.Locale.US, "%d,%s,%.4f,%d,%d,%d\n",
                    n,
                    type,
                    timeMs,
                    tracker.getComparisons(),
                    tracker.getSwaps(),
                    tracker.getArrayAccesses());
            writer.write(line);
            System.out.println("Results saved to " + csvFile);
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
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