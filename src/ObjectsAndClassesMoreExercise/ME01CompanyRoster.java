package ObjectsAndClassesMoreExercise;

import java.util.*;
import java.util.stream.Collectors;

public class ME01CompanyRoster {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];

            String email = "n/a";
            int age = -1;

            if (input.length == 5) {
                if (input[4].contains("@")) {
                    email = input[4];
                } else {
                    age = Integer.parseInt(input[4]);
                }
            } else if (input.length == 6) {
                email = input[4];
                age = Integer.parseInt(input[5]);

            }

            Employee currentEmployee = new Employee(name, salary, position, department, email, age);
            employees.add(currentEmployee);
        }

        double highestAverageSalary = Integer.MIN_VALUE;
        String departmentWithHighestAverageSalary = "";

        for (int i = 0; i < employees.size(); i++) {

            int countOfEmployeesInCurrentDepartment = 1;
            double totalSalariesOfCurrentDepartment = employees.get(i).getSalary();
            String departmentOfCurrentEmployee = employees.get(i).getDepartment();

            for (int j = 0; j < employees.size(); j++) {
                String departmentOfOtherEmployee = employees.get(j).getDepartment();

                if (i != j && departmentOfCurrentEmployee.equals(departmentOfOtherEmployee)) {
                    totalSalariesOfCurrentDepartment += employees.get(j).getSalary();
                    countOfEmployeesInCurrentDepartment++;
                }

            }

            double averageSalaryOfCurrentDepartment = totalSalariesOfCurrentDepartment / countOfEmployeesInCurrentDepartment;

            if (averageSalaryOfCurrentDepartment > highestAverageSalary) {
                highestAverageSalary = averageSalaryOfCurrentDepartment;
                departmentWithHighestAverageSalary = departmentOfCurrentEmployee;
            }

        }

        System.out.printf("Highest Average Salary: %s%n", departmentWithHighestAverageSalary);

        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o2.getSalary(), o1.getSalary());
            }
        });

        for (int i = 0; i < employees.size(); i++) {
            String departmentOfCurrentEmployee = employees.get(i).getDepartment();
            if (departmentOfCurrentEmployee.equals(departmentWithHighestAverageSalary)) {
                System.out.println(employees.get(i));
            }
        }
    }

    public static class Employee {
        String name;
        double salary;
        String position;
        String department;
        String email;
        int age;

        public Employee(String name, double salary, String position, String department, String email, int age) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = email;
            this.age = age;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getDepartment() {
            return department;
        }

        @Override
        public String toString() {
            return String.format("%s %.2f %s %d", name, salary, email, age);
        }
    }
}
