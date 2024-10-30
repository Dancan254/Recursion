package arrays;

/*
The isSortedWithoutRecursion method is generally more efficient than the isSortedWithRecursion methods. Here's why:

Space Complexity:

isSortedWithoutRecursion: This method uses a simple loop, so it has a space complexity of O(1) because it does not require additional space proportional to the input size.
isSortedWithRecursion and isSortedWithRecursion2: 
These methods use recursion, which means each recursive call adds a new frame to the call stack. The space complexity is O(n) in the worst case, where n is the length of the array.
Time Complexity:

Both isSortedWithoutRecursion and isSortedWithRecursion methods have a time complexity of O(n) because they both iterate through the array once.
Given that both methods have the same time complexity, the isSortedWithoutRecursion method is more efficient due to its lower space complexity.
 */
public class Sorted {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("isSorted(arr) = " + isSortedWithoutRecursion(arr));
        int[] arr2 = {1, 2, 3, 4, 5, 3};
        System.out.println("isSorted(arr2) = " + isSortedWithoutRecursion(arr2));
        int[] arr3 = {1, 2, 3, 4, 5, 6};
        System.out.println("isSorted(arr3) = " + isSortedWithoutRecursion(arr3));
    }

    public static boolean isSortedWithoutRecursion(int[] arr) {
        //iterate through the array
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSortedWithRecursion(int[] arr, int index) {
        if (index == arr.length - 1) {
            return true;
        }
        return arr[index] < arr[index + 1] && isSortedWithRecursion(arr, index + 1);
    }

    public static boolean isSortedWithRecursion2(int[] arr, int index) {
        if (index == arr.length - 1) {
            return true;
        }
        if (arr[index] >= arr[index + 1]) {
            return false;
        }
        return isSortedWithRecursion(arr, index + 1);
    }
}
