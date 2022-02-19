package fitnessTracker;

import fitnessTracker.objects.Data;
import fitnessTracker.objects.User;

public class Menu {

    public void printer() {
    }

    public void resultMessages(User user) {
        Data first = user.getFirstData();
        Data previous = user.getPreviousData();
        Data actual = user.getActualData();

        if (previous.getSerial() == 0) {
            previous = first;
        }

        if (first.getSerial() != 0) {
            System.out.println("Weight compared to the first result: " + diff(first.getWeight(), actual.getWeight()));
            System.out.println("Body fat compared to the first result: " + diff(first.getFat(), actual.getFat()));
            System.out.println("Muscle mass compared to the first result: " + diff(first.getMuscle(), actual.getMuscle()));
            System.out.println("BMI compared to the first result: " + diff(first.getBmi(), actual.getBmi()));
            System.out.println();

            System.out.println("Weight compared to the previous result: " + diff(previous.getWeight(), actual.getWeight()));
            System.out.println("Body fat compared to the previous result: " + diff(previous.getFat(), actual.getFat()));
            System.out.println("Muscle mass compared to the previous result: " + diff(previous.getMuscle(), actual.getMuscle()));
            System.out.println("BMI compared to the previous result: " + diff(previous.getBmi(), actual.getBmi()));
            System.out.println();

            System.out.println("Current weight rating: " + actual.getIdealWeightRate());
            System.out.println("Current body fat percentage rating: " + actual.getIdealBodyFatRate());
            System.out.println("Current muscle mass index rating: " + actual.getIdealMuscleMassRate());
            System.out.println("Current BMI rating: " + actual.getBmiRate());
        } else {
            System.out.println("There's not any data in the database!");
        }
    }

    public double diff(double one, double two) {
        double diff = (int) ((one - two) * 100);
        return diff / 100;
    }
}
