package bubblesort;
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {99, 100, 67, 78, 89, 90, 76};
        bubbleSortWithRecursion(arr, arr.length);
        for (int num : arr) {
            System.out.println(num);
        }
        System.out.println("Bubble sort without recursion");
        int[] arr2 = {99, 100, 67, 78, 89, 90, 76};
        bubbleSortWithoutRecursion(arr2);
        for (int num : arr2) {
            System.out.println(num);
        }
    }

    public static void bubbleSortWithoutRecursion(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i -1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }  
            }   
        }
    }

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

    public static void bubbleSortWithRecursion(int[] arr, int length) {
        if(length == 1){
            return;
        }
        for(int i = 0; i < length - 1; i++){
            if(arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        bubbleSortWithRecursion(arr, length - 1);
    }
}
