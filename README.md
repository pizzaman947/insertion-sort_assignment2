# Assignment 2 — Insertion Sort Implementation

This repository contains an optimized implementation of the **Insertion Sort** algorithm with detailed **performance tracking** and **benchmarking** tools.  
The project demonstrates proper algorithmic analysis, clean code principles, and the use of the **Bridge** design pattern for metric tracking.

---

## 🎯 Goal
Implement and analyze the performance of the **Insertion Sort** algorithm, focusing on:
- Algorithmic efficiency and time complexity analysis  
- Proper use of object-oriented principles  
- Benchmarking and visualization of runtime performance  

---

## 🧠 Algorithmic Analysis

The implemented algorithm is a **Binary Insertion Sort**, which improves upon the classic insertion sort by using binary search to find the correct insertion position for each element.

| Case | Description | Time Complexity | Space Complexity |
|------|--------------|-----------------|------------------|
| **Best Case** | Already sorted array | **O(n)** | **O(1)** |
| **Average Case** | Random array | **O(n²)** | **O(1)** |
| **Worst Case** | Reverse sorted array | **O(n²)** | **O(1)** |

---

## ⚙️ Features
- ✅ **Binary Insertion Sort** (optimized version)  
- 🧩 **Bridge pattern** for separating sorting logic and metric tracking  
- 📊 **Performance metrics** — comparisons, swaps, array accesses  
- 🚀 **Benchmark runner** for analyzing runtime on different input sizes  
- 🧪 **JUnit 5 tests** for validation and reliability  

---

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

---

## 🧾 Example Output

```
Benchmark Results for n = 10000
Comparisons: 49872
Swaps: 49012
Array Accesses: 99124
Execution Time: 84 ms
```

---

## 🧪 Testing
The project uses **JUnit 5** for validation of sorting correctness across:
- Empty arrays
- Already sorted arrays
- Reverse-sorted arrays
- Randomly generated arrays

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

