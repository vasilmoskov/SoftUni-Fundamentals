package MapsLambdaAndStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E05SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt (scanner.nextLine());

        LinkedHashMap<String, String> users = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String [] inputAsStringArr = input.split(" ");
            String command = inputAsStringArr [0];
            String username = inputAsStringArr [1];

            if (command.equals("register")){
                String licensePlateNumber = inputAsStringArr [2];
                if (!users.containsKey(username)) {
                    users.put(username, licensePlateNumber);
                    System.out.printf("%s registered %s successfully%n", username, licensePlateNumber);
                } else {
                    System.out.printf("ERROR: already registered with plate number %s%n", licensePlateNumber);
                }

            } else if (command.equals("unregister")) {
                if (!users.containsKey(username)) {
                    System.out.printf("ERROR: user %s not found%n", username);
                } else {
                    users.remove(username);
                    System.out.printf("%s unregistered successfully%n", username);
                }
            }
        }

        for (Map.Entry<String, String> entry : users.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
