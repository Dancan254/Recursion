# Bubble Sort

Bubble Sort is a simple sorting algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. The process continues until the entire list is sorted.

## Table of Contents

- [Bubble Sort](#bubble-sort)
  - [Table of Contents](#table-of-contents)
  - [Overview](#overview)
  - [Algorithm Explanation](#algorithm-explanation)
  - [Pseudocode](#pseudocode)
    - [Explanation](#explanation)
  - [Implementation in Java](#implementation-in-java)
    - [Explanation](#explanation-1)
  - [Complexity Analysis](#complexity-analysis)
  - [Optimization](#optimization)
    - [Early Exit](#early-exit)
  - [Example Walkthrough](#example-walkthrough)
  - [Applications and Limitations](#applications-and-limitations)
    - [Applications](#applications)
    - [Limitations](#limitations)

---

## Overview

**Bubble Sort** repeatedly traverses a list, comparing each pair of adjacent elements and swapping them if they are out of order. This method is called "bubble" sort because with each pass, the largest element "bubbles up" to its correct position at the end of the list, similar to how bubbles rise to the surface.

**Characteristics**:

- **Type**: Comparison-based sorting algorithm
- **Best for**: Small datasets or nearly sorted data
- **In-place**: Yes
- **Stable**: Yes (preserves the order of equal elements)

## Algorithm Explanation

1. Start at the beginning of the list.
2. Compare each pair of adjacent elements.
   - If the current element is larger than the next, swap them.
   - If not, move to the next pair.
3. Repeat until no swaps are needed on a full pass through the list, indicating the list is sorted.

After each complete pass, the largest element among unsorted elements will be in its correct position at the end of the list, reducing the range of comparisons required for the next pass.

## Pseudocode

Here's a high-level pseudocode of Bubble Sort:

```plaintext
function bubbleSort(array):
    n = length(array)
    for i from 0 to n - 1:
        for j from 0 to n - i - 1:
            if array[j] > array[j + 1]:
                swap(array[j], array[j + 1])
    return array
```

### Explanation

- **Outer loop** (`i`): Runs `n - 1` times, as `n - 1` passes are enough to sort the array.
- **Inner loop** (`j`): Compares elements up to the unsorted part of the array (`n - i - 1`) and performs swaps.

## Implementation in Java

Here's a Java implementation of Bubble Sort:

```java
public class BubbleSort {

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {          // Outer loop for passes
            for (int j = 0; j < n - i - 1; j++) {  // Inner loop for comparing elements
                if (array[j] > array[j + 1]) {
                    // Swap if elements are in the wrong order
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[] array = {5, 1, 4, 2, 8};
        bubbleSort(array);
        System.out.println("Sorted Array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
```

### Explanation

- The **outer loop** (`i`) reduces the number of elements that need to be checked with each pass.
- The **inner loop** (`j`) compares adjacent elements and swaps them if they are in the wrong order.

## Complexity Analysis

Bubble Sort has the following time complexities:

| Case           | Complexity |
|----------------|------------|
| **Best Case**  | \( O(n) \) |
| **Average Case** | \( O(n^2) \) |
| **Worst Case** | \( O(n^2) \) |

- **Best Case**: \( O(n) \), occurs when the array is already sorted, and no swaps are needed.
- **Average and Worst Case**: \( O(n^2) \), as each element has to be compared with every other element in the array.

**Space Complexity**: \( O(1) \), as Bubble Sort is an in-place sorting algorithm.

## Optimization

### Early Exit

In the best case (when the array is already sorted), Bubble Sort will still perform all passes by default. We can optimize the algorithm by introducing a **swap flag**. If no swaps occur during a pass, the algorithm can terminate early.

**Optimized Code in Java**:

```java
public static void bubbleSortOptimized(int[] array) {
    int n = array.length;
    for (int i = 0; i < n - 1; i++) {
        boolean swapped = false;
        for (int j = 0; j < n - i - 1; j++) {
            if (array[j] > array[j + 1]) {
                // Swap elements
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                swapped = true;
            }
        }
        // If no two elements were swapped, array is sorted
        if (!swapped) break;
    }
}
```

This optimized version of Bubble Sort exits early if the list becomes sorted before completing all passes, improving performance on nearly sorted data.

## Example Walkthrough

Consider sorting the array `[5, 1, 4, 2, 8]`:

1. **Pass 1**:
   - Compare `5` and `1`, swap: `[1, 5, 4, 2, 8]`
   - Compare `5` and `4`, swap: `[1, 4, 5, 2, 8]`
   - Compare `5` and `2`, swap: `[1, 4, 2, 5, 8]`
   - Compare `5` and `8`, no swap needed.

   Largest element `8` is now in its correct position.

2. **Pass 2**:
   - Compare `1` and `4`, no swap.
   - Compare `4` and `2`, swap: `[1, 2, 4, 5, 8]`
   - Compare `4` and `5`, no swap.

   Now, `5` is in its correct position.

3. **Pass 3**:
   - Compare `1` and `2`, no swap.
   - Compare `2` and `4`, no swap.

   Array is sorted: `[1, 2, 4, 5, 8]`

## Applications and Limitations

### Applications

- Bubble Sort can be useful for **educational purposes** to demonstrate simple sorting mechanisms.
- It works well on **small or nearly sorted datasets** due to its simplicity.

### Limitations

- Bubble Sort is inefficient for large datasets due to its \( O(n^2) \) time complexity.
- Other sorting algorithms like **Merge Sort** and **Quick Sort** are preferable for larger datasets due to their better average and worst-case performance.

---