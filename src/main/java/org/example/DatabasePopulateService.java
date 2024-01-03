package org.example;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        Database db = Database.getInstance();
        Connection conn = db.getConnection();

        try {
            String query = "INSERT INTO client VALUES(?, ?),(?,?),(?,?),(?,?),(?,?);";
            PreparedStatement queryStatement = conn.prepareStatement(query);

            queryStatement.setInt(1, 1);
            queryStatement.setString(2,"OLEG");
            queryStatement.setInt(3, 2);
            queryStatement.setString(4,"MIRA");
            queryStatement.setInt(5, 3);
            queryStatement.setString(6,"TIMUR");
            queryStatement.setInt(7, 4);
            queryStatement.setString(8,"PAVEL");
            queryStatement.setInt(9, 5);
            queryStatement.setString(10,"LUNA");
            queryStatement.execute();

            String query2 = "INSERT INTO worker\n" +
                    "VALUES(?,?,?,?, ?),\n" +
                    "(?,?,?,?, ?),\n" +
                    "(?,?,?,?, ?),\n" +
                    "(?,?,?,?, ?),\n" +
                    "(?,?,?,?, ?),\n" +
                    "(?,?,?,?, ?),\n" +
                    "(?,?,?,?, ?),\n" +
                    "(?,?,?,?, ?),\n" +
                     "(?,?,?,?, ?),\n" +
                    "(?,?,?,?, ?);";
            PreparedStatement st2 = conn.prepareStatement(query2);

            st2.setInt(1,1);
            st2.setString(2, "GREGORY");
            st2.setDate(3, Date.valueOf("1968-01-01"));
            st2.setString(4,"SENIOR");
            st2.setInt(5,5000);

            st2.setInt(6,2);
            st2.setString(7, "KIRILL");
            st2.setDate(8, Date.valueOf("1998-01-01"));
            st2.setString(9,"MIDDLE");
            st2.setInt(10,3500);

            st2.setInt(11,3);
            st2.setString(12, "MAX");
            st2.setDate(13, Date.valueOf("2004-01-01"));
            st2.setString(14,"JUNIOR");
            st2.setInt(15,2000);

            st2.setInt(16,4);
            st2.setString(17, "DAN");
            st2.setDate(18, Date.valueOf("1999-01-01"));
            st2.setString(19,"JUNIOR");
            st2.setInt(20,2100);

            st2.setInt(21,5);
            st2.setString(22, "IVAN");
            st2.setDate(23, Date.valueOf("2008-01-01"));
            st2.setString(24,"TRAINEE");
            st2.setInt(25,1000);

            st2.setInt(26,6);
            st2.setString(27, "NATASHA");
            st2.setDate(28, Date.valueOf("1997-01-01"));
            st2.setString(29,"JUNIOR");
            st2.setInt(30,1900);

            st2.setInt(31,7);
            st2.setString(32, "EGOR");
            st2.setDate(33, Date.valueOf("1996-01-01"));
            st2.setString(34,"TRAINEE");
            st2.setInt(35,100);

            st2.setInt(36,9);
            st2.setString(37, "YURIY");
            st2.setDate(38, Date.valueOf("1990-01-01"));
            st2.setString(39,"MIDDLE");
            st2.setInt(40,3700);

            st2.setInt(41,8);
            st2.setString(42, "ANN");
            st2.setDate(43, Date.valueOf("1992-01-01"));
            st2.setString(44,"MIDDLE");
            st2.setInt(45,3600);

            st2.setInt(46,10);
            st2.setString(47, "MAX");
            st2.setDate(48, Date.valueOf("1999-01-01"));
            st2.setString(49,"MIDDLE");
            st2.setInt(50,3600);
            st2.execute();

            String query3 = "INSERT INTO project\n" +
                    "VALUES (?,?,?,?),\n"+
                    "(?,?,?,?),\n"+
                    "(?,?,?,?),\n"+
                    "(?,?,?,?),\n"+
                    "(?,?,?,?),\n"+
                    "(?,?,?,?),\n"+
                    "(?,?,?,?),\n"+
                    "(?,?,?,?),\n"+
                    "(?,?,?,?),\n"+
                    "(?,?,?,?);";
            PreparedStatement st3=conn.prepareStatement(query3);
            st3.setInt(1,1);
            st3.setInt(2,2);
            st3.setDate(3,Date.valueOf("2022-01-01"));
            st3.setDate(4,Date.valueOf("2023-01-01"));

            st3.setInt(5,2);
            st3.setInt(6,3);
            st3.setDate(7,Date.valueOf("2021-01-01"));
            st3.setDate(8,Date.valueOf("2022-01-01"));

            st3.setInt(9,3);
            st3.setInt(10,1);
            st3.setDate(11,Date.valueOf("2020-03-29"));
            st3.setDate(12,Date.valueOf("2021-01-01"));

            st3.setInt(13,4);
            st3.setInt(14,4);
            st3.setDate(15,Date.valueOf("2020-02-03"));
            st3.setDate(16,Date.valueOf("2020-03-10"));

            st3.setInt(17,5);
            st3.setInt(18,5);
            st3.setDate(19,Date.valueOf("2022-01-09"));
            st3.setDate(20,Date.valueOf("2022-03-10"));

            st3.setInt(21,6);
            st3.setInt(22,2);
            st3.setDate(23,Date.valueOf("2022-02-09"));
            st3.setDate(24,Date.valueOf("2022-03-12"));

            st3.setInt(25,7);
            st3.setInt(26,3);
            st3.setDate(27,Date.valueOf("2023-01-01"));
            st3.setDate(28,Date.valueOf("2023-04-04"));

            st3.setInt(29,8);
            st3.setInt(30,1);
            st3.setDate(31,Date.valueOf("2023-03-03"));
            st3.setDate(32,Date.valueOf("2023-06-06"));

            st3.setInt(33,9);
            st3.setInt(34,4);
            st3.setDate(35,Date.valueOf("2023-09-09"));
            st3.setDate(36,Date.valueOf("2024-03-02"));

            st3.setInt(37,10);
            st3.setInt(38,5);
            st3.setDate(39,Date.valueOf("2022-10-10"));
            st3.setDate(40,Date.valueOf("2023-03-01"));

            st3.execute();
            String query4="INSERT INTO project_worker\n" +
                    "VALUES(?,?),(?,?),(?,?),(?,?),(?,?)," +
                    "(?,?),(?,?),(?,?),(?,?),(?,?)," +
                    "(?,?),(?,?),(?,?),(?,?),(?,?)," +
                    "(?,?),(?,?),(?,?),(?,?),(?,?)," +
                    "(?,?),(?,?),(?,?),(?,?),(?,?)," +
                    "(?,?),(?,?),(?,?);";

            PreparedStatement st4 = conn.prepareStatement(query4);
            st4.setInt(1,1);
            st4.setInt(2,10);
            st4.setInt(3,1);
            st4.setInt(4,3);
            st4.setInt(5,1);
            st4.setInt(6,2);
            st4.setInt(7,2);
            st4.setInt(8,3);
            st4.setInt(9,2);
            st4.setInt(10,4);
            st4.setInt(11,2);
            st4.setInt(12,1);
            st4.setInt(13,3);
            st4.setInt(14,1);
            st4.setInt(15,3);
            st4.setInt(16,5);
            st4.setInt(17,3);
            st4.setInt(18,7);
            st4.setInt(19,3);
            st4.setInt(20,10);



            st4.setInt(21,4);
            st4.setInt(22,2);
            st4.setInt(23,5);
            st4.setInt(24,1);
            st4.setInt(25,5);
            st4.setInt(26,4);
            st4.setInt(27,6);
            st4.setInt(28,7);
            st4.setInt(29,6);
            st4.setInt(30,8);
            st4.setInt(31,6);
            st4.setInt(32,9);
            st4.setInt(33,6);
            st4.setInt(34,2);
            st4.setInt(35,7);
            st4.setInt(36,1);
            st4.setInt(37,7);
            st4.setInt(38,5);
            st4.setInt(39,7);
            st4.setInt(40,6);
            st4.setInt(41,8);
            st4.setInt(42,1);

            st4.setInt(43,8);
            st4.setInt(44,8);
            st4.setInt(45,8);
            st4.setInt(46,9);
            st4.setInt(47,9);
            st4.setInt(48,9);
            st4.setInt(49,9);
            st4.setInt(50,10);
            st4.setInt(51,10);
            st4.setInt(52,5);
            st4.setInt(53,10);
            st4.setInt(54,7);
            st4.setInt(55,10);
            st4.setInt(56,6);

            st4.execute();
            System.out.println("Database is filled");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
