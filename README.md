---

# Recursion and the Call Stack

Recursion is a programming technique where a function calls itself to solve smaller instances of the same problem. Each recursive call creates a new instance of the function, which is pushed onto the **call stack**—a specialized stack memory used by the system to manage function calls. Understanding recursion’s interaction with stack memory is crucial for writing and optimizing recursive algorithms.

---

## How Recursion Works

1. **Function Calls Itself**: When a recursive function is called, it either:
   - **Recurses**: Calls itself again with a modified input.
   - **Returns**: If the base case is met (the condition that stops the recursion), it returns a result back up the call stack.

2. **Base Case**: Defines the condition under which the function stops calling itself. Without it, recursion would lead to an infinite loop, causing a stack overflow.

3. **Recursive Case**: The part of the function where it makes a recursive call, usually with a smaller or simplified input.

---

## Call Stack and Recursion

When a function is called (whether recursive or not), the system allocates a **stack frame** (or activation record) on the **call stack**. Each frame includes:
- The function’s **local variables**
- **Parameters** passed to the function
- The **return address** for control after the function completes

Each recursive call adds a new stack frame to the call stack. When the base case is reached, the function begins to return, popping stack frames off the call stack in a **Last In, First Out (LIFO)** order.

---

## Example of Recursion

To illustrate, here’s a simple example: calculating the factorial of a number using recursion.

### Factorial Example

```java
public int factorial(int n) {
    if (n == 1) { // Base case
        return 1;
    }
    // Recursive case
    return n * factorial(n - 1);
}
```

### Call Stack Behavior

For a call like `factorial(3)`, the following occurs:

1. **First Call (`factorial(3)`)**:
   - Checks if `n == 1` (not true, so recurses).
   - Calls `factorial(2)`, adding a frame for `factorial(2)` to the stack.

2. **Second Call (`factorial(2)`)**:
   - Again, `n != 1`, so recurses.
   - Calls `factorial(1)`, adding a frame for `factorial(1)`.

3. **Third Call (`factorial(1)`)**:
   - Here `n == 1`, so returns `1`, and begins popping frames.

---

## Stack Memory in Recursion

- **New frame** for each recursive call, storing local variables and return addresses.
- Recursion depth increases stack frames, and when base case is met, they’re popped in reverse order.

### Visual Representation

Here’s a simplified view of the call stack during `factorial(3)`:

1. Before starting:
   ```
   []
   ```

2. After calling `factorial(3)`:
   ```
   [factorial(3)]
   ```

3. After calling `factorial(2)`:
   ```
   [factorial(3), factorial(2)]
   ```

4. After calling `factorial(1)`:
   ```
   [factorial(3), factorial(2), factorial(1)]
   ```

5. After `factorial(1)` returns:
   ```
   [factorial(3), factorial(2)]
   ```

6. After `factorial(2)` returns:
   ```
   [factorial(3)]
   ```

7. After `factorial(3)` returns:
   ```
   []
   ```

---

## Important Points to Note

1. **Stack Overflow**: Recursive depth that exceeds stack memory limit results in **stack overflow**.
   
2. **Space Complexity**: Each recursive function call uses space for a new frame. Recursive depth `n` results in `O(n)` space complexity.

3. **Tail Recursion**: If the recursive call is the last action, some compilers can optimize to reuse stack frames (reducing memory usage). Java does not optimize for tail recursion.

### Tail Recursion Example

Using an accumulator reduces stack depth by keeping intermediate results outside the recursion:

```java
public int factorialTail(int n, int accumulator) {
    if (n == 1) {
        return accumulator;
    }
    // Tail recursive call
    return factorialTail(n - 1, n * accumulator);
}
```

---

## Summary

- Recursive calls add frames to the **call stack** in a **LIFO** order.
- The **base case** prevents infinite recursion and stack overflow.
- **Stack overflow** is a risk in deep recursion without optimization (e.g., tail recursion).
