package net.braniumacademy.lesson24.exercises2;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }
    }

    public void insertHead(T data) {
        Node<T> p = new Node<>(data);
        if(head == null) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    public void insertTail(T data) {
        Node<T> p = new Node<>(data);
        if(head == null) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }
    // chèn vào sau node có giá trị x
    public void insertAfterX(T data, T x) {
        Node<T> p = new Node<>(data);
        Node<T> nodeX = head;
        while (nodeX != null) {
            if(nodeX.data == x) {
                break;
            }
            nodeX = nodeX.next;
        }
        if(nodeX != null) {
            p.next = nodeX.next;
            nodeX.next = p;
        } else {
            System.out.println("Không tìm thấy node mục tiêu.");
        }
    }

    public void showList() {
        for (var node = head; node != null; node = node.next) {
            System.out.print(node.data + " -> ");
        }
        System.out.println("null");
    }

    /**
     * Phương thức cập nhật dữ liệu cho node
     * @param target node chứa dữ liệu mục tiêu cần tìm
     * @param newData dữ liệu mới cần cập nhật vào node
     * @return số lượng phần tử được cập nhật
     */
    public int updateNodeData(Node target, T newData) {
        int count = 0;
        for (var node = head; node != null; node = node.next) {
            if(node.data.equals(target.data)) {
                node.data = newData;
                count++;
            }
        }
        return count; // cập nhật thất bại
    }
}
