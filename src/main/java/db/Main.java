package db;

import db.beans.Admin;
import db.tables.AdminManager;
import util.InputHelper;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Starting application");

        ConnectionManager.getInstance().setDbType(DBType.MYSQL);

        AdminManager.displayAllRows();

        int adminId = (int) InputHelper.getDoubleInput("Enter adminId for update: ");

        Admin bean = AdminManager.getRow(adminId);
        if (bean == null){
            System.out.println("nool");
            return;
        }

        String password = InputHelper.getInput("Enter new password");
        bean.setPassword(password);
        if (AdminManager.update(bean)){
            System.out.println("suksess");
        }else System.out.println("not");

        ConnectionManager.getInstance().close();
    }
}















