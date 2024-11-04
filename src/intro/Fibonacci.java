/*
    * Fibonacci.java
    * This is a simple program that prints the Fibonacci sequence using recursion
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("Printing the nth number in the Fibonacci sequence");
        //0, 1, 1, 2, 3, 5, 8, 13, 21, 34
        int result = printFibonacciNumberWithoutRecursion(3);
        System.out.println("The nth number in the Fibonacci sequence is: " + result);
        System.out.println("printing nth number with recursion");
        int target = printFibonacciNumberWithRecursion(3);
        System.out.println("The nth number in the Fibonacci sequence is: " + target);
    }

    public static int printFibonacciNumberWithoutRecursion(int index){
        int first = 0;
        int second = 1;
        int third = 0;

        for(int i = 2; i <= index; i++){
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    public static int printFibonacciNumberWithRecursion(int index) {
        if (index == 0) {
            return 0;
        }
        if (index == 1) {
            return 1;
        }

        return printFibonacciNumberWithRecursion(index - 1) + printFibonacciNumberWithRecursion(index - 2);
    }
}
