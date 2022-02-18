package database;

import Objects.Data;
import Objects.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

                Data data = dataMaker(resultSet.getInt("id"), resultSet.getInt("height"),
                        resultSet.getDouble("weight"), resultSet.getDouble("fat"),
                        resultSet.getDouble("muscle"), resultSet.getDouble("bmi"),
                        resultSet.getString("month"), resultSet.getString("gender"));
                datas.add(data);
            }
            datas.forEach(System.out::println);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return datas;
    }

    public Data searchDataById(int id) {
        Data data = new Data();
        String dataQuery = "SELECT * FROM datas f " +
                "JOIN user u ON u.email = f.user_email " +
                "WHERE f.id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(dataQuery)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                data = dataMaker(resultSet.getInt("id"), resultSet.getInt("height"),
                        resultSet.getDouble("weight"), resultSet.getDouble("fat"),
                        resultSet.getDouble("muscle"), resultSet.getDouble("bmi"),
                        resultSet.getString("month"), resultSet.getString("gender"));
            }
            if(data.getSerial() != 0){
                System.out.println(data);
            } else {
                System.out.println("This data is not exists.");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

    public Data modifyDataById() {
        return null;
    }

    public Data deleteDataById() {
        return null;
    }

    public Data dataMaker(int id, int height, Double weight, Double fat, Double muscle,
                          Double bmi, String month, String genderName) {
        Data data = new Data();
        data.setSerial(id);
        data.setHeight(height);
        data.setWeight(weight);
        data.setFat(fat);
        data.setMuscle(muscle);
        data.setBmi(bmi);
        data.setMonth(month);
        data.setBmiRate(data.idealBmiRateCalc());
        data.setIdealWeightRate(data.idealWeightRateCalc());
        data.setIdealBodyFatRate(data.idealBodyFatRateCalc(data.setAGender(genderName)));
        data.setIdealMuscleMassRate(data.idealMuscleRateCalc(data.setAGender(genderName)));
        return data;
    }

}


