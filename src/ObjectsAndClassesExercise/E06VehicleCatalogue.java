package ObjectsAndClassesExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E06VehicleCatalogue {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Vehicle> vehicles = new ArrayList<>();

        while (!input.equals("End")) {
            String[] inputAsArr = input.split(" ");
            String typeOfVehicle = inputAsArr[0];
            String model = inputAsArr[1];
            String color = inputAsArr[2];
            int horsepower = Integer.parseInt(inputAsArr[3]);

            Vehicle currentVehicle = new Vehicle(typeOfVehicle, model, color, horsepower);
            vehicles.add(currentVehicle);

            input = scanner.nextLine();
        }

        String modelToPrint = scanner.nextLine();

        while (!modelToPrint.equals("Close the Catalogue")) {

            for (int i = 0; i < vehicles.size(); i++) {
                String modelOfCurrentVehicle = vehicles.get(i).getModel();

                if (modelToPrint.equals(modelOfCurrentVehicle)) {
                    System.out.println(vehicles.get(i));
                }

            }

            modelToPrint = scanner.nextLine();
        }

        double totalHorsepowerCars = 0;
        int countCars = 0;
        double totalHorsepowerTrucks = 0;
        int countTrucks = 0;

        for (int i = 0; i < vehicles.size(); i++) {

            if (vehicles.get(i).getTypeOfVehicle().equals("car")) {
                countCars++;
                totalHorsepowerCars += vehicles.get(i).getHorsepower();
            } else if (vehicles.get(i).getTypeOfVehicle().equals("truck")) {
                countTrucks++;
                totalHorsepowerTrucks += vehicles.get(i).getHorsepower();
            }

        }

        if (countCars == 0) {
            System.out.println("Cars have average horsepower of: 0.00.");
        } else {
            System.out.printf("Cars have average horsepower of: %.2f.%n", totalHorsepowerCars / countCars);
        }

        if (countTrucks == 0) {
            System.out.println("Trucks have average horsepower of: 0.00.");

        } else {
            System.out.printf("Trucks have average horsepower of: %.2f.%n", totalHorsepowerTrucks / countTrucks);

        }

    }

    public static class Vehicle {
        String typeOfVehicle;
        String model;
        String color;
        int horsepower;

        public Vehicle(String typeOfVehicle, String model, String color, int horsepower) {
            this.typeOfVehicle = typeOfVehicle;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }

        public String getTypeOfVehicle() {
            return typeOfVehicle;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public int getHorsepower() {
            return horsepower;
        }



        /*
        @Override
        public String toString() {
            return String.format("Type: %c%s%nModel: %s%nColor: %s%nHorsepower: %d",
                    getTypeOfVehicle().toUpperCase().charAt(0), getTypeOfVehicle().substring(1), getModel(), getColor(), getHorsepower());
        }

         */
    }
}
