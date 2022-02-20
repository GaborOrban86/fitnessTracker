package fitnessTracker.interfaces;

import fitnessTracker.enums.Gender;

import static fitnessTracker.enums.Gender.FEMALE;
import static fitnessTracker.enums.Gender.MALE;

public interface GenderGiver {

    default Gender setAGender(String genderName) {
        Gender gender;
        if (genderName.equals(FEMALE.getGenderName())) {
            gender = FEMALE;
        } else {
            gender = MALE;
        }
        return gender;
    }
}
