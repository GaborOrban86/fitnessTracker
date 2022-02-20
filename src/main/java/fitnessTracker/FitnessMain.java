package fitnessTracker;

import fitnessTracker.database.FitnessRepository;
import fitnessTracker.objects.User;

public class FitnessMain {

    public static void main(String[] args) {
        FitnessRepository fr = new FitnessRepository();
        User user = fr.getUserByEmail("hlf@gmgm.hu");
        System.out.println(user.getGender());

    }
}
