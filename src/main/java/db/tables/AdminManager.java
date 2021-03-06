package db.tables;

import db.*;
import db.beans.Admin;

import java.sql.*;

public class AdminManager {

    private static Connection conn = ConnectionManager.getInstance().getConnection();

    public static void displayAllRows() throws SQLException {
        String sql = "SELECT adminId, userName, password FROM admin";
        try (
//                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                Statement stmt  = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {
            System.out.println("Admin Table:");
            while (rs.next()) {
                StringBuffer bf = new StringBuffer();
                bf.append(rs.getInt("adminId") + ": ");
                bf.append(rs.getString("userName") + ", ");
                bf.append(rs.getString("password"));
                System.out.println(bf.toString());
            }
        }
    }

    public static Admin getRow(int adminId) throws SQLException {
        String sql = "SELECT * FROM admin WHERE adminId = ?";
        ResultSet rs = null;

        try (
//                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, adminId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Admin bean = new Admin();
                bean.setAdminId(adminId);
                bean.setUserName(rs.getString("userName"));
                bean.setPassword(rs.getString("password"));
                return bean;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
    }

    public static boolean insert(Admin bean) throws SQLException {
        String sql = "INSERT INTO admin (userName, password)" + "VALUES (?, ?)";
        ResultSet keys = null;
        try (
//                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            stmt.setString(1, bean.getUserName());
            stmt.setString(2, bean.getPassword());
            int affected = stmt.executeUpdate();

            if (affected == 1) {
                keys = stmt.getGeneratedKeys();
                keys.next();
                int newKey = keys.getInt(1);
                bean.setAdminId(newKey);
            } else {
                System.err.println("no rows affected");
                return false;
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            if (keys != null) keys.close();
        }

        return true;
    }

    public static boolean update(Admin bean) {

        String sql = "SELECT * FROM admin WHERE adminId = ?";
        ResultSet rs = null;
        try (
//                Connection conn = DBUtil.getConnection(DBType.MYSQL);
                PreparedStatement stmt = conn.prepareStatement(
                        sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE)
        ) {
//            stmt.setString(1, bean.getUserName());
//            stmt.setString(2, bean.getPassword());
            stmt.setInt(1, bean.getAdminId());

            rs = stmt.executeQuery();

            if (rs.next()) {
                rs.updateString("userName", bean.getUserName());
                rs.updateString("password", bean.getPassword());
                rs.updateRow();
                return true;
            } else return false;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public static boolean delete(int adminId) {

        String sql = "DELETE FROM admin WHERE adminId = ?";

        try (Connection conn = DBUtil.getConnection(DBType.MYSQL);
             PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, adminId);
            int affected = stmt.executeUpdate();

            return affected == 1;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }


}
