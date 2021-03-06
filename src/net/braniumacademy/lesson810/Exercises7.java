package net.braniumacademy.lesson810;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Exercises7 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        getDataFromFile(employees);
        Employee[] employeesArr = new Employee[employees.size()];
        employees.toArray(employeesArr);
        // tiến hành sắp xếp
        Arrays.sort(employeesArr, (emp, other) -> { // tạo đối tượng triển khai interface Comparator
            var salaryCompare = Float.compare(other.salary, emp.salary);
            if (salaryCompare != 0) {
                return salaryCompare;
            } else { // nếu lương bằng nhau thì sắp xếp theo tên tăng dần
                var nameCompare = emp.firstName.compareTo(other.firstName);
                if (nameCompare != 0) {
                    return nameCompare;
                } else { // nếu lương và tên trùng nhau thì sắp xếp theo họ tăng dần
                    return emp.lastName.compareTo(other.lastName);
                }
            }
        });
        showResult(employeesArr);
    }

    private static void showResult(Employee[] employeesArr) {
        System.out.printf("%-15s%-15s%-20s%-15s%-20s\n", "Mã NV", "Họ", "Đệm", "Tên", "Lương");
        for (var e : employeesArr) {
            System.out.printf("%-15s%-15s%-20s%-15s%-20.2f\n",
                    e.getId(), e.getLastName(), e.getMidName(), e.getFirstName(), e.getSalary());
        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            T target = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(target) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = target;
        }
    }

    private static void getDataFromFile(List<Employee> employees) {
        try (Scanner input = new Scanner(new File("INPUT.DAT"))) {
            var t = Integer.parseInt(input.nextLine());
            while (t > 0) {
                String line = input.nextLine();
                var data = line.split("\\s+");
                var id = data[0];
                var last = data[1];
                var salary = Float.parseFloat(data[data.length - 1]);
                var first = data[data.length - 2];
                var mid = "";
                for (int i = 2; i < data.length - 2; i++) {
                    mid += data[i] + " ";
                }
                mid = mid.trim(); // loại bỏ dấu cách thừa
                Employee e = new Employee(id, first, mid, last, salary);
                employees.add(e);
                t--;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Employee {
        private String id;
        private String firstName;
        private String midName;
        private String lastName;
        private float salary;

        public Employee() {
        }

        public Employee(String id) {
            this.id = id;
        }

        public Employee(String id, String firstName, String midName, String lastName, float salary) {
            this.id = id;
            this.firstName = firstName;
            this.midName = midName;
            this.lastName = lastName;
            this.salary = salary;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getMidName() {
            return midName;
        }

        public void setMidName(String midName) {
            this.midName = midName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public float getSalary() {
            return salary;
        }

        public void setSalary(float salary) {
            this.salary = salary;
        }
    }
}

