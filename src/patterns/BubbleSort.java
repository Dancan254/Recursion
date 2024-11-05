public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {99, 100, 67, 78, 89, 90, 76};
        bubbleSortWithoutRecursion(arr);
        for (int num : arr) {
            System.out.println(num);
        }
    }

    public static void bubbleSortWithoutRecursion(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }  
            }   
        }
    }

    public static void bubbleSortWithRecursion(int[] arr, int i, int j){
        if(i == arr.length){
            return;
        }
        if(j == arr.length){
            return;
        }
        if(i > j){
            if(arr[i] > arr[j]){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        bubbleSortWithRecursion(arr, i, j+1);
        }
        bubbleSortWithRecursion(arr, i-1, 0);

    }
}
