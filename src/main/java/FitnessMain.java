import Objects.User;
import datas.Data;
import datas.Gender;

import java.util.Scanner;

public class FitnessMain {

    public static void main(String[] args) {
        User user2 = new User("Kati", Gender.FEMALE.genderBack(), "hlgk@gmgm.hu", 1986);
        System.out.println(user2.getAge());
        System.out.println(user2.getYearOfBirth());
        Data data = new Data();
        System.out.println(data.getMonth());
        Data data2 = new Data(192, 101.6, 28.6, 35.3);
        System.out.println(data2.getMonth());
        System.out.println(data2.getBmi());
//        boolean io = false;
//        int number = 0;
//        Scanner scanner = new Scanner(System.in);
//        while (io != true) {
//            System.out.println("Írd be a számot!");
//            if (number >= 0 && number <= 8) {
//                try {
//                    number = scanner.nextInt();
//                    scanner.nextLine();
//                    System.out.println("Siker!");
//                    io = true;
//                }
//            catch(RuntimeException exception){
//                System.out.println("Nem megfelelő bevitel!");
//                scanner.nextLine();
//            }
//            }
//                else{
//                    throw new RuntimeException("msg");
//                }
//            System.out.println(number);
//        }
    }
}
