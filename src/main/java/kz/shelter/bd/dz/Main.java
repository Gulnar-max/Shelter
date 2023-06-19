package kz.shelter.bd.dz;

import kz.shelter.bd.dz.Model.Connection;
import kz.shelter.bd.dz.Model.Dog;
import kz.shelter.bd.dz.Model.DogScanner;
import kz.shelter.bd.dz.Model.Text;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Text text = new Text();
        Connection connection = new Connection();

        Scanner scanner = new Scanner(System.in);
        DogScanner dogScanner = new DogScanner();
        int choice = 0;

        try{
            while (choice != 5) {
                text.menu();
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        connection.addDogInDb(dogScanner);
                        text.print();
                        connection.displayDogTable();
                        break;
                    case 2:
                        List<Dog> list = connection.selectDog(dogScanner);
                        System.out.println(list);
                        break;
                    case 3:
                        connection.deleteDog(dogScanner);
                        text.print();
                        connection.displayDogTable();
                        break;
                    case 4:
                        connection.updateDogAgeByNickname(dogScanner);
                        text.print();
                        connection.displayDogTable();
                        break;
                    case 5:
                        System.out.println("Программа завершена.");
                        break;
                    default:
                        System.out.println("Неверный выбор. Пожалуйста, выберите существующий пункт меню.");
                        break;
                }
            }
        } catch (SQLException e) {
            System.err.println("Connection failed...");
            throw new RuntimeException(e);
        } finally {
            scanner.close();
        }
    }
}


