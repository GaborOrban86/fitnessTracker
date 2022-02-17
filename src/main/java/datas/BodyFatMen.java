package datas;

public enum BodyFatMen {
    MIN (14.0), MAX(24.0);

    private final double limit;

    BodyFatMen(double limit) {
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }
}
