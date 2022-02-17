import Objects.User;
import Objects.Data;
import enums.Gender;

public class FitnessMain {

    public static void main(String[] args) {
        User user2 = new User("Kati", Gender.FEMALE, "hlgk@gmgm.hu", 1978);
        Data data2 = new Data(192, 88, 28, 35.3);
        data2.setIdealBodyFatRate(data2.idealBodyFatRateCalc(user2.getGender()));
        data2.setIdealMuscleMassRate(data2.idealMuscleRateCalc(user2.getGender()));
        user2.setActualData(data2);
        Data data = user2.getActualData();
        System.out.println(data);
        System.out.println(user2);

    }
}
