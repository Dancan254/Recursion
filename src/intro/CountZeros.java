
public class CountZeros {

    public static void main(String[] args) {
        int count = countZeros(1020200004);
        System.out.println("count = " + count);

        System.out.println("countZerosWithRecursion(1020200004) = " + countZerosWithRecursion(1020200004));

        System.out.println("countZerosWithRecursion2(1020200004, 0) = " + countZerosWithRecursion2(1020200004, 0));
    }

    public static int countZeros(int number) {
        int count = 0;
        while (number > 0) {
            //find the last digit
            int last = number % 10;
            if (last == 0) {
                count++;
            }

            number /= 10;
        }
        return count;
    }

    public static int countZerosWithRecursion(int number) {
        if (number == 0) {
            return 0;
        }

        int last = number % 10;
        if (last == 0) {
            return 1 + countZerosWithRecursion(number / 10);
        }
        return countZerosWithRecursion(number / 10);
    }

    public static int countZerosWithRecursion2(int number, int count) {
        if (number == 0) {
            return count;
        }

        int last = number % 10;
        if (last == 0) {
            count++;
        }
        return countZerosWithRecursion2(number / 10, count);
    }
}
