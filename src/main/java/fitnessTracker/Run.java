package fitnessTracker;

import fitnessTracker.database.FitnessRepository;
import fitnessTracker.enums.Gender;
import fitnessTracker.objects.Data;
import fitnessTracker.objects.User;

import java.util.Scanner;

public class Run {
    private Menu menu = new Menu();
    private FitnessRepository fitnessRepository = new FitnessRepository();
    private User user = new User();
    private Data data = new Data();
    Scanner scanner = new Scanner(System.in);

    public void runApplication() {
        fitnessRepository.createUserTable();
        fitnessRepository.createDataTable();
        userMenu();
        dataMenu();
    }

    public void userMenu() {
        try {
            int height;
            double weight;
            double fat;
            double muscle;
            int option;
            boolean button = false;
            do {
                menu.userMenuPrinter();
                option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1:
                        System.out.println("Enter your email:");
                        String email = scanner.nextLine();
                        System.out.println("Enter your nickname:");
                        String name = scanner.nextLine();
                        System.out.println("Enter your gender (man/woman):");
                        Gender gender = user.setAGender(scanner.nextLine());
                        System.out.println("Enter your year of birth:");
                        int yearOfBirth = scanner.nextInt();
                        scanner.nextLine();
                        user = new User(email, name, gender, yearOfBirth);
                        fitnessRepository.createUser(user);
                        menu.firstDataPrinter();
                        System.out.println("Enter your height:");
                        height = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter your weight:");
                        weight = scanner.nextDouble();
                        System.out.println("Enter your body fat percentage:");
                        fat = scanner.nextDouble();
                        System.out.println("Enter your muscle mass percentage:");
                        muscle = scanner.nextDouble();
                        data = new Data(height, weight, fat, muscle);
                        fitnessRepository.createData(user.getEmail(), data);
                        userAllDataSetter();
                        button = true;
                        break;

                    case 2:
                        System.out.println("Enter your email address:");
                        user = fitnessRepository.getUserByEmail(scanner.nextLine());
                        if (user.getName() == null) {
                            System.out.println("Wrong email!");
                            button = false;
                        } else {
                            button = true;
                        }
                        break;

                    default:
                        System.out.println("Wrong option!");
                }
            } while (!button);
        } catch (Exception e) {
            System.out.println("Wrong input!");
        }

    }

    public void dataMenu() {
        try {
            int id;
            int height;
            double weight;
            double fat;
            double muscle;
            double bmi;
            int option;
            boolean button = false;
            do {
                userAllDataSetter();
                menu.dataMenuPrinterdata();
                option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1:
                        System.out.println("Enter your height:");
                        height = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter your weight:");
                        weight = scanner.nextDouble();
                        System.out.println("Enter your body fat percentage:");
                        fat = scanner.nextDouble();
                        System.out.println("Enter your muscle mass percentage:");
                        muscle = scanner.nextDouble();
                        data = new Data(height, weight, fat, muscle);
                        fitnessRepository.createData(user.getEmail(), data);
                        break;

                    case 2:
                        menu.resultMessages(user);
                        break;

                    case 3:
                        menu.dataListPrinter(fitnessRepository.allDataByUserEmail(user.getEmail()));
                        break;

                    case 4:
                        System.out.println("Enter ID-number to find a specific data:");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println(fitnessRepository.searchDataById(id));
                        break;

                    case 5:
                        System.out.println("Enter ID-number of the data you want to modify:");
                        id = scanner.nextInt();
                        System.out.println("Enter your new height:");
                        height = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter your new weight:");
                        weight = scanner.nextDouble();
                        System.out.println("Enter your new body fat percentage:");
                        fat = scanner.nextDouble();
                        System.out.println("Enter your new muscle mass percentage:");
                        muscle = scanner.nextDouble();
                        System.out.println("Enter your new BMI:");
                        bmi = scanner.nextDouble();
                        data = new Data(height, weight, fat, muscle);
                        fitnessRepository.modifyData(id, height, weight, fat, muscle, bmi);
                        break;

                    case 6:
                        System.out.println("Enter ID-number to delete a specific data:");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        fitnessRepository.deleteDataById(id);
                        break;
                    case 7:
                        fitnessRepository.exportAllDatas(user);
                        break;
                    case 8:
                        button = true;
                        break;

                    default:
                        System.out.println("Wrong option!");
                }
            } while (!button);
        } catch (Exception e) {
            System.out.println("Wrong input!");
        }
    }

    public void userAllDataSetter() {
        user.setFirstData(fitnessRepository.giveFirst(user.getEmail()));
        user.setPreviousData(fitnessRepository.givePrevious(user.getEmail()));
        user.setActualData(fitnessRepository.giveLast(user.getEmail()));
    }
}
