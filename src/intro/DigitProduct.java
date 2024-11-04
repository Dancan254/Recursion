public class DigitProduct {
    public static void main(String[] args) {

        int number = 1204;
        System.out.println("Digital product without recursion for: " + number + " -> "+ digitalProductWithoutRecursion(number));
        System.out.println("Digital product with recursion: " + digitalProductWithRecursion(number));

        int number2 = 1234;
        System.out.println("Digital product without recursion: " + digitalProductWithoutRecursion(number2));
        System.out.println("Digital product with recursion: " + digitalProductWithRecursion(number2));
    }

    public static int digitalProductWithoutRecursion(int number){
        int prod = 1;
        while(number != 0){
            //get the last digit
            int lastDigit = number % 10;
            //add the last digit to the sum
            prod *= lastDigit;

            //divide the number by 10, to get the remaining number
            number /=10;
        }
        return prod;
    }

    public static int digitalProductWithRecursion(int number){
        if (number%10 == number) {
            return number;
        }
        //return the last digit and call the function recursively
        return number % 10 * digitalProductWithRecursion(number / 10);
    }
    /*
    Step 1: digitProduct(1234)
    Last digit: 4
    Remaining number: 123
    Recursive call: digitProduct(123)
    Step 2: digitProduct(123)
    Last digit: 3
    Remaining number: 12
    Recursive call: digitProduct(12)
    Step 3: digitProduct(12)
    Last digit: 2
    Remaining number: 1
    Recursive call: digitProduct(1)
    Step 4: digitProduct(1)
    Last digit: 1
    Remaining number: 0
    Recursive call: digitProduct(0)
    Step 5: digitProduct(0)
    Base case: return 1
     */
}
