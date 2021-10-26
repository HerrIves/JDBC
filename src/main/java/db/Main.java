package db;

import db.beans.Admin;
import db.tables.AdminManager;
import util.InputHelper;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        AdminManager.displayAllRows();

        int adminId = (int) InputHelper.getDoubleInput("Select a row: ");

        Admin bean = AdminManager.getRow(adminId);

        if (bean == null){
            System.err.println("no rows were found");
        } else {
            System.out.println("Admin id: " + bean.getAdminId());
            System.out.println("User name id: " + bean.getUserName());
            System.out.println("password id: " + bean.getPassword());
        }
    }
}














