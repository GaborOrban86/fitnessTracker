package Objects;

import enums.*;

public class User extends Human {
    private Data firstData;
    private Data previousData;
    private Data actualData;

    public User() {
    }

    public User(String name, Gender gender, String email, int yearOfBirth) {
        super(name, gender, email, yearOfBirth);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", age=" + age +
                '}';
    }

    public Data getFirstData() {
        return firstData;
    }

    public void setFirstData(Data firstData) {
        this.firstData = firstData;
    }

    public Data getPreviousData() {
        return previousData;
    }

    public void setPreviousData(Data previousData) {
        this.previousData = previousData;
    }

    public Data getActualData() {
        return actualData;
    }

    public void setActualData(Data actualData) {
        this.actualData = actualData;
    }
}
