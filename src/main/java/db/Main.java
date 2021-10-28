package db;

import db.tables.AdminManager;
import util.InputHelper;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        AdminManager.displayAllRows();

        int adminId = (int) InputHelper.getDoubleInput("Enter adminId for delete: ");

        if (AdminManager.delete(adminId)){
            System.out.println("suksess");
        }else System.out.println("not");

    }
}















