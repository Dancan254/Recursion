public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 3, 8};
        selectionSortWithoutRecursion(arr);
        for(int el : arr){
            System.out.println(el);
        }

        int[] arr2 = {4, 2, 5, 3, 8};
        System.out.println("with recursion");
        selectionSortWithRecursion(arr, 0);
        for(int el : arr){
            System.out.println(el);
        }
    }

    public static void selectionSortWithoutRecursion(int[] arr){
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            //set the minimum index to the first index
            int minIndex = i;
            //do the comparison
            for(int j = i + 1; j < length; j++){
                if(arr[j] < arr[minIndex]){
                    //set the min mindex to j
                    minIndex = j;
                }
            }
            //swap the elements
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

        }
    }

    public static void selectionSortWithRecursion(int[] arr, int start){
        
        if(start == arr.length -1){
            return;
        }
        int minIndex = start;
        //find the minimum elements index
        for(int i = start +1; i<arr.length; i++){
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        // Swap the found minimum element with the first element of the unsorted part
        int temp = arr[minIndex];
        arr[minIndex] = arr[start];
        arr[start] = temp;

        //call the function recursively
        selectionSortWithRecursion(arr, start + 1);
    }
    /*
     * example Walkthrough (with arr = {64, 25, 12, 22, 11})
        First Call (start = 0): Finds the minimum (11) and swaps it with arr[0].
        Array after this call: [11, 25, 12, 22, 64]
        Second Call (start = 1): Finds the minimum (12) and swaps it with arr[1].
        Array after this call: [11, 12, 25, 22, 64]
        Third Call (start = 2): Finds the minimum (22) and swaps it with arr[2].
        Array after this call: [11, 12, 22, 25, 64]
        Fourth Call (start = 3): Finds the minimum (25) and swaps it with arr[3].
        Array after this call: [11, 12, 22, 25, 64]
        Fifth Call (start = 4): Base case is reached, recursion ends.
     */
}
