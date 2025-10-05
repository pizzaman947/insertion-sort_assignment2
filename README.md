# Assignment 2 — Insertion Sort Implementation

This repository contains an optimized implementation of the Insertion Sort algorithm with performance tracking and benchmarking.

## Structure
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

## How to Run
1. Run tests: `mvn test`
2. Run benchmark: `mvn exec:java "-Dexec.args=100 random""`

## Features
- Binary Insertion Sort
- Early exit for nearly sorted data
- Performance metrics (comparisons, swaps, array accesses)
