package enums;

public enum Gender {
    MALE("man", 14, 24, 33.1, 39.1),
    FEMALE("woman", 21, 31, 24.1, 30.1);

    private final String genderName;
    private final double bodyFatMin;
    private final double bodyFatMax;
    private final double muscleMassMin;
    private final double muscleMassMax;

    Gender(String genderName, double bodyFatMin, double bodyFatMax, double muscleMassMin, double muscleMassMax) {
        this.genderName = genderName;
        this.bodyFatMin = bodyFatMin;
        this.bodyFatMax = bodyFatMax;
        this.muscleMassMin = muscleMassMin;
        this.muscleMassMax = muscleMassMax;
    }

    public String getGenderName() {
        return genderName;
    }

    public double getBodyFatMin() {
        return bodyFatMin;
    }

    public double getBodyFatMax() {
        return bodyFatMax;
    }

    public double getMuscleMassMin() {
        return muscleMassMin;
    }

    public double getMuscleMassMax() {
        return muscleMassMax;
    }
}
