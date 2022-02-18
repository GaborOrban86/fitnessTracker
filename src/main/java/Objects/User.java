package Objects;

import enums.Gender;

import java.util.ArrayList;
import java.util.List;

public class User extends Human {
    private List<Data> allDatas = new ArrayList<>();

    public User() {
    }

    public User(String email, String name, Gender gender, int yearOfBirth) {
        super(email, name, gender, yearOfBirth);
    }

    @Override
    public String toString() {
        return "User{" +
                ", email='" + email + '\'' +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", yearOfBirth=" + yearOfBirth +
                ", age=" + age +
                '}';
    }

    public List<Data> getAllDatas() {
        return allDatas;
    }

    public void setAllDatas(List<Data> allDatas) {
        this.allDatas = allDatas;
    }
}
