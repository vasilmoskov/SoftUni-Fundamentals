package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class E11Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt (scanner.nextLine());

        double highestSnowballValue = 0;
        int highestSnowballSnow = 0;
        int highestSnowballTime = 0;
        int highestSnowballQuality = 0;

        for (int i = 0; i < n; i++) {
            int snowballSnow = Integer.parseInt (scanner.nextLine());
            int snowballTime  = Integer.parseInt (scanner.nextLine());
            int snowballQuality   = Integer.parseInt (scanner.nextLine());
            double snowballValue = Math.pow(((double) snowballSnow/snowballTime), snowballQuality);
            if (snowballValue>highestSnowballValue) {
                highestSnowballValue = snowballValue;
                highestSnowballSnow=snowballSnow;
                highestSnowballTime=snowballTime;
                highestSnowballQuality=snowballQuality;
            }
        }

        System.out.printf("%d : %d = %.0f (%d)", highestSnowballSnow, highestSnowballTime, highestSnowballValue, highestSnowballQuality);
    }
}
