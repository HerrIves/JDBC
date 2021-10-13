package tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;

public class Tours {
    public static void displayData(ResultSet rs) throws SQLException {
        while (rs.next()){
            StringBuffer buffer = new StringBuffer();
            buffer.append("Tour " + rs.getInt("tourId") + ": ");
            buffer.append(rs.getString("tourName"));

            double price = rs.getDouble("price");
            NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
            String formattedPrice = nf.format(price);
            buffer.append(" (" + formattedPrice + ")");

            System.out.println(buffer.toString());
        }
    }
}
