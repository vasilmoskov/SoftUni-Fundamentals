package ObjectsAndClassesExercise;

import java.util.*;

public class E05Students {

    public static class Student {
        String fistName;
        String lastName;
        double grade;

        public Student(String firstName, String lastName, double grade) {
            this.fistName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public double getGrade() {
            return grade;
        }

        @Override
        public String toString() {
            return String.format("%s %s: %.2f", fistName, lastName, grade);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String[] input = scanner.nextLine().split(" ");
            String firstName = input[0];
            String lastName = input[1];
            double grade = Double.parseDouble(input[2]);

            Student student = new Student(firstName, lastName, grade);

            students.add(student);
        }

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o2.getGrade(), o1.getGrade());
            }
        });

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
