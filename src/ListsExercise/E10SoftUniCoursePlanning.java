package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E10SoftUniCoursePlanning {
    public static void main(String[] args) {
        //On the first input line you will receive the initial schedule of lessons and exercises
        // that are going to be part of the next course, separated by comma and space ", ".

        Scanner scanner = new Scanner(System.in);

        List<String> courses = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String command = scanner.nextLine();

        // Until you receive "course start" you will be given some commands to modify the course schedule.

        while (!command.equals("course start")) {
            String [] commandAsArr = command.split(":");
            String operation = commandAsArr[0];
            String lessonTitle = commandAsArr[1];
            String exercise = String.format("%s-Exercise", lessonTitle);

            // The possible commands are:

            if (operation.equals("Add")) {

                if (!courses.contains(lessonTitle)) {
                    courses.add(lessonTitle);
                }

                //Add:{lessonTitle} - add the lesson to the end of the schedule, if it does not exist

            } else if (operation.equals("Insert")) {

                int index = Integer.parseInt (commandAsArr[2]);

                if (!courses.contains(lessonTitle)) {
                    courses.add(index, lessonTitle);
                }

                //Insert:{lessonTitle}:{index} -insert the lesson to the given index, if it does not exist

            } else if (operation.equals("Remove")) {

                if (courses.contains(lessonTitle)) {
                    courses.remove(lessonTitle);
                }

                if (courses.contains(exercise)) {
                    courses.remove(lessonTitle);
                }

                //Remove:{lessonTitle} -remove the lesson, if it exists

            } else if (operation.equals("Swap")) {

                String secondLessonTitle = commandAsArr[2];
                String secondExercise = String.format("%s-Exercise", secondLessonTitle);

                int indexOfFirstExercise = 0;
                int indexOfSecondExercise = 0;



                if (courses.contains(lessonTitle) && courses.contains(secondLessonTitle)) {
                    int indexOfFirstLesson = courses.indexOf(lessonTitle);
                    int indexOfSecondLesson = courses.indexOf(secondLessonTitle);

                    String savedValueOfFirstLesson = courses.get(indexOfFirstLesson);

                    courses.set(indexOfFirstLesson, secondLessonTitle);
                    courses.set(indexOfSecondLesson, savedValueOfFirstLesson);

                    if (courses.contains(exercise)) {
                        indexOfFirstExercise = courses.indexOf(exercise);
                        courses.add(indexOfSecondLesson+1, exercise);
                        courses.remove(indexOfFirstExercise+1);
                    }

                    if (courses.contains(secondExercise)) {
                        indexOfSecondExercise = courses.indexOf(secondExercise);
                        courses.add(indexOfFirstLesson+1, secondExercise);
                        courses.remove(indexOfSecondExercise+1);
                    }
                }

                //Swap:{lessonTitle}:{lessonTitle} -change the place of the two lessons, if they exist

                //Each time you Swap or Remove a lesson, you should do the same with the Exercises, if there are any, which follow the lessons.


            } else if (operation.equals("Exercise")) {


                if (courses.contains(lessonTitle) && !courses.contains(exercise)) {
                    int indexToAddExerciseTo = courses.indexOf(lessonTitle) + 1;
                    courses.add(indexToAddExerciseTo, exercise);

                    //Exercise:{lessonTitle} -add Exercise in the schedule right after the lesson index,
                    // if the lesson exists and there is no exercise already, in the following format "{lessonTitle}-Exercise".

                } else if (!courses.contains(lessonTitle)){
                    courses.add(lessonTitle);
                    courses.add(exercise);

                    // If the lesson doesn't exist, add the lesson in the end of the course schedule, followed by the Exercise.
                }

            }

            command = scanner.nextLine();
        }

        for (int i = 0; i < courses.size(); i++) {
            System.out.printf("%d.%s%n", i+1, courses.get(i));
        }

    }
}
