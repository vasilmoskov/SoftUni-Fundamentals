package MapsLambdaAndStreamAPIExercise;

import java.util.*;
import java.util.stream.Collectors;

public class E07StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, List<Double>> studentsGrades = new LinkedHashMap<>();


        for (int i = 0; i < n; i++) {
            String studentsName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!studentsGrades.containsKey(studentsName)) {
                List<Double> grades = new ArrayList<>();
                grades.add(grade);
                studentsGrades.put(studentsName, grades);
            } else {
                List<Double> existingListOfGrades = studentsGrades.get(studentsName);
                existingListOfGrades.add(grade);
                studentsGrades.put(studentsName, existingListOfGrades);
            }
        }

        LinkedHashMap<String, Double> studentsWithGoodGrades = new LinkedHashMap<>();

        for (Map.Entry<String, List<Double>> entry : studentsGrades.entrySet()) {
            List<Double> gradesOfCurrentStudent = entry.getValue();
            double averageGrade = 0;

            for (int i = 0; i < gradesOfCurrentStudent.size(); i++) {
                averageGrade += gradesOfCurrentStudent.get(i);
            }

            averageGrade /= gradesOfCurrentStudent.size();

            if (averageGrade >= 4.50) {
                studentsWithGoodGrades.put(entry.getKey(), averageGrade);
            }
        }

        studentsWithGoodGrades.entrySet().stream().sorted((e1, e2) -> {
            double res = e2.getValue().compareTo(e1.getValue());
            return (int) res;
        }).forEach(e-> System.out.printf("%s -> %.2f%n", e.getKey(), e.getValue()));

    }
}