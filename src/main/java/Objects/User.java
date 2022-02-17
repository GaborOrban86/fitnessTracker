package Objects;

import datas.*;

public class User extends Human {
    private Rate bmiRate = idealBmiRateCalc();
    private Rate idealWeightRate = idealWeightRateCalc();
    private Rate idealBodyFatRate = idealBodyFatRateCalc();
    private Rate idealMuscleMassRate = idealMuscleRateCalc();
    private Data firstData = new Data();
    private Data previousData = new Data();
    private Data actualData = new Data();

    public User(String name, Gender gender, String email, int yearOfBirth) {
        super(name, gender, email, yearOfBirth);
    }

    public Rate idealBmiRateCalc() {
        double currentBmi = actualData.getBmi();
        double bmiMin = BMI.MIN.getLimit();
        double bmiMax = BMI.MAX.getLimit();
        if (currentBmi > bmiMin && currentBmi <= bmiMax) {
            return Rate.NORMAL;
        } else if (currentBmi < bmiMin) {
            return Rate.LOW;
        } else {
            return Rate.HIGH;
        }
    }

    public Rate idealWeightRateCalc() {
        double idealWeight = actualData.idealWeightCalculator();
        double currentWeight = actualData.getWeight();
        if (currentWeight < idealWeight - (idealWeight * 0.05)) {
            return Rate.LOW;
        } else if (currentWeight > idealWeight + (idealWeight * 0.05)) {
            return Rate.HIGH;
        } else {
            return Rate.NORMAL;
        }
    }

    public Rate idealBodyFatRateCalc() {
        double currentBodyFat = actualData.getFat();
        if (gender.equals(Gender.FEMALE)) {
            if (currentBodyFat < BodyFatWomen.MIN.getLimit()) {
                return Rate.LOW;
            } else if (currentBodyFat > BodyFatWomen.MAX.getLimit()) {
                return Rate.HIGH;
            } else {
                return Rate.NORMAL;
            }
        } else {
            if (currentBodyFat < BodyFatMen.MIN.getLimit()) {
                return Rate.LOW;
            } else if (currentBodyFat > BodyFatMen.MAX.getLimit()) {
                return Rate.HIGH;
            } else {
                return Rate.NORMAL;
            }
        }
    }

    public Rate idealMuscleRateCalc() {
        double currentMuscleMAss = actualData.getMuscle();
        if (gender.equals(Gender.FEMALE)) {
            if (currentMuscleMAss < MuscleMassWomen.MIN.getLimit()) {
                return Rate.LOW;
            } else if (currentMuscleMAss > MuscleMassWomen.MAX.getLimit()) {
                return Rate.HIGH;
            } else {
                return Rate.NORMAL;
            }
        } else {
            if (currentMuscleMAss < MuscleMassMen.MIN.getLimit()) {
                return Rate.LOW;
            } else if (currentMuscleMAss > MuscleMassMen.MAX.getLimit()) {
                return Rate.HIGH;
            } else {
                return Rate.NORMAL;
            }
        }
    }

}
