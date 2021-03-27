package ProgrammingFundamentalsFinalExams;

import java.util.Scanner;

public class EX02E01WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder stops = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Travel")) {
            String[] tokens = input.split(":");
            String command = tokens[0];

            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(tokens[1]);
                    String stop = tokens[2];

                    if (index >= 0 && index < stops.length()) {
                        stops.insert(index, stop);
                    }

                    System.out.println(stops);

                    break;

                case "Remove Stop":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);

                    if (startIndex >= 0 && endIndex < stops.length()) {
                        stops.delete(startIndex, endIndex + 1);
                    }

                    System.out.println(stops);

                    break;


                case "Switch":
                    String oldString = tokens[1];
                    String newString = tokens[2];

                    if (stops.toString().contains(oldString)) {
                        String string = stops.toString().replaceAll(oldString, newString);
                        stops.setLength(0);
                        stops.append(string);
                    }

                    System.out.println(stops);

                    break;
            }


            input = scanner.nextLine();
        }

        System.out.println("Ready for world tour! Planned stops: " + stops);


    }
}
