package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class E09PadawanEquipment {
    public static void main(String[] args) {

        //The input data should be read from the console. It will consist of exactly 5 lines:
        //•	The amount of money Ivan Cho has – floating-point number in range [0.00…1,000.00]
        //•	The count of students – integer in range [0…100]
        //•	The price of lightsabers for a single sabre – floating-point number in range [0.00…100.00]
        //•	The price of robes for a single robe – floating-point number in range [0.00…100.00]
        //•	The price of belts for a single belt – floating-point number in range [0.00…100.00]

        Scanner scanner = new Scanner(System.in);

        double moneyOfIvan = Double.parseDouble (scanner.nextLine());
        int studentsNumber = Integer.parseInt (scanner.nextLine());
        double lightsaberPrice = Double.parseDouble (scanner.nextLine());
        double robePrice = Double.parseDouble (scanner.nextLine());
        double beltPrice = Double.parseDouble (scanner.nextLine());

        //The number of items depends on how many students will sign up.

        double moneyForLightsabers = Math.ceil(studentsNumber*1.1) * lightsaberPrice;
        double moneyForRobes = studentsNumber * robePrice;
        double moneyForBelts = studentsNumber * beltPrice;

        if (studentsNumber>=6){
            moneyForBelts -= (studentsNumber/6) * beltPrice;
        }

        //Ivan  should buy 10% more lighsabers, rounded up to the next integer.
        // every sixth belt is free.

        double total = moneyForBelts+moneyForLightsabers+moneyForRobes;

        if (moneyOfIvan>=total) {
            System.out.printf("The money is enough - it would cost %.2flv.", total);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.", total-moneyOfIvan);
        }

        //The output should be printed on the console.
        //•	If the calculated price of the equipment is less or equal to the money Ivan Cho has:
        //o	"The money is enough - it would cost {the cost of the equipment}lv."
        //•	If the calculated price of the equipment is more than the money Ivan Cho has:
        //o	 "Ivan Cho will need {neededMoney}lv more."
        //•	All prices must be rounded to two digits after the decimal point.

    }
}
