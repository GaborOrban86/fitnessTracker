import Objects.User;
import datas.BMI;
import datas.Data;
import datas.Gender;

import java.util.Scanner;

public class FitnessMain {

    public static void main(String[] args) {
        User user2 = new User("Kati", Gender.FEMALE, "hlgk@gmgm.hu", 1986);
        System.out.println(user2.getAge());
        System.out.println(user2.getYearOfBirth());
        Data data = new Data();
        System.out.println(data.getMonth());
        Data data2 = new Data(192, 101.6, 28.6, 35.3);
        System.out.println(data2.getMonth());
        System.out.println(data2.getBmi());
    }
}
