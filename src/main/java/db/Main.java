package db;

import db.tables.AdminManager;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        AdminManager.displayAllRows();
    }
}
