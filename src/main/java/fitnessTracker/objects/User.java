package fitnessTracker.objects;

import fitnessTracker.enums.Gender;

import static fitnessTracker.enums.Gender.FEMALE;
import static fitnessTracker.enums.Gender.MALE;

public class User extends Human {
    private Data firstData;
    private Data previousData;
    private Data actualData;

    public User() {
    }

    public User(String email, String name, Gender gender, int yearOfBirth) {
        super(email, name, gender, yearOfBirth);
    }


    public Gender setAGenderForUser(String genderName) {
        Gender gender;
        if (genderName.equals(FEMALE.getGenderName())) {
            gender = FEMALE;
        } else {
            gender = MALE;
        }
        return gender;
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
