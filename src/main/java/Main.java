import tables.Tours;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery("SELECT * FROM tours");
                ){

            Tours.displayData(rs);

        } catch (SQLException e) {
            DBUtil.processException(e);

        }
    }
}