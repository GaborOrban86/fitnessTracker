package Objects;

import datas.BMI;
import datas.Data;
import datas.Rate;
import datas.BMI;

public class User extends Human {
    private Rate bmiRate;
    private Rate idealWeightRate;
    private Rate idealBodyFatRate;
    private Rate idealMuscleMassRate;
    private Data firstData = new Data();
    private Data previousData = new Data();
    private Data actualData = new Data();

    public User(String name, String sex, String email, int yearOfBirth) {
        super(name, sex, email, yearOfBirth);
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
        return null;
    }

    public Rate idealMuscleRateCalc() {
        return null;
    }

}
