package ObjectsAndClassesMoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ME02RawData {

    public static class Car {
        String model;
        Engine engineClass;
        Cargo cargoClass;
        Tire[] tires;

        public Car(String model, Engine engineClass, Cargo cargoClass, Tire[] tires) {
            this.model = model;
            this.engineClass = engineClass;
            this.cargoClass = cargoClass;
            this.tires = tires;
        }

        public Tire[] getTires() {
            return tires;
        }

        public Engine getEngineClass() {
            return engineClass;
        }

        @Override
        public String toString() {
            return model;
        }
    }

    public static class Engine {
        int speed;
        int power;

        public Engine(int speed, int power) {
            this.speed = speed;
            this.power = power;
        }

        public int getPower() {
            return power;
        }
    }

    public static class Cargo {
        int weight;
        String type;

        public Cargo(int weight, String type) {
            this.weight = weight;
            this.type = type;
        }
    }

    public static class Tire {
        double pressure;
        int age;

        public Tire(double pressure, int age) {
            this.pressure = pressure;
            this.age = age;
        }

        public double getPressure() {
            return pressure;
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            // speed, power, weight and tire age are integers,
            // tire pressure is a double.

            String[] input = scanner.nextLine().split(" ");

            //“<Model>
            String model = input[0];

            // <EngineSpeed> <EnginePower>
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            Engine engineClass = new Engine(engineSpeed, enginePower);

            // <CargoWeight> <CargoType>
            int weight = Integer.parseInt(input[3]);
            String type = input[4];
            Cargo cargoClass = new Cargo(weight, type);

            // <Tire1Pressure> <Tire1Age>
            // <Tire2Pressure> <Tire2Age>
            // <Tire3Pressure> <Tire3Age>
            // <Tire4Pressure> <Tire4Age>”

            double tire1Pressure = Double.parseDouble(input[5]);
            int tire1Age = Integer.parseInt(input[6]);
            Tire tire1 = new Tire(tire1Pressure, tire1Age);

            double tire2Pressure = Double.parseDouble(input[7]);
            int tire2Age = Integer.parseInt(input[8]);
            Tire tire2 = new Tire(tire2Pressure, tire2Age);

            double tire3Pressure = Double.parseDouble(input[9]);
            int tire3Age = Integer.parseInt(input[10]);
            Tire tire3 = new Tire(tire3Pressure, tire3Age);

            double tire4Pressure = Double.parseDouble(input[11]);
            int tire4Age = Integer.parseInt(input[12]);
            Tire tire4 = new Tire(tire4Pressure, tire4Age);

            Tire[] tires = new Tire[]{tire1, tire2, tire3, tire4};

            Car car = new Car(model, engineClass, cargoClass, tires);

            cars.add(car);
        }

        String command = scanner.nextLine();

        switch (command) {
            case "fragile":
                for (int i = 0; i < cars.size(); i++) {
                    Car currentCar = cars.get(i);

                    Tire[] tires = currentCar.getTires();
                    for (int j = 0; j < tires.length; j++) {
                        if (tires[j].getPressure() < 1) {
                            System.out.println(currentCar);
                            break;
                        }
                    }
                }
                break;

            case "flamable":
                for (int i = 0; i < cars.size(); i++) {
                    Car currentCar = cars.get(i);

                    Engine engine = currentCar.getEngineClass();

                    int power = engine.getPower();

                    if (power > 250) {
                        System.out.println(currentCar);
                    }
                }
                break;
        }
    }
}
