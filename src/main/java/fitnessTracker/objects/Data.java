package fitnessTracker.objects;

import fitnessTracker.enums.BMI;
import fitnessTracker.enums.Gender;
import fitnessTracker.enums.Rate;
import fitnessTracker.interfaces.GenderGiver;

import java.time.LocalDate;

public class Data implements GenderGiver {
    private int serial;
    private int height;
    private double weight;
    private double fat;
    private double muscle;
    private double bmi;
    private String month;
    private Rate bmiRate;
    private Rate idealWeightRate;
    private Rate idealBodyFatRate;
    private Rate idealMuscleMassRate;

    public Data() {
    }

    public Data(int height, double weight, double fat, double muscle) {
        this.serial = 0;
        this.height = height;
        this.weight = weight;
        this.fat = fat;
        this.muscle = muscle;
        this.bmi = bmiCalculator();
        this.month = tellTheMonth();
        this.bmiRate = idealBmiRateCalc();
        this.idealWeightRate = idealWeightRateCalc();
    }

    private String tellTheMonth() {
        LocalDate date = LocalDate.now();
        return String.valueOf(date.getMonth());
    }

    private double bmiCalculator() {
        double heightInSquareMeter = (double) height * height / 100;

        double bmi = (int) ((weight / heightInSquareMeter) * 10000);
        return bmi / 100;

    }

    private int idealWeightCalculator() {
        return getHeight() - 100;
    }

    public Rate idealBmiRateCalc() {
        double bmiMin = BMI.MIN.getLimit();
        double bmiMax = BMI.MAX.getLimit();
        if (bmi >= bmiMin && bmi <= bmiMax) {
            return Rate.NORMAL;
        } else if (bmi > bmiMax) {
            return Rate.HIGH;
        } else {
            return Rate.LOW;
        }
    }

    public Rate idealWeightRateCalc() {
        double idealWeight = idealWeightCalculator();
        if (weight < idealWeight - (idealWeight * 0.05)) {
            return Rate.LOW;
        } else if (weight > idealWeight + (idealWeight * 0.05)) {
            return Rate.HIGH;
        } else {
            return Rate.NORMAL;
        }
    }

    public Rate idealBodyFatRateCalc(Gender gender) {
        if (fat < gender.getBodyFatMin()) {
            return Rate.LOW;
        } else if (fat > gender.getBodyFatMax()) {
            return Rate.HIGH;
        } else {
            return Rate.NORMAL;
        }
    }

    public Rate idealMuscleRateCalc(Gender gender) {
        if (muscle < gender.getMuscleMassMin()) {
            return Rate.LOW;
        } else if (muscle > gender.getMuscleMassMax()) {
            return Rate.HIGH;
        } else {
            return Rate.NORMAL;
        }
    }

    @Override
    public String toString() {
        return "serial=" + serial +
                ", month='" + month +
                ", height=" + height +
                ", weight=" + weight +
                ", fat=" + fat +
                ", muscle=" + muscle +
                ", bmi=" + bmi +
                ", bmiRate=" + bmiRate +
                ", idealWeightRate=" + idealWeightRate +
                ", idealBodyFatRate=" + idealBodyFatRate +
                ", idealMuscleMassRate=" + idealMuscleMassRate;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getMuscle() {
        return muscle;
    }

    public void setMuscle(double muscle) {
        this.muscle = muscle;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Rate getBmiRate() {
        return bmiRate;
    }

    public void setBmiRate(Rate bmiRate) {
        this.bmiRate = bmiRate;
    }

    public Rate getIdealWeightRate() {
        return idealWeightRate;
    }

    public void setIdealWeightRate(Rate idealWeightRate) {
        this.idealWeightRate = idealWeightRate;
    }

    public Rate getIdealBodyFatRate() {
        return idealBodyFatRate;
    }

    public void setIdealBodyFatRate(Rate idealBodyFatRate) {
        this.idealBodyFatRate = idealBodyFatRate;
    }

    public Rate getIdealMuscleMassRate() {
        return idealMuscleMassRate;
    }

    public void setIdealMuscleMassRate(Rate idealMuscleMassRate) {
        this.idealMuscleMassRate = idealMuscleMassRate;
    }
}
