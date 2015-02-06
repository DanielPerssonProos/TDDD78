package se.liu.ida.danpr535.tddd78.lab1;

import javax.swing.*;

/**
 * Created by Daniel on 2015-01-20.
 */
public class Exercise2 {
    public static int sumFor(int a, int b) {
        int res = 0;
        for (int i = 0; i < b - a; i++) {
            res += a + i;
        }
        for (int i = a; i <= b ; i++) {
            res += a;
        }
        return res;
    }
    public static int sumWhile(int a, int b){
        int res = 0;
        while (a < b){
            res += a;
            a += 1;
        }
        return res + b;
    }
    public static int sumDoWhile(int a, int b){
        int res = 0;
        do{
            res += a;
            a += 1;
        } while (a < b);
        return res + b;
    }
    public static void main(String[] args) {
        String input1 =
                JOptionPane.showInputDialog("Please input a value for a");
        int a = Integer.parseInt(input1);
        String input2 =
                JOptionPane.showInputDialog("Please input a value for b");
        int b = Integer.parseInt(input2);
        String input3 =
                JOptionPane.showInputDialog("Please input solution method");
        switch (input3){
            case "for":
                System.out.println(sumFor(a,b));
                break;
            case "while":
            case "test":
                System.out.println(sumWhile(a,b));
                break;
            case "do":
                System.out.println(sumDoWhile(a,b));
                break;
            default:
                System.out.println(sumFor(a,b));
                break;
        }
    }

}
