package by.anton.transportCompany.application.utils;

import java.util.Scanner;

public class GetInput {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInt() {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        scanner.next();
        System.out.println("Это не число. Повторите ввод");
        return getInt();
    }

    public static int getInt(String message) {
        System.out.println(message);
        return getInt();
    }

    public static double getDouble() {
        if (scanner.hasNextDouble()) {
            return scanner.nextDouble();
        }
        scanner.next();
        System.out.println("Это не число. Повторите ввод");
        return getDouble();
    }

    public static double getDouble(String message) {
        System.out.println(message);
        return getDouble();
    }

    public static String getString() {
        if (!scanner.hasNextInt()) {
            return scanner.next();
        }
        scanner.nextInt();
        System.out.println("это должно быть не число");
        return getString();

    }

    public static String getString(String message) {
        System.out.println(message);
        return getString();
    }

    public static Boolean getBoolean() {
        int a = getInt();
        if (a == 1) {
            return true;
        } else if (a == 0) {
            return false;
        }
        System.out.println("повторите ввод");
        return getBoolean();
    }

    public static Boolean getBoolean(String message) {
        System.out.println(message);
        return getBoolean();

    }
}
