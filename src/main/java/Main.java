import tables.States;
import tables.Tours;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery("SELECT * FROM states");
                ){

            States.displayData(rs);

            rs.last();
            System.out.println("Number of rows: " + rs.getRow());

            rs.first();
            System.out.println("The first state is: " + rs.getString("stateName"));

            rs.absolute(10);
            System.out.println("The 10th state is: " + rs.getString("stateName"));
        } catch (SQLException e) {
            DBUtil.processException(e);

        }
    }
}