import Objects.User;
import Objects.Data;
import database.FitnessRepository;
import enums.Gender;

public class FitnessMain {

    public static void main(String[] args) {
        FitnessRepository fitnessRepository = new FitnessRepository();
        User user3 = new User("hlgkk@gmgm.hu", "Katki", Gender.FEMALE, 1958);
        fitnessRepository.allDataByUserEmail(user3.getEmail());
//        System.out.println(user2);
//        fitnessRepository.newUser(user3);
//        Data data2 = new Data(188, 82, 28, 35.3);
//        fitnessRepository.newData(user3.getEmail(), data2);
//        data2.setIdealBodyFatRate(data2.idealBodyFatRateCalc(user2.getGender()));
//        data2.setIdealMuscleMassRate(data2.idealMuscleRateCalc(user2.getGender()));
//        System.out.println(data);
//        System.out.println(user2);

    }
}
