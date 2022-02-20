package fitnessTracker;

import fitnessTracker.objects.Data;
import fitnessTracker.objects.User;

import java.util.List;

public class Menu {

    public void userMenuPrinter() {
        System.out.println("Please, choose an option:");
        System.out.println("1. Create new user");
        System.out.println("2. Log in with an existing user");
    }

    public void dataMenuPrinterdata(){
        System.out.println();
        System.out.println("Please, choose an option:");
        System.out.println("1. Enter new data");
        System.out.println("2. Check your progress");
        System.out.println("3. View all data");
        System.out.println("4. Search for a data");
        System.out.println("5. Modify a data");
        System.out.println("6. Delete a data");
        System.out.println("7. Export all data");
        System.out.println("8. Exit");
    }

    public void firstDataPrinter() {
        System.out.println("Enter your first data");
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
            System.out.println();
        } else {
            System.out.println("There's not any data in the database!");
        }
    }

    public double diff(double one, double two) {
        double diff = (int) ((two - one) * 100);
        return diff / 100;
    }

    public void DataListPrinter(List<Data> list) {
        list.forEach(System.out::println);
    }
}
