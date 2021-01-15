package BasicSyntaxConditionalStatementsAndLoopsMoreExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ME05Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lettersCount = Integer.parseInt (scanner.nextLine());

        for (int i = 0; i < lettersCount; i++) {
            int currentLetterRepresentedByNumbers = Integer.parseInt (scanner.nextLine());
            if (currentLetterRepresentedByNumbers==2){
                System.out.print("a");
            } else if (currentLetterRepresentedByNumbers ==22){
                System.out.print("b");
            }else if (currentLetterRepresentedByNumbers ==222){
                System.out.print("c");
            }else if (currentLetterRepresentedByNumbers ==3){
                System.out.print("d");
            }else if (currentLetterRepresentedByNumbers ==33){
                System.out.print("e");
            }else if (currentLetterRepresentedByNumbers ==333){
                System.out.print("f");
            }else if (currentLetterRepresentedByNumbers ==4){
                System.out.print("g");
            }else if (currentLetterRepresentedByNumbers ==44){
                System.out.print("h");
            }else if (currentLetterRepresentedByNumbers ==444){
                System.out.print("i");
            }else if (currentLetterRepresentedByNumbers ==5){
                System.out.print("j");
            }else if (currentLetterRepresentedByNumbers ==55){
                System.out.print("k");
            }else if (currentLetterRepresentedByNumbers ==555){
                System.out.print("l");
            }else if (currentLetterRepresentedByNumbers ==6){
                System.out.print("m");
            }else if (currentLetterRepresentedByNumbers ==66){
                System.out.print("n");
            }else if (currentLetterRepresentedByNumbers ==666){
                System.out.print("o");
            }else if (currentLetterRepresentedByNumbers ==7){
                System.out.print("p");
            }else if (currentLetterRepresentedByNumbers ==77){
                System.out.print("q");
            }else if (currentLetterRepresentedByNumbers ==777){
                System.out.print("r");
            }else if (currentLetterRepresentedByNumbers ==7777){
                System.out.print("s");
            }else if (currentLetterRepresentedByNumbers ==8){
                System.out.print("t");
            }else if (currentLetterRepresentedByNumbers ==88){
                System.out.print("u");
            }else if (currentLetterRepresentedByNumbers ==888){
                System.out.print("v");
            }else if (currentLetterRepresentedByNumbers ==9){
                System.out.print("w");
            }else if (currentLetterRepresentedByNumbers ==99){
                System.out.print("x");
            }else if (currentLetterRepresentedByNumbers ==999){
                System.out.print("y");
            }else if (currentLetterRepresentedByNumbers ==9999){
                System.out.print("z");
            }else if (currentLetterRepresentedByNumbers ==0){
                System.out.print(" ");
            }
        }
    }
}
