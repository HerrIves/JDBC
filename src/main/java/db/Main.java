package db;

import db.beans.Admin;
import db.tables.AdminManager;
import util.InputHelper;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        AdminManager.displayAllRows();

        Admin bean = new Admin();
        bean.setUserName(InputHelper.getInput("User name: "));
        bean.setPassword(InputHelper.getInput("User password: "));

        boolean result = AdminManager.insert(bean);
        if (result){System.out.println("suksess");
        }else System.out.println("unsuksess");
    }
}















