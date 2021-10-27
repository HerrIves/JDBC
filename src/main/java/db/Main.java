package db;

import db.beans.Admin;
import db.tables.AdminManager;
import util.InputHelper;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        AdminManager.displayAllRows();

        int adminId = (int) InputHelper.getDoubleInput("Select a row to update: ");

        Admin bean = AdminManager.getRow(adminId);
        if (bean == null){
            System.err.println("err");
            return;
        }

        String password = InputHelper.getInput("Enter new password: ");
        bean.setPassword(password);

        if (AdminManager.update(bean)){
            System.out.println("yes");
        }else System.out.println("no");
    }
}















