package net.braniumacademy.lesson45.exercises1;

import java.util.Scanner;

public class Exercises1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PriorityQueue<String> queue = new PriorityQueue<>();
        int choice;
        do {
            System.out.println("=========== MENU ===========");
            System.out.println("1. Thêm mới phần tử vào queue.");
            System.out.println("2. Xóa phần tử đầu queue.");
            System.out.println("3. Lấy phần tử đầu queue nhưng không xóa.");
            System.out.println("4. Lấy số lượng phần tử hiện tại của queue.");
            System.out.println("5. Hiển thị các phần tử có trong queue.");
            System.out.println("6. Kiểm tra queue rỗng không.");
            System.out.println("7. Cho biết các phần tử có mức ưu tiên thấp nhất.");
            System.out.println("0. Thoát chương trình.");
            System.out.println("Xin mời chọn: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 0 -> System.out.println("<== Cảm ơn quý vị đã sử dụng dịch vụ! ==>");
                case 1 -> {
                    System.out.println("Nhập giá trị cần thêm và thứ tự ưu tiên: ");
                    String x = input.next();
                    int priority = input.nextInt();
                    queue.add(x, priority);
                }
                case 2 -> {
                    var headElement = queue.remove();
                    System.out.println("Giá trị phần tử đầu hàng đợi: " + headElement);
                }
                case 3 -> System.out.println("Phần tử đầu hàng đợi: " + queue.peek());
                case 4 -> System.out.println("Số phần tử hiện có trong hàng đợi: " + queue.size());
                case 5 -> queue.display();
                case 6 -> System.out.println(queue.isEmpty() ? "Queue rỗng." : "Queue không rỗng.");
                case 7 -> queue.minElements();
                default -> System.out.println("Sai chức năng, vui lòng kiểm tra lại.");
            }
        } while (choice != 0);
    }
}
