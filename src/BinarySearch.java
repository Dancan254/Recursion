
public class BinarySearch {

    /*
    Time Complexities
    Normal Binary Search (Iterative): (O(\log n))
    Binary Search with Recursion: (O(\log n))
    Binary Search with Memoization: (O(\log n)) (with additional space complexity for storing memoized results)
     */
    public static void main(String[] args) {
        System.out.println("Bin search without recursion!");
        int[] arr = {99, 100, 67, 78, 89, 90, 76};
        int target = 90;
        int result = binarySearchWithoutRecursion(arr, target, 0, arr.length - 1);
        System.out.println("Element found at index: " + result);

        System.out.println("Bin search without recursion without specifying start and end index!");
        int result2 = binarySearchWithoutRecursion(arr, target);
        System.out.println("Element found at index: " + result2);

        System.out.println("Bin search with recursion!");
        int result3 = binarySearchWithRecursion(arr, target, 0, arr.length - 1);
        System.out.println("Element found at index: " + result3);
    }

    public static int binarySearchWithoutRecursion(int[]arr, int target, int start, int end){

        while(start < end){
            //mid value
            int mid = start + (end - start) / 2;

            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] < target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }

    //without specifying the start and end index
    public static int binarySearchWithoutRecursion(int[]arr, int target){
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            //mid value
            int mid = start + (end - start) / 2;

            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] < target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }

    //Binary search with recursion
    public static int binarySearchWithRecursion(int[] arr, int target, int start, int end){
        if(start > end){
            return -1;
        }
        //find the mid-index
        int mid = start + (end - start) / 2;
        //compare with the target
        if(arr[mid] == target){
            return mid;
        } else if (arr[mid] <target) {
            //search in the right half
            return binarySearchWithoutRecursion(arr, target, mid + 1, end);
        }
        else{
            //search in the left half
            return binarySearchWithoutRecursion(arr, target, start, mid - 1);
        }
    }

}
