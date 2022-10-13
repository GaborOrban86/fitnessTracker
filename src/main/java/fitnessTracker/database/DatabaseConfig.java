package fitnessTracker.database;

public class DatabaseConfig {
    public static final String DB_URL =
            "jdbc:h2:mem:testdb";
    public static final String USER = "sa";
    public static final String PASSWORD = "sa";

    private DatabaseConfig() {
    }
}
