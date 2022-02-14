package Objects;

import java.time.LocalDate;

public abstract class Human {
    protected String name;
    protected String gender;
    protected String email;
    protected int yearOfBirth;
    protected int age = ageCalculator();

    public Human() {
    }

    public Human(String name, String sex, String email, int yearOfBirth) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.yearOfBirth = yearOfBirth;
        this.age = ageCalculator();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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

    public int ageCalculator() {
        LocalDate date = LocalDate.now();
        return date.getYear() - yearOfBirth;
    }
}