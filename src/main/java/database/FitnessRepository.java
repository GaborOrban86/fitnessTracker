package database;

import Objects.Data;
import Objects.User;
import enums.Gender;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static enums.Gender.FEMALE;
import static enums.Gender.MALE;

public class FitnessRepository {

    private Connection connection;

    public FitnessRepository() {
        try {
            connection = DriverManager
                    .getConnection(DatabaseConfig.DB_URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public User newUser(User user) {
        String createUser = "INSERT INTO user (email, name, gender, year_of_birth, age) VALUES (?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(createUser)) {
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getGender().getGenderName());
            preparedStatement.setInt(4, user.getYearOfBirth());
            preparedStatement.setInt(5, user.getAge());

            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            System.out.println("User is already exists.");
        }
        return user;
    }

    public Data newData(String email, Data data) {
        String createData = "INSERT INTO datas (user_email, height, weight, fat, muscle, bmi, month) VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(createData)) {
            preparedStatement.setString(1, email);
            preparedStatement.setInt(2, data.getHeight());
            preparedStatement.setDouble(3, data.getWeight());
            preparedStatement.setDouble(4, data.getFat());
            preparedStatement.setDouble(5, data.getMuscle());
            preparedStatement.setDouble(6, data.getBmi());
            preparedStatement.setString(7, data.getMonth());


            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

    public List<Data> allDataByUserEmail(String email) {
        List<Data> datas = new ArrayList<>();
        String datasQuery = "SELECT * FROM datas f " +
                "JOIN user u ON u.email = f.user_email " +
                "WHERE user_email = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(datasQuery)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Data data = new Data();
                String genderName = resultSet.getString("gender");
                data.setSerial(resultSet.getInt("id"));
                data.setHeight(resultSet.getInt("height"));
                data.setWeight(resultSet.getDouble("weight"));
                data.setFat(resultSet.getDouble("fat"));
                data.setMuscle(resultSet.getDouble("muscle"));
                data.setBmi(resultSet.getDouble("bmi"));
                data.setMonth(resultSet.getString("month"));
                data.setBmiRate(data.idealBmiRateCalc());
                data.setIdealWeightRate(data.idealWeightRateCalc());
                data.setIdealBodyFatRate(data.idealBodyFatRateCalc(data.setAGender(genderName)));
                data.setIdealMuscleMassRate(data.idealMuscleRateCalc(data.setAGender(genderName)));
                datas.add(data);
            }
            datas.stream()
                    .forEach(System.out::println);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return datas;
    }

    public Data searchDataById() {
        return null;
    }

    public Data modifyDataById() {
        return null;
    }

    public Data deleteDataById() {
        return null;
    }

}


