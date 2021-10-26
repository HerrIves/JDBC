package db.tables;

import db.DBType;
import db.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Locale;

public class TourManager {
    public static void displayAllRows() throws SQLException {
        String sql = "SELECT adminId, userName, password FROM admin";
        try(
            Connection conn = DBUtil.getConnection(DBType.MYSQL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){
            System.out.println("Admin Table:");
            while (rs.next()){
                StringBuffer bf = new StringBuffer();
                bf.append("Tour" + rs.getInt("tourId") + ": ");
                bf.append(rs.getString("tourName"));

                double price = rs.getDouble("price");
                NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
                String formattedPrice = nf.format(price);
                bf.append(" (" + formattedPrice + ")");
                System.out.println(bf.toString());
            }
        }

    }
}
