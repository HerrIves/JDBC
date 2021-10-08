import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String M_USERNAME = "dbuser";
    private static final String M_PASSWORD = "dbpassword";
    private static final String M_CONN_STRING ="jdbc:mysql://localhost/explorecalifornia";
    private static final String O_USERNAME = "c##spechtator";
    private static final String O_PASSWORD = "123";
    private static final String O_CONN_STRING ="jdbc:oracle:thin:@localhost:1521/orcl";

    public static Connection getConnection(DBType dbType) throws SQLException {
        switch (dbType) {
            case ORACLE:
                return DriverManager.getConnection(O_CONN_STRING, O_USERNAME, O_PASSWORD);
            case MYSQL:
                return DriverManager.getConnection(M_CONN_STRING, M_USERNAME, M_PASSWORD);

            default: return null;
        }
    }
}
