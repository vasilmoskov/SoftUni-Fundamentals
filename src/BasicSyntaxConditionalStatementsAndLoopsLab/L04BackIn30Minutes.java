package BasicSyntaxConditionalStatementsAndLoopsLab;

import java.util.Scanner;

public class L04BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours = Integer.parseInt (scanner.nextLine());
        int minutes = Integer.parseInt (scanner.nextLine());

        int plusDelay = minutes + 30;
        if (plusDelay>59) {
            hours++;
            plusDelay -= 60;
        }

        if (hours>23) {
            hours -= 24;
        }

        System.out.printf("%d:%02d", hours, plusDelay);
    }
}
