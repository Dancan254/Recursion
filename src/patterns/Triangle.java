
public class Triangle {
    public static void main(String[] args) {
        printTriangle(5);
        printTriangleWithRecursion(5);
    }

    public static void printTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void printTriangleWithRecursion(int n) {
        printTriangleRecursive(n, 1);
    }

    //n is the number of rows, i is the current col
    /*
     * Initial Call: printTriangleRecursive(4, 1)

    i = 1
    Print: *
    Newline
    Recursive Call: printTriangleRecursive(4, 2)
    Second Call: printTriangleRecursive(4, 2)

    i = 2
    Print: * *
    Newline
    Recursive Call: printTriangleRecursive(4, 3)
    Third Call: printTriangleRecursive(4, 3)

    i = 3
    Print: * * *
    Newline
    Recursive Call: printTriangleRecursive(4, 4)
    Fourth Call: printTriangleRecursive(4, 4)

    i = 4
    Print: * * * *
    Newline
    Recursive Call: printTriangleRecursive(4, 5)
    Base Case: printTriangleRecursive(4, 5)

    i = 5 (greater than n)
    Return and stop recursion
     */
    public static void printTriangleRecursive(int n, int i) {
        if (i > n) {
            return;
        }
        for (int j = 1; j <= i; j++) {
            System.out.print("* ");
        }
        System.out.println();
        printTriangleRecursive(n, i + 1);
    }
}
