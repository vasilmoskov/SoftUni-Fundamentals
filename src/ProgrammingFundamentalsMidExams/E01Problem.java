package ProgrammingFundamentalsMidExams;

import java.util.Scanner;

public class E01Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int amountOfBiscuitsPerWorkerPerDay = Integer.parseInt(scanner.nextLine());
        int countOfWorkers = Integer.parseInt(scanner.nextLine());
        int totalBiscuitsCompetingFactory = Integer.parseInt(scanner.nextLine());

        int total = 0;

        int dayProduction = amountOfBiscuitsPerWorkerPerDay * countOfWorkers;


        for (int i = 1; i <= 30; i++) {

            if (i % 3 == 0) {
                int thirdDayProduction = (int) Math.floor(dayProduction * 0.75);
                total += thirdDayProduction;

            } else {
                total += dayProduction;
            }


        }


        // total *= countOfWorkers;

        //  int everyThirdDay = (int) Math.floor(amountOfBiscuitsPerWorkerPerDay * 0.75);
        //int total = (10 * everyThirdDay + 20 * amountOfBiscuitsPerWorkerPerDay) * countOfWorkers;

        System.out.printf("You have produced %d biscuits for the past month.%n", total);

        if (total > totalBiscuitsCompetingFactory) {
            int difference = total - totalBiscuitsCompetingFactory;
            double percent =(double)difference / totalBiscuitsCompetingFactory * 100;
            System.out.printf("You produce %.2f percent more biscuits.", percent);
        } else {
            int difference = totalBiscuitsCompetingFactory - total;
            double percent =(double)difference / totalBiscuitsCompetingFactory * 100;
            System.out.printf("You produce %.2f percent less biscuits.", percent);

        }

    }
}
