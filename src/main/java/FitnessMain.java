import Objects.User;
import datas.BMI;
import datas.Data;
import datas.Gender;

import java.util.Scanner;

public class FitnessMain {

    public static void main(String[] args) {
        User user2 = new User("Kati", Gender.FEMALE, "hlgk@gmgm.hu", 1986);
        Data data2 = new Data(192, 88, 28, 35.3);
        data2.setIdealBodyFatRate(data2.idealBodyFatRateCalc(user2.getGender()));
        data2.setIdealMuscleMassRate(data2.idealMuscleRateCalc(user2.getGender()));
        user2.setActualData(data2);
        Data data = user2.getActualData();
        System.out.println(data);

    }
}
