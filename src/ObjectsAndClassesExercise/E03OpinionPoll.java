package ObjectsAndClassesExercise;

import java.util.*;

public class E03OpinionPoll {

    public static class Person {
        String name;
        int age;

        public Person(String person, int age) {
            this.name = person;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " - " + age;
        }

    }
/*
    public static class NameSorter implements Comparator<Person>
    {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareToIgnoreCase(o2.getName());
        }
    }

 */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            Person person = new Person(name, age);
            if (age>30) {
                people.add(person);
            }
        }

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });

        //people.sort(new NameSorter());

        for (Person name:people) {
            System.out.println(name);
        }
    }
}



