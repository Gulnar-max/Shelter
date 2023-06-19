package kz.shelter.bd.dz.Model;

import java.util.Scanner;

public class DogScanner {
    private static final Scanner scanner = new Scanner(System.in);

    public static Dog getDogData() {
        System.out.println("Введите данные собаки: ");
        System.out.println("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Кличка: ");
        String nickname = scanner.nextLine();

        System.out.println("Порода: ");
        String breed = scanner.nextLine();

        System.out.println("Возраст: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Имя хозяина: ");
        String ownerName = scanner.nextLine();

        return new Dog();
    }


    public static int getAgeFromUser() {
        System.out.println("Введите возраст собаки: ");
        return  scanner.nextInt();
    }

    public static String getNicknameFromUser() {
        System.out.println("Введите кличку собаки: ");
        return scanner.nextLine();
    }



    }

