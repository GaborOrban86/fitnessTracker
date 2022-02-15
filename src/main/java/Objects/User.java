package Objects;

import datas.Data;
import datas.Rate;

public class User extends Human {
    private Rate bmiRate;
    private Rate idealWeightRate;
    private Rate idealBodyFat;
    private Rate idealMuscleMass;
    private Data firstData = new Data();
    private Data previousData = new Data();
    private Data actualData = new Data();

    public User(String name, String sex, String email, int yearOfBirth) {
        super(name, sex, email, yearOfBirth);
    }


    public Rate bmiRateCalculator() {
        double currentBmi = actualData.getBmi();
        if (currentBmi > 18.5 && currentBmi <= 24.9) {
            return Rate.NORMAL;
        } else if (currentBmi < 18.5) {
            return Rate.LOW;
        } else {
            return Rate.HIGH;
        }
    }

    public Rate idealWeightRate() {
        double idealWeight = actualData.getHeight() - 100;
        double currentWeight = actualData.getWeight();
        if (currentWeight < idealWeight - (idealWeight * 0.05)) {
            return Rate.LOW;
        } else if (currentWeight > idealWeight + (idealWeight * 0.05)) {
            return Rate.HIGH;
        } else {
            return Rate.NORMAL;
        }
    }

    public Rate idealBodyFatCalculator() {
        return null;
    }

    public Rate idealMuscleCalculator() {
        return null;
    }

}
