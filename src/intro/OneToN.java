import java.util.function.Function;

public class OneToN {
    /*
    This is a simple program that prints the numbers from 1 to N using recursion
     */
    public static void main(String[] args) {
        System.out.println("Printing from 1 to N");
        printOneToN(10);
        System.out.println("Printing both sides");
        printOneToNBothSides(10);
    }

    public static void printOneToN(int num){
        if (num == 0){
            return;
        }

        //call the function recursively
        printOneToN(num - 1);
        //print that number
        System.out.println(num);
    }

    public static void printOneToNBothSides(int num){
        if (num == 0){
            return;
        }

        //print that number
        System.out.println(num);
        //call the function recursively
        printOneToNBothSides(num - 1);
        //print that number
        System.out.println(num);
    }
}
