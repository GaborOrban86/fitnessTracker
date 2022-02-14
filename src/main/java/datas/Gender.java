package datas;

public enum Gender {
    MALE(1, "man"), FEMALE(2, "woman");

    private final int marker;
    private final String gender;


    Gender(int marker, String gender) {
        this.marker = marker;
        this.gender = gender;
    }

    public String genderBack() {
        return gender;
    }
}
