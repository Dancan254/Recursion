public class ReverseNum {
    public static void main(String[] args) {
        int number = 12345;
        int result = reverseNum(number);
        System.out.println(result);
    }

    public static int reverseNum(int number){
        int reverse = 0;
        while(number != 0){
            reverse = reverse * 10 + number % 10;
            number = number / 10;
        }
        return reverse;
    }

    public static int reverseNumberWithRecursion(int number){
        if(number%10 == number){
            return number;
        }
        // remainder * 10^length + reverseNumberWithRecursion(number/10)
        //length = log10(number)
        return (number%10) * (int)Math.pow(10, (int)Math.log10(number)) + reverseNumberWithRecursion(number/10);
    }
}