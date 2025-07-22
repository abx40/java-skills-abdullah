public class PatternMaker {
    // Print a number triangle
    public static void printNumberTriangle(int rows) {
    // Print pattern like:
    // 1
    // 1 2
    // 1 2 3
    // 1 2 3 4
    // (for rows = 4)
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    // Print multiplication table
    public static void printMultiplicationTable(int number, int limit) {
    // Print: number x 1 = result, number x 2 = result, etc.
    // Up to the limit
        for (int i = 1; i <= limit; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
    }
    public static void main(String[] args) {
        printNumberTriangle(5);
        System.out.println();
        printMultiplicationTable(7, 10);
    }
}
