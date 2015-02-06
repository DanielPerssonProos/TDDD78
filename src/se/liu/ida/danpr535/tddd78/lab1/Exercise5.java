package se.liu.ida.danpr535.tddd78.lab1;

/**
 * Created by Daniel on 2015-01-20.
 */
public class Exercise5 {
    public static boolean isPrime(int number){
        for (int i = 2; i < number; i++) {
            int rest = number % i;
            if (rest == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        for (int i = 2; i < 100; i++) {
            if (isPrime(i)){
                System.out.println("Primtal: " + i);
            }
        }
        //System.out.println("Primtal: " + isPrime(4));
    }
}
