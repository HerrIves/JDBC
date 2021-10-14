import tables.States;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery("SELECT * " +
                                                      "FROM states " +
                                                      "LIMIT 5, 5");
                ){

            States.displayData(rs);

        } catch (SQLException e) {
            DBUtil.processException(e);

        }
    }
}