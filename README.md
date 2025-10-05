# Assignment 2 — Insertion Sort Implementation

This repository contains a comprehensive implementation of the **Binary Insertion Sort** algorithm in Java, developed as part of an assignment on algorithmic analysis. The project includes **performance metric tracking**, a **command-line interface** for benchmarking, and thorough unit tests.

---

## 🎯 Goal
The goal of this project is to implement an optimized version of the **Insertion Sort** algorithm and analyze its performance. The implementation uses a binary search to find the correct insertion point for each element, reducing the number of comparisons compared to a classic linear scan. The project is instrumented with a **PerformanceTracker** to collect key metrics such as comparisons, swaps (insertions), and array accesses.

---
---

## ⚙️ Features
- ✅ **Optimized Insertion Sort**: Implemented using a binary search (Binary Insertion Sort) to minimize comparisons, making it efficient for nearly sorted data.
- 📊 **Performance metrics** — comparisons, swaps, array accesses  
- 🚀 **Benchmark runner** for analyzing runtime on different input sizes  
- 🧪 **JUnit 5 tests** for validation and reliability  

---

## 🧠 Algorithmic Analysis

The implemented algorithm is a **Binary Insertion Sort**, which improves upon the classic insertion sort by using binary search to find the correct insertion position for each element.

# Algorithmic Complexity
The implemented Binary Insertion Sort has the following theoretical complexity:

Time Complexity:

- Best Case: **Ω(n log n)** (for comparisons) and Ω(n) (for swaps) - Occurs on an already sorted array.

- Average Case: **Θ(n^2)** - The number of swaps remains quadratic.

- Worst Case: **O(n^2)** - Occurs on a reverse-sorted array due to the maximum number of element shifts required.

Space Complexity: **O(1)** - The sort is performed in-place, requiring no significant auxiliary space.


## 📁 Project Structure

```
assignment2-insertion-sort/
├── src/main/java/
│   ├── algorithms/InsertionSort.java
│   ├── metrics/PerformanceTracker.java
│   └── cli/BenchmarkRunner.java
├── src/test/java/
│   └── algorithms/InsertionSortTest.java
├── docs/
│   ├── analysis-report.pdf
│   └── performance-plots/
└── README.md
```

---

## 🧩 How to Build and Run

### 1️⃣ Compile and package
```bash
mvn clean package
```

### 2️⃣ Run tests
```bash
mvn test
```

### 3️⃣ Run benchmark
```bash
java -jar target/insertion-sort-1.0-SNAPSHOT.jar 10000 random
```
or using Maven:
```bash
mvn exec:java "-Dexec.args=10000 random"
```

### Available input_type values:
```
random: Array with randomly shuffled integers.

sorted: A pre-sorted array.

reversed: An array sorted in descending order.

nearly: A nearly sorted array with minor shuffling.
```
---

## 🧾 Example Output

```
Array sorted (random, n=10000)
Time: 18.7801 ms
Metrics -> Comparisons: 118981, Swaps/Insertions: 9999, Array Accesses: 49735255
Results saved to benchmarks/results.csv
```

---

## 🧪 Testing
The project uses **JUnit 5** for validation of sorting correctness across:
- Empty arrays
- Single element arrays
- Already sorted arrays
- Reverse-sorted arrays
- Duplicate elements arrays

To run tests:
```bash
mvn test

```

---

## 📚 Documentation
Detailed algorithmic analysis and performance visualization can be found in:
```
docs/analysis-report.pdf
docs/performance-plots/
```

---
### Author: Shomanov Rakhat (1st pair) - Insertion Sort (with optimizations for nearly-sorted data)
