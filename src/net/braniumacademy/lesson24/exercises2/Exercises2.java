package net.braniumacademy.lesson24.exercises2;

import java.util.Scanner;

public class Exercises2 {
    public static void main(String[] args) {
        LinkedList<Integer> listNumber = new LinkedList<>(); // tạo linked list chứa các phần tử kiểu Integer
        listNumber.insertTail(1);
        listNumber.insertTail(5);
        listNumber.insertTail(6);
        listNumber.insertTail(3);
        listNumber.insertTail(8);
        listNumber.insertTail(6);
        listNumber.insertTail(1);
        listNumber.insertTail(8);
        listNumber.insertTail(1);
        System.out.println("Các phần tử trong danh sách liên kết: ");
        listNumber.showList();
        // cập nhật node có giá trị x
        var input = new Scanner(System.in);
        System.out.println("Nhập vào giá trị của node cần cập nhật: ");
        int oldValue = input.nextInt();
        System.out.println("Nhập vào giá trị mới: ");
        int newValue = input.nextInt();
        var targetNode = new LinkedList.Node(oldValue); // tạo node với giá trị nhận được
        var result = listNumber.updateNodeData(targetNode, newValue);
        if (result > 0) { // nếu cập nhật thành công
            System.out.printf("Cập nhật thành công %d node. Các phần tử trong danh sách: \n", result);
            listNumber.showList();
        } else {
            System.out.println("Không tìm thấy node cần cập nhật.");
        }
    }
}
