package MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class E04Orders {
    public static class Product {
        String productName;
        double price;
        int quantity;

        public Product(String productName, double price, int quantity) {
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice (double price) {
            this.price = price;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getProductName() {
            return productName;
        }

        public int getQuantity() {
            return quantity;
        }

        @Override
        public String toString() {
            return String.format("%.2f", price * quantity);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Object> products = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("buy")) {
            String[] inputAsStringArray = input.split(" ");
            String productName = inputAsStringArray[0];
            double price = Double.parseDouble(inputAsStringArray[1]);
            int quantity = Integer.parseInt(inputAsStringArray[2]);

            if (!products.containsKey(productName)) {
                Product currentProduct = new Product (productName, price, quantity);
                products.put(productName, currentProduct);
            } else {
                Product currentProduct = (Product) products.get(productName); // WOW
                int newQuantity = currentProduct.getQuantity() + quantity;
                double newPrice = price;
                currentProduct.setQuantity(newQuantity);
                currentProduct.setPrice(newPrice);
                products.put(productName, currentProduct);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Object> entry : products.entrySet()) {
            System.out.print(entry.getKey() + " -> " + entry.getValue());
            System.out.println();
        }

    }
}