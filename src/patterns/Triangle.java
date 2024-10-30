
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
