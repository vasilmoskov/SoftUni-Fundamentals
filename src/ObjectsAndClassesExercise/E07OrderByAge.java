package ObjectsAndClassesExercise;

import java.util.*;

public class E07OrderByAge {

    public static class Person {
        String name;
        String id;
        int age;

        public Person(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return name + " with ID: " + id + " is " + age + " years old.";
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] inputAsStringArray = input.split(" ");
            String name = inputAsStringArray[0];
            String id = inputAsStringArray[1];
            int age = Integer.parseInt(inputAsStringArray[2]);

            Person person = new Person(name, id, age);

            people.add(person);

            input = scanner.nextLine();
        }

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });

        for (Person person : people) {
            System.out.println(person);
        }
    }
}
