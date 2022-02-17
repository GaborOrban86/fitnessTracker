package datas;

public enum MuscleMassWomen {
    MIN(24.1), MAX(30.1);

    private final double limit;

    MuscleMassWomen(double limit) {
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }
}