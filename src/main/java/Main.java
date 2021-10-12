import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        try (
                Connection conn = DBUtil.getConnection(DBType.ORACLE);
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery("SELECT * FROM packages");
                ){

            rs.last();
            System.out.println("Number of rows:" + rs.getRow());

        } catch (SQLException e) {
            DBUtil.processException(e);

        }
    }
}