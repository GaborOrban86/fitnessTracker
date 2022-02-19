package fitnessTracker.objects;

import fitnessTracker.enums.Gender;

import java.time.LocalDate;

public abstract class Human {
    protected String email;
    protected String name;
    protected Gender gender;
    protected int yearOfBirth;
    protected int age;

    public Human() {
    }

    public Human(String email, String name, Gender gender, int yearOfBirth) {
        this.email = email;
        this.name = name;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        this.age = ageCalculator();
    }

    public int ageCalculator() {
        LocalDate date = LocalDate.now();
        return date.getYear() - yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}