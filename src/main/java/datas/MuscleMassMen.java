package datas;

public enum MuscleMassMen {

    MIN (24.3), MAX(30.3);

    private final double limit;

    MuscleMassMen(double limit) {
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }
}
