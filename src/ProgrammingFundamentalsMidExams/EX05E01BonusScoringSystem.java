package ProgrammingFundamentalsMidExams;

import java.util.Scanner;

public class EX05E01BonusScoringSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int countOfStudents = Integer.parseInt(scanner.nextLine());
        int countOfLectures = Integer.parseInt(scanner.nextLine());
        int initialBonus = Integer.parseInt(scanner.nextLine());

        double maxBonus = 0;
        int lecturesOfStudentWithMaxBonus = 0;

        for (int i = 0; i < countOfStudents; i++) {
            int currentStudentAttendances = Integer.parseInt(scanner.nextLine());

            double totalBonusOfCurrentStudent = (double) currentStudentAttendances / countOfLectures * (5 + initialBonus);

            if (totalBonusOfCurrentStudent > maxBonus) {
                maxBonus = totalBonusOfCurrentStudent;
                lecturesOfStudentWithMaxBonus = currentStudentAttendances;
            }
        }

        int maxBonusPointsRounded = (int) Math.ceil(maxBonus);

        System.out.printf("Max Bonus: %d.%n", maxBonusPointsRounded);
        System.out.printf("The student has attended %d lectures.", lecturesOfStudentWithMaxBonus);

    }
}