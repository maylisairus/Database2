package org.example;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.sql.Connection;

public class DatabasePopulateService {
    public static void main(String[] args) {
        Database db = Database.getInstance();
        Connection conn = db.getConnection();

        try {
            ScriptRunner scriptRunner = new ScriptRunner(conn);
            scriptRunner.setSendFullScript(false);
            scriptRunner.setStopOnError(true);
            scriptRunner.runScript(new java.io.FileReader("src\\main\\resources\\sql\\populate_db.sql"));
            System.out.println("Database is filled");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
