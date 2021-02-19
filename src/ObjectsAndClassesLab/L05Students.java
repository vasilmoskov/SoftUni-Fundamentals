package ObjectsAndClassesLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L05Students {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Student> students = new ArrayList<>();

        while (!input.equals("end")) {
            String[] inputAsArray = input.split(" ");

            String firstName = inputAsArray[0];
            String lastName = inputAsArray[1];
            int age = Integer.parseInt(inputAsArray[2]);
            String hometown = inputAsArray[3];

            Student currentStudent = null;

            boolean studentExists = false;

            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getFirstName().equals(firstName) && students.get(i).getLastName().equals(lastName)) {
                    studentExists = true;
                    students.get(i).setHometown(hometown);
                    students.get(i).setAge(age);
                }
            }
            if (!studentExists) {
                currentStudent = new Student(firstName, lastName, age, hometown);
                students.add(currentStudent);
            }


            input = scanner.nextLine();
        }

        String hometown = scanner.nextLine();

        for (int i = 0; i < students.size(); i++) {
            String hometownOfCurrentStudent = students.get(i).getHometown();
            if (hometown.equals(hometownOfCurrentStudent)) {
                System.out.println(students.get(i));
            }
        }
    }

    public static class Student {
        String firstName;
        String lastName;
        int age;
        String hometown;

        public Student(String firstName, String lastName, int age, String hometown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.hometown = hometown;
        }

        public String getHometown() {
            return hometown;
        }

        public void setHometown(String hometown) {
            this.hometown = hometown;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }


        @Override
        public String toString() {
            return firstName + " " + lastName + " is " + age + " years old";
        }
    }
}