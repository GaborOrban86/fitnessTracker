package datas;

public enum MuscleMassMen {

    MIN (33.1), MAX(39.1);

    private final double limit;

    MuscleMassMen(double limit) {
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }
}
