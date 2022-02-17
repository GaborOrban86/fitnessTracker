package datas;

public enum BodyFatWomen {
    MIN (21.0), MAX(31.0);

    private final double limit;

    BodyFatWomen(double limit) {
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }
}
