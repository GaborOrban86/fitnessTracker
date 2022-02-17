package datas;

public enum BMI {
    MIN (18.5), MAX(24.9);

private final double limit;


    BMI(double limit) {
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }
}
