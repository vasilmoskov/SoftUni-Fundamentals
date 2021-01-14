package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class E10RageExpenses {
    public static void main(String[] args) {

        //Input / Constraints
        //•	On the first input line - lost games count – integer in the range [0, 1000].
        //•	On the second line – headset price - floating point number in range [0, 1000].
        //•	On the third line – mouse price - floating point number in range [0, 1000].
        //•	On the fourth line – keyboard price - floating point number in range [0, 1000].
        //•	On the fifth line – display price - floating point number in range [0, 1000].

        Scanner scanner = new Scanner(System.in);
        int lostGamesCount = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int headsetTrashedCount = 0;
        int mouseTrashedCount = 0;
        int keyboardTrashedCount = 0;
        int displayTrashedCount = 0;

        int headsetTrashedInTheSameTimeAsMouse = 0;
        int mouseTrashedInTheSameTimeAsHeadset = 0;


        for (int i = 1; i <= lostGamesCount; i++) {


            if (i % 2 == 0) {
                headsetTrashedCount++;
                headsetTrashedInTheSameTimeAsMouse++;
            }
            if (i % 3 == 0) {
                mouseTrashedCount++;
                mouseTrashedInTheSameTimeAsHeadset++;

            }
            if (headsetTrashedInTheSameTimeAsMouse == mouseTrashedInTheSameTimeAsHeadset && mouseTrashedInTheSameTimeAsHeadset != 0) {
                keyboardTrashedCount++;

            }
            if (keyboardTrashedCount % 2 == 0 && mouseTrashedInTheSameTimeAsHeadset != 0 &&headsetTrashedInTheSameTimeAsMouse!=0) {
                displayTrashedCount++;

            }
            headsetTrashedInTheSameTimeAsMouse = 0;
            mouseTrashedInTheSameTimeAsHeadset = 0;
        }
        double rageExpenses = headsetPrice * headsetTrashedCount + mousePrice * mouseTrashedCount + keyboardPrice * keyboardTrashedCount + displayPrice * displayTrashedCount;

        System.out.printf("Rage expenses: %.2f lv.", rageExpenses);
    }


    //Output
    //•	As output you must print Pesho`s total expenses: "Rage expenses: {expenses} lv."
    //•	Allowed working time / memory: 100ms / 16MB.
}
