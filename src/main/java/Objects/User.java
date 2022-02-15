package Objects;

import datas.Data;
import datas.Rate;

public class User extends Human {
    private Rate bmiRate = bmiRateCalculator();
    private Rate idealWeight;
    private Rate idealBodyFat;
    private Rate idealMuscleMass;
    private Data firstData = new Data();
    private Data previousData = new Data();
    private Data actualData = new Data();

    public User(String name, String sex, String email, int yearOfBirth) {
        super(name, sex, email, yearOfBirth);
    }


    public Rate bmiRateCalculator() {
        if (actualData.getBmi() > 18.5 && actualData.getBmi() <= 24.9) {
            return Rate.NORMAL;
        } else if (actualData.getBmi() < 18.5) {
            return Rate.LOW;
        } else {
            return Rate.HIGH;
        }
    }

    public Rate idealWeight() {
        return null;
    }

    public Rate idealBodyFatCalculator() {
        return null;
    }

    public Rate idealMuscleCalculator() {
        return null;
    }

}
