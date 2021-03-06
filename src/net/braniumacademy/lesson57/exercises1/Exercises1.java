package net.braniumacademy.lesson57.exercises1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercises1 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Nhập tên file đầu vào: ");
        String fileName = input.nextLine();
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        readInputFile(tree, fileName);
        if (!tree.isEmpty()) { // nếu cây không rỗng
            System.out.println("Nhập x cầ xóa: ");
            int x = input.nextInt();
            if (tree.search(x)) {
                System.out.println("Trước khi xóa: ");
                tree.inOrder();
                tree.remove(x);
                System.out.println("\nSau khi xóa: ");
                tree.inOrder();
            } else {
                System.out.println("Giá trị cần xóa không tồn tại.");
            }
        }
    }

    private static void readInputFile(BinarySearchTree<Integer> tree, String fileName) {
        // sử dụng try-with-resource
        try (var fileReader = new Scanner(new File(fileName))) {
            var n = fileReader.nextInt();
            for (int i = 0; i < n; i++) {
                var x = fileReader.nextInt();
                tree.add(x);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Tên file không đúng hoặc file không tồn tại. Vui lòng kiểm tra lại.");
        }
    }
}
