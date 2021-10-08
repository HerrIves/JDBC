import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            conn = DBUtil.getConnection(DBType.MYSQL);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM packages");

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
