package ProgrammingFundamentalsFinalExams;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class EX03R03NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> cars = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\|");
            String carName = tokens[0];
            int mileage = Integer.parseInt(tokens[1]);
            int fuel = Integer.parseInt(tokens[2]);
            Car car = new Car(carName, mileage, fuel);
            cars.put(carName, car);
        }

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String[] tokens = input.split(" : ");
            String command = tokens[0];
            String carName = tokens[1];

            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(tokens[2]);
                    int fuel = Integer.parseInt(tokens[3]);

                    if (cars.get(carName).getFuel() < fuel) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        cars.get(carName).setMileage(cars.get(carName).getMileage() + distance);
                        cars.get(carName).setFuel(cars.get(carName).getFuel() - fuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n"
                                , carName, distance, fuel);
                    }

                    if (cars.get(carName).getMileage() > 100000) {
                        cars.remove(carName);
                        System.out.println("Time to sell the " + carName + "!");
                    }
                    break;

                case "Refuel":
                    fuel = Integer.parseInt(tokens[2]);

                    if (cars.get(carName).getFuel() + fuel > 75) {
                        //60 + 20 == 80 -> take 15
                        fuel = 75 - cars.get(carName).getFuel();
                        cars.get(carName).setFuel(75);
                    } else {
                        cars.get(carName).setFuel(cars.get(carName).getFuel() + fuel);
                    }

                    System.out.printf("%s refueled with %d liters%n", carName, fuel);
                    break;

                case "Revert":
                    int kilometers = Integer.parseInt(tokens[2]);

                    if (cars.get(carName).getMileage() - kilometers < 10000) {
                        cars.get(carName).setMileage(10000);
                    } else {
                        cars.get(carName).setMileage(cars.get(carName).getMileage() - kilometers);
                        System.out.printf("%s mileage decreased by %d kilometers%n", carName, kilometers);
                    }

                    break;
            }


            input = scanner.nextLine();
        }

        cars.entrySet().stream()
                .sorted((e1, e2) -> {
                    int res = Integer.compare(e2.getValue().getMileage(), e1.getValue().getMileage());
                    if (res == 0) {
                        res = e1.getKey().compareTo(e2.getKey());
                    }
                    return res;
                })
                .forEach(e -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                        e.getKey(), e.getValue().getMileage(), e.getValue().getFuel()));
    }


    public static class Car {
        String name;
        int mileage;
        int fuel;

        public Car(String name, int mileage, int fuel) {
            this.name = name;
            this.mileage = mileage;
            this.fuel = fuel;
        }

        public int getMileage() {
            return mileage;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public int getFuel() {
            return fuel;
        }

        public void setFuel(int fuel) {
            this.fuel = fuel;
        }
    }
}
