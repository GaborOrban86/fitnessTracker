package datas;

public enum MuscleMassWomen {
    MIN(33.3), MAX(39.3);

    private final double limit;

    MuscleMassWomen(double limit) {
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }
}