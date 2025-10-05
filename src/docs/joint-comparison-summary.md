# Joint Comparison Summary: Insertion Sort vs. Selection Sort

**Authors:** Shomanov Rakhat, Nauryzbai Tomiris
**Pair:** Pair 1: Basic Quadratic Sorts

## 1. Introduction

This document provides a comparative analysis of two fundamental quadratic sorting algorithms: **Insertion Sort** and **Selection Sort**. The goal of this summary is to compare their theoretical complexity, analyze their empirical performance on various datasets, and provide a conclusive recommendation for their use in practical scenarios.

---

## 2. Theoretical Complexity Analysis

Both algorithms are in-place sorts with a quadratic time complexity in the average and worst cases, but they exhibit significant differences in their operational characteristics.

| Complexity Metric | Binary Insertion Sort | Selection Sort | Analysis |
| :--- | :--- | :--- | :--- |
| **Time: Best Case** | `Ω(n log n)` comparisons, `Ω(n)` shifts | `Θ(n^2)` comparisons, `Θ(n)` swaps | Insertion Sort is significantly faster on sorted or nearly-sorted data because binary search finds the insertion point quickly and few shifts are needed. Selection Sort's performance does not improve on sorted data as it still scans the entire unsorted portion. |
| **Time: Average Case** | `Θ(n^2)` | `Θ(n^2)` | Both algorithms are quadratic. Insertion Sort performs `O(n^2)` comparisons and shifts. Selection Sort consistently performs `Θ(n^2)` comparisons to find the minimum element in each pass. |
| **Time: Worst Case** | `O(n^2)` | `O(n^2)` | The worst case for both occurs on a reverse-sorted array. Insertion Sort must shift every element at each step. Selection Sort's performance remains unchanged. |
| **Space Complexity** | `O(1)` | `O(1)` | Both are in-place algorithms and require only a constant amount of extra memory for temporary variables. |
| **Number of Swaps** | `O(n^2)` in the worst case | `O(n)` | This is the key advantage of Selection Sort. It performs exactly `n-1` swaps, making it ideal for scenarios where write operations are significantly more expensive than read operations. |

---

## 3. Empirical Performance Analysis

For our empirical analysis, we ran benchmarks on both implementations with input sizes `n = 100, 1000, 10000, 100000` across four data types: `random`, `sorted`, `reversed`, and `nearly` sorted.

### Performance on Random Data

**Analysis:**
On random data, both algorithms demonstrate a clear `O(n^2)` growth curve. As predicted by theory, their performance is comparable, though constant factors in the implementation may cause one to be slightly faster than the other. Typically, Insertion Sort tends to outperform Selection Sort in practice due to better cache performance and fewer comparisons on average.

### Performance on Sorted & Nearly Sorted Data


**Analysis:**
This is where Binary Insertion Sort shows its strength. On `nearly` sorted data, its performance is significantly better than Selection Sort's, approaching `O(n log n)`. For `sorted` data, the number of shifts is minimal, and it performs exceptionally well. Selection Sort shows no performance improvement, as its number of comparisons remains `Θ(n^2)` regardless of the input's initial order.

### Performance on Reversed Data (Worst Case)


**Analysis:**
Both algorithms show their worst performance on reverse-sorted data, aligning with the `O(n^2)` theoretical complexity. Here, Insertion Sort must perform the maximum number of shifts for each element, and its performance is often comparable to or slightly worse than Selection Sort.

---

## 4. Strengths, Weaknesses, and Optimization Impact

### Insertion Sort

* **Strengths:**
    * **Extremely efficient for nearly sorted data.** This makes it an excellent choice for scenarios where new data is periodically added to an already sorted list.
    * **Stable sort**, which is a critical requirement for certain applications.
    * Good performance on small datasets.
* **Weaknesses:**
    * `O(n^2)` performance in the average and worst cases, making it unsuitable for large, unsorted arrays.
    * The `O(n^2)` element shifts are expensive and can lead to poor cache performance.
* **Optimization Impact (Binary Search):** The use of binary search successfully reduced the number of comparisons from `O(n)` to `O(log n)` per insertion. However, it does not change the overall worst-case time complexity due to the `O(n)` cost of shifting elements.

### Selection Sort

* **Strengths:**
    * **Minimal number of swaps (`n-1`).** This is its most significant advantage, especially if write operations are costly (e.g., writing to flash memory).
    * Its performance is predictable and does not degrade further on pathological inputs (it's always `Θ(n^2)`).
* **Weaknesses:**
    * **Always slow.** It never takes advantage of partially sorted data.
    * **Unstable sort.**
* **Optimization Impact (Early Termination):** The optimization to terminate early if the remainder of the array is already sorted has a negligible effect in most cases, as it only benefits inputs that are already sorted from some point `k` to the end. It does not change the overall `Θ(n^2)` complexity.

---

## 5. Conclusion and Recommendations

Both Binary Insertion Sort and Selection Sort are simple to implement but are inefficient for large datasets due to their quadratic time complexity.

Our joint analysis leads to the following recommendations:

* **Choose Binary Insertion Sort** when:
    * The input array is **small**.
    * The input is **nearly sorted** or is expected to be.
    * **Stability** is a requirement.

* **Choose Selection Sort** when:
    * The cost of **writing to memory is very high** and minimizing swaps is the top priority.
    * A simple, predictable, but slow algorithm is acceptable for all cases.

For general-purpose sorting of large, unsorted arrays, neither algorithm is recommended. More advanced algorithms like **Merge Sort**, **Heap Sort**, or **Quick Sort**, which have an average time complexity of `O(n log n)`, would be far more suitable.