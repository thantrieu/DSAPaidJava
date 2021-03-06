package net.braniumacademy.lesson14;

import java.util.Scanner;

/**
 * @author Branium Academy
 * @version 2021.07
 * @website https://braniumacademy.net/
 */

public class Exercises9 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Nhập số nguyên dương n: ");
        var n = input.nextInt();
        var sum = add(n);
        System.out.println("S = 1 + ... + n = " + sum);
    }

    // phương thức tính toán S = 1 + ... + n
    private static int add(int n) {
        if (n <= 0) { // điểm dừng
            return 0;
        } else { // bước đệ quy
            return n + add(n - 1);
        }
    }
}
