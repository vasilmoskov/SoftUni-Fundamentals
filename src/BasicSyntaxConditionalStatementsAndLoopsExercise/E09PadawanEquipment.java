package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class E09PadawanEquipment {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        double amountOfMoney = Double.parseDouble(scanner.nextLine());
        int countOfStudents = Integer.parseInt(scanner.nextLine());
        double priceOfLightsabers = Double.parseDouble(scanner.nextLine());
        double priceOfRobes = Double.parseDouble(scanner.nextLine());
        double priceOfBelts = Double.parseDouble(scanner.nextLine());

        int lightsabers = (int) Math.ceil(countOfStudents * 1.1);
        int robes = countOfStudents;
        int belts = countOfStudents;

        int freeBelts = 0;

        if (countOfStudents % 6 == 0) {
            freeBelts += belts / 6;
        }

        double price = lightsabers * priceOfLightsabers + robes * priceOfRobes + (belts - freeBelts) * priceOfBelts;

        if (amountOfMoney >= price) {
            System.out.printf("The money is enough - it would cost %.2flv.", price);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.", price - amountOfMoney);
        }

    }
}

