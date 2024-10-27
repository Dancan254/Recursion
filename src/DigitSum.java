public class DigitSum {

    public static void main(String[] args) {
        System.out.println("Digital sum without recursion!");
        int number = 23456;
        int result = digitalSumWithoutRecursion(number);
        System.out.println("Digital sum of " + number + " is: " + result);

        System.out.println("Digital sum with recursion!");
        System.out.println("Digital sum of " + number + " is: " + digitalSumWithRecursion(number));


    }

    public static int digitalSumWithoutRecursion(int number){
        int sum = 0;
        while(number != 0){
            //get the last digit
            int lastDigit = number % 10;
            //add the last digit to the sum
            sum += lastDigit;

            //divide the number by 10, to get the remaining number
            number /=10;
        }
        return sum;
    }

    public static int digitalSumWithRecursion(int number){
        if (number == 0) {
            return 0;
        }
        //return the last digit and call the function recursively
        return number % 10 + digitalSumWithRecursion(number / 10);
    }
    /*
       Step 1: digitSum(1234)
        Last digit: 4
        Remaining number: 123
        Recursive call: digitSum(123)
        Step 2: digitSum(123)
        Last digit: 3
        Remaining number: 12
        Recursive call: digitSum(12)
        Step 3: digitSum(12)
        Last digit: 2
        Remaining number: 1
        Recursive call: digitSum(1)
        Step 4: digitSum(1)
        Last digit: 1
        Remaining number: 0
        Recursive call: digitSum(0)
        Step 5: digitSum(0)
        Base case: return 0
     */
}
