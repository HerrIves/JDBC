package tables;

import java.sql.ResultSet;
import java.sql.SQLException;

public class States {
    public static void displayData(ResultSet rs) throws SQLException {
        while (rs.next()) {
            StringBuffer buffer = new StringBuffer();
            buffer.append("State " + rs.getString("stateName"));

            System.out.println(buffer.toString());
        }
    }
}
