package MethodsLab;

import java.util.Scanner;

public class L06CalculateRectangleArea {

    static int rectangleArea (int width, int height) {
        return width*height;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt (scanner.nextLine());
        int height = Integer.parseInt (scanner.nextLine());

        System.out.println(rectangleArea(width, height));
    }
}
