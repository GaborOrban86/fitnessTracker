package datas;

import java.time.LocalDate;

public class Data {
    private int height;
    private float weight;
    private float fat;
    private float muscle;
    private double bmi = bmiCalculator();
    private String month = tellTheMonth();

    public Data(int height, float weight, float fat, float muscle) {
        this.height = height;
        this.weight = weight;
        this.fat = fat;
        this.muscle = muscle;
        this.bmi = bmiCalculator();
        this.month = tellTheMonth();
    }

    public Data() {
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getFat() {
        return fat;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    public float getMuscle() {
        return muscle;
    }

    public void setMuscle(float muscle) {
        this.muscle = muscle;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    private String tellTheMonth() {
        LocalDate date = LocalDate.now();
        return String.valueOf(date.getMonth());
    }

    private double bmiCalculator() {
        double heightInSquareMeter = height * height / 100;

        int number = (int) ((weight / heightInSquareMeter) * 10000);
        double finalNumber = number;
        return finalNumber / 100;

    }
}
