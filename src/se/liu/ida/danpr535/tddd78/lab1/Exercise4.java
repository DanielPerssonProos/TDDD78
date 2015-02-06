package se.liu.ida.danpr535.tddd78.lab1;

/**
 * Created by Daniel on 2015-01-20.
 */
public class Exercise4 {
    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            System.out.println(i + "-fakultet: " + factorial(i));
        }
    }

    /**
     * Calculates f! given f.
     * @param f
     * @return f!
     */
    private static int factorial(int f) {
        if (f == 0)
            return 1;
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result *= i;
        }

        return result;
    }
}
