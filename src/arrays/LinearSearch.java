package arrays;
import java.util.ArrayList;
import java.util.List;

public class LinearSearch {

//list to store the indexes of the target element
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("linearSearch(arr, 3) = " + linearSearch(arr, 3));
        System.out.println("linearSearch(arr, 6) = " + linearSearch(arr, 6));

        System.out.println("linearSearchWithRecursion(arr, 3) = " + linearSearchWithRecursion(arr, 3));

        int[] arr2 = {1, 2, 3, 4, 5, 2, 5, 2};
        findAllIndexesWithRecursion(arr2, 2);
        System.out.println("list = " + list);
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int linearSearchWithRecursion(int[] arr, int target) {
        return linearSearchRecursive(arr, target, 0);
    }

    public static int linearSearchRecursive(int[] arr, int target, int index) {
        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        }
        return linearSearchRecursive(arr, target, index + 1);
    }

    public static void findAllIndexes(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("Found at index: " + i);
            }
        }
    }

    public static void findAllIndexesWithRecursion(int[] arr, int target) {
        findAllIndexesRecursive(arr, target, 0);
    }

    public static void findAllIndexesRecursive(int[] arr, int target, int index) {
        if (index == arr.length) {
            return;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        findAllIndexesRecursive(arr, target, index + 1);
    }
}
