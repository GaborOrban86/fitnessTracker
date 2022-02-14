import Objects.Human;
import Objects.Person;
import datas.Data;
import datas.Gender;

public class FitnessMain {
    public static void main(String[] args) {
        Person person2 = new Person("Kati", Gender.FEMALE.genderBack(), "hlgk@gmgm.hu", 1980);
        System.out.println(person2.getAge());
        System.out.println(person2.getYearOfBirth());
        Data data = new Data();
        System.out.println(data.getMonth());
        Data data2 = new Data(186, 102, 24, 68);
        System.out.println(data2.getMonth());
        System.out.println(data2.getBmi());
    }


}
