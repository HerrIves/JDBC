import java.sql.*;

public class Main {
//    private static final String USERNAME = "c##spechtator";
//    private static final String PASSWORD = "123";
//    private static final String CONN_STRING = "jdbc:oracle:thin:@localhost:1521/orcl";

    private static final String USERNAME = "dbuser";
    private static final String PASSWORD = "dbpassword";
    private static final String CONN_STRING ="jdbc:mysql://localhost/explorecalifornia";

    public static void main(String[] args) throws SQLException {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM states");

            rs.last();
            System.out.println("Number of rows:" + rs.getRow());

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        } finally {
            if (rs != null){
                rs.close();
            }
        if (stmt != null){
                stmt.close();
            }
        if (conn != null){
                conn.close();
            }
        }


    }
}
