package kz.shelter.bd.dz.Model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static kz.shelter.bd.dz.Util.ConnectionInfo.*;

public class Connection {
    Text text = new Text();

    public void addDogInDb(DogScanner dogScanner) throws SQLException {
        Dog dog = dogScanner.getDogData();
        String sql = "INSERT INTO dogs (id, nickname, breed, age, owner_name) VALUES (?, ?, ?, ?, ?)";

        java.sql.Connection conn = null;
        try {
            conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

            text.ifConnectedSuccessfully();
            try {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, dog.getId());
                preparedStatement.setString(2, dog.getNickname());
                preparedStatement.setString(3, dog.getBreed());
                preparedStatement.setInt(4, dog.getAge());
                preparedStatement.setString(5, dog.getOwner_name());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw e;
            }
        } catch (SQLException e) {
            text.ifError();
            throw e;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }


    public List<Dog> selectDog(DogScanner dogScanner) throws SQLException {
        int age = DogScanner.getAgeFromUser();
        List<Dog> dogs = new ArrayList<>();
        String sql = "SELECT * FROM dogs WHERE age > ?";
        java.sql.Connection conn = null;
        try {
            conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            text.ifConnectedSuccessfully();

            try {
                //Подготавливаем нашу коннецию с запросом
                PreparedStatement preparedStatement = conn.prepareStatement(sql);

                preparedStatement.setInt(1, age);


                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    Dog dog = new Dog();

                    dog.setId(rs.getInt("id"));
                    dog.setNickname(rs.getString("nickname"));
                    dog.setAge(rs.getInt("age"));
                    dog.setBreed(rs.getString("breed"));
                    dog.setOwner_name("owner_name");
                    dogs.add(dog);


                }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        } catch (SQLException e) {
            text.ifError();
            throw new RuntimeException(e);
        } finally {
            conn.close();
        }
        return dogs;
    }


    public void deleteDog(DogScanner dogScanner) throws SQLException {
        String nickname = dogScanner.getNicknameFromUser();
        String sql = "DELETE FROM dogs WHERE nickname = ?";
        java.sql.Connection conn = null;
        try {
            conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            text.ifConnectedSuccessfully();

            try {
                //Подготавливаем нашу коннецию с запросом
                PreparedStatement preparedStatement = conn.prepareStatement(sql);

                preparedStatement.setString(1, nickname);
                int rowsUpdated = preparedStatement.executeUpdate();

                if (rowsUpdated > 0) {
                    text.ifDeleted();
                } else {
                    text.ifNotFound();
                }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        } catch (SQLException e) {
            text.ifError();
            throw new RuntimeException(e);
        } finally {
            conn.close();

        }
    }

    public void updateDogAgeByNickname(DogScanner dogScanner) throws SQLException {
        String nickname = dogScanner.getNicknameFromUser();
        int age = dogScanner.getAgeFromUser();

        String sql = "UPDATE dogs SET age = ? WHERE nickname = ?";

        try {
            java.sql.Connection conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

            PreparedStatement preparedStatement = conn.prepareStatement(sql);


            preparedStatement.setInt(1, age);
            preparedStatement.setString(2, nickname);



            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                text.ifAgeChanged();
            } else {
            text.ifNotFound();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    public void displayDogTable() throws SQLException {
        String sql = "SELECT * FROM dogs";

        try (java.sql.Connection conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = conn.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nickname = resultSet.getString("nickname");
                String breed = resultSet.getString("breed");
                int age = resultSet.getInt("age");
                String ownerName = resultSet.getString("owner_name");
                System.out.println(id + "\t" + nickname + "\t\t" + breed + "\t" + age + "\t" + ownerName);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}






