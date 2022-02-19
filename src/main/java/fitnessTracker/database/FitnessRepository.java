package fitnessTracker.database;

import fitnessTracker.objects.Data;
import fitnessTracker.objects.User;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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

    public void createUserTable() {
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS user (" +
                "email VARCHAR(100) PRIMARY KEY," +
                "name VARCHAR(100) NOT NULL, " +
                "gender VARCHAR(10) NOT NULL, " +
                "year_of_birth INT NOT NULL,  " +
                "age INT NOT NULL " +
                ");";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sqlCreateTable);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createDataTable() {
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS data (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "user_email VARCHAR(100) NOT NULL, " +
                "height INT NOT NULL, " +
                "weight DOUBLE NOT NULL, " +
                "fat DOUBLE NOT NULL, " +
                "muscle DOUBLE NOT NULL, " +
                "bmi DOUBLE NOT NULL, " +
                "month VARCHAR(45) NOT NULL " +
                ");";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sqlCreateTable);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public User createUser(User user) {
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


    public User getUserByEmail(String email) {
        User user = new User();
        String dataQuery = "SELECT * FROM user " +
                "WHERE user.email = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(dataQuery)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setEmail(resultSet.getString("email"));
                user.setName(resultSet.getString("name"));
                user.setGender(user.setAGenderForUser(resultSet.getString("gender")));
                user.setYearOfBirth(resultSet.getInt("year_of_birth"));
                user.setAge(resultSet.getInt("age"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public Data createData(String email, Data data) {
        String createData = "INSERT INTO data (user_email, height, weight, fat, muscle, bmi, month) VALUES (?,?,?,?,?,?,?)";
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
        String dataQuery = "SELECT * FROM data f " +
                "JOIN user u ON u.email = f.user_email " +
                "WHERE user_email = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(dataQuery)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Data data = dataMaker(resultSet.getInt("id"), resultSet.getInt("height"),
                        resultSet.getDouble("weight"), resultSet.getDouble("fat"),
                        resultSet.getDouble("muscle"), resultSet.getDouble("bmi"),
                        resultSet.getString("month"), resultSet.getString("gender"));
                datas.add(data);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return datas;
    }

    public Data searchDataById(int id) {
        Data data = new Data();
        String dataQuery = "SELECT * FROM data f " +
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
            if (data.getSerial() <= 0) {
                System.out.println("This data is not exists.");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

    public void modifyData(int id, int height, double weight, double fat, double mucle, double bmi) {
        String modifyQuery = "UPDATE data SET height = ?, weight = ?, fat = ?, muscle = ?, bmi = ? WHERE id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(modifyQuery)) {
            preparedStatement.setInt(1, height);
            preparedStatement.setDouble(2, weight);
            preparedStatement.setDouble(3, fat);
            preparedStatement.setDouble(4, mucle);
            preparedStatement.setDouble(5, bmi);
            preparedStatement.setInt(6, id);

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteDataById(int id) {
        String modifyQuery = "DELETE FROM data WHERE id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(modifyQuery)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Data giveFirst(String email) {
        Data data = new Data();
        String dataQuery = "SELECT * FROM data f " +
                "JOIN user u ON u.email = f.user_email " +
                "WHERE f.user_email = ? " +
                "ORDER BY id ASC " +
                "LIMIT 1";
        try (PreparedStatement preparedStatement = connection.prepareStatement(dataQuery)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                data = dataMaker(resultSet.getInt("id"), resultSet.getInt("height"),
                        resultSet.getDouble("weight"), resultSet.getDouble("fat"),
                        resultSet.getDouble("muscle"), resultSet.getDouble("bmi"),
                        resultSet.getString("month"), resultSet.getString("gender"));
            }
            if (data.getSerial() <= 0) {
                System.out.println("First data is not exists.");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

    public Data giveLast(String email) {
        Data data = new Data();
        String dataQuery = "SELECT * FROM data f " +
                "JOIN user u ON u.email = f.user_email " +
                "WHERE f.user_email = ? " +
                "ORDER BY id DESC " +
                "LIMIT 1";
        try (PreparedStatement preparedStatement = connection.prepareStatement(dataQuery)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                data = dataMaker(resultSet.getInt("id"), resultSet.getInt("height"),
                        resultSet.getDouble("weight"), resultSet.getDouble("fat"),
                        resultSet.getDouble("muscle"), resultSet.getDouble("bmi"),
                        resultSet.getString("month"), resultSet.getString("gender"));
            }
            if (data.getSerial() <= 0) {
                System.out.println("Current data is not exists.");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

    public Data givePrevious(String email) {
        Data data = new Data();
        String dataQuery = "SELECT * FROM data f " +
                "JOIN user u ON u.email = f.user_email " +
                "WHERE f.user_email = ? " +
                "ORDER BY id DESC " +
                "LIMIT 1 OFFSET 1";
        try (PreparedStatement preparedStatement = connection.prepareStatement(dataQuery)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                data = dataMaker(resultSet.getInt("id"), resultSet.getInt("height"),
                        resultSet.getDouble("weight"), resultSet.getDouble("fat"),
                        resultSet.getDouble("muscle"), resultSet.getDouble("bmi"),
                        resultSet.getString("month"), resultSet.getString("gender"));
            }
            if (data.getSerial() <= 0) {
                System.out.println("Previous data is not exists.");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

    public void exportAllDatas(User user) {
        List<Data> allDataList = allDataByUserEmail(user.getEmail());
        String fileName = "allData" + user.getName() + ".csv";
        Path output = Path.of("src/main/resources/fitnessTracker").resolve(fileName);

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(output)) {
            for (Data data : allDataList) {
                bufferedWriter.write(data.toString());
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
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


