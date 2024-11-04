public class Nto1 {

    //this is a simple program that prints the numbers from N to 1

    public static void main(String[] args) {
        printNto1(10);
    }

    public static void printNto1(int num){
        if(num == 0){
            return;
        }
        //print that number
        System.out.println(num);
        //call the function recursively
        printNto1(num - 1);
    }
}
