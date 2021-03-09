package MapsLambdaAndStreamAPIExercise;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E06Courses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, List<String>> courses = new LinkedHashMap<>();

        while (!input.equals("end")) {
            String[] inputAsStringArr = input.split(" : ");
            String course = inputAsStringArr[0];
            String student = inputAsStringArr[1];

            if (!courses.containsKey(course)) {
                List<String> students = new ArrayList<>();
                students.add(student);
                courses.put(course, students);
            } else {
                List<String> students = courses.get(course);
                students.add(student);
                courses.put(course, students);
            }

            input = scanner.nextLine();
        }

        LinkedHashMap<String, Integer> registeredStudents = new LinkedHashMap<>();

        for (Map.Entry<String, List<String>> entry : courses.entrySet()) {
            String course = entry.getKey();
            int registeredStudentsCount = entry.getValue().size();
            registeredStudents.put(course, registeredStudentsCount);
        }

        Set<Map.Entry<String, Integer>> s = registeredStudents.entrySet();
        List<Map.Entry<String, Integer>> l = new ArrayList<Map.Entry<String, Integer>>(s);
        Collections.sort(l, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> arg0,
                               Map.Entry<String, Integer> arg1) {

                return (arg1.getValue().compareTo(arg0.getValue()));
            }

        });

        for (Map.Entry<String, Integer> entry : l) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            List<String> studentsOfCurrentCourse = courses.get(entry.getKey());
            Collections.sort(studentsOfCurrentCourse);
            for (int i = 0; i < studentsOfCurrentCourse.size(); i++) {
                System.out.printf("-- %s%n",studentsOfCurrentCourse.get(i));
            }
        }

    }
}
