import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
//    private static final String USERNAME = "c##spechtator";
//    private static final String PASSWORD = "123";
//    private static final String CONN_STRING = "jdbc:oracle:thin:@localhost:1521/orcl";

    private static final String USERNAME = "dbuser";
    private static final String PASSWORD = "dbpassword";
    private static final String CONN_STRING ="jdbc:mysql://localhost/explorecalifornia";

    public static void main(String[] args) throws SQLException {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Connected!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (conn != null){
                conn.close();
            }
        }


    }
}
