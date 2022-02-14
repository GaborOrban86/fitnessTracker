package Objects;

import datas.Data;

public class Person extends Human {
    private double idealBmi;
    private double idealBodyFat;
    private double idealMuscleMAss;
    private Data firstData = new Data();
    private Data previousData = new Data();
    private Data actualData = new Data();

    public Person(String name, String sex, String email, int yearOfBirth) {
        super(name, sex, email, yearOfBirth);
    }

    public double getIdealBmi() {
        return idealBmi;
    }

    public void setIdealBmi(double idealBmi) {
        this.idealBmi = idealBmi;
    }

    public double getIdealBodyFat() {
        return idealBodyFat;
    }

    public void setIdealBodyFat(double idealBodyFat) {
        this.idealBodyFat = idealBodyFat;
    }

    public double getIdealMuscleMAss() {
        return idealMuscleMAss;
    }

    public void setIdealMuscleMAss(double idealMuscleMAss) {
        this.idealMuscleMAss = idealMuscleMAss;
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

    public double IdealBmiCalculator() {
        return 0;
    }

    public double idealWeightCalculator() {
        return 0;
    }

    public double idealBodFatCalculator() {
        return 0;
    }

    public double idealMuscleCalculator() {
        return 0;
    }

}
