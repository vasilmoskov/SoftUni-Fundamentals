package ObjectsAndClassesMoreExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ME03CarSalesman {

    public static class Car {
        String model;
        Engine engineClass;
        String weight;
        String color;

        public Car(String model, Engine engineClass, String weight, String color) {
            this.model = model;
            this.engineClass = engineClass;
            this.weight = weight;
            this.color = color;
        }

        @Override
        public String toString() {
            return String.format("%s:%n  %s:%n    Power: %d%n    Displacement: %s%n    Efficiency: %s%n  Weight: %s%n  Color: %s%n",
                    model, engineClass.getModel(), engineClass.getPower(), engineClass.getDisplacement(), engineClass.getEfficiency(), weight, color);
        }
    }

    public static class Engine {
        String model;
        int power;
        String displacement;
        String efficiency;

        public Engine(String model, int power, String displacement, String efficiency) {
            this.model = model;
            this.power = power;
            this.displacement = displacement;
            this.efficiency = efficiency;
        }

        public String getModel() {
            return model;
        }

        public int getPower() {
            return power;
        }

        public String getDisplacement() {
            return displacement;
        }

        public String getEfficiency() {
            return efficiency;
        }
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // “<Model> <Power> <Displacement> <Efficiency>”.
            String[] input = scanner.nextLine().split(" ");

            String model = input[0];
            int power = Integer.parseInt(input[1]);

            String displacement = "n/a";
            String efficiency = "n/a";

            if (input.length == 3) {
                String displacementOrEfficiency = input[2];
                if (Character.isDigit(displacementOrEfficiency.charAt(0))) {
                    displacement = input[2];
                } else {
                    efficiency = input[2];
                }
            } else if (input.length == 4) {
                displacement = input[2];
                efficiency = input[3];
            }

            Engine currentEngine = new Engine(model, power, displacement, efficiency);
            engines.add(currentEngine);
        }

        int m = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < m; i++) {
            //“<Model> <Engine> <Weight> <Color>”,
            // where the engine in the format will be the model of an existing Engine.

            String[] input = scanner.nextLine().split(" ");

            String model = input[0];
            String engine = input[1];
            Engine engineClass = null;

            for (int j = 0; j < engines.size(); j++) {
                String engineModel = engines.get(j).getModel();
                if (engine.equals(engineModel)) {
                    engineClass = engines.get(j);
                }
            }

            String weight = "n/a";
            String color = "n/a";

            if (input.length == 3) {
                String weightOrColor = input[2];
                if (Character.isDigit(weightOrColor.charAt(0))) {
                    weight = input[2];
                } else {
                    color = input[2];
                }
            } else if (input.length == 4) {
                weight = input[2];
                color = input[3];
            }

            Car currentCar = new Car(model, engineClass, weight, color);

            cars.add(currentCar);


        }

        for (int i = 0; i < cars.size(); i++) {
            System.out.print(cars.get(i));
        }

    }
}