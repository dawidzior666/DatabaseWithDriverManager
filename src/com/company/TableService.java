package com.company;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class TableService {
    private int actor_id;
    private String first_name;
    private String last_name;
    private String last_update = "2020-01-06";

    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?user=root&password=Noobplx0&serverTimezone=UTC");
    Statement stmt = conn.createStatement();
    ResultSet rs = null;
    String result = "";
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
    Writer output = new BufferedWriter(new FileWriter("DataLog.txt", true));

    public TableService() throws SQLException, IOException { }

    public String recordRead(int r) throws SQLException {
        try {
            rs = stmt.executeQuery("SELECT *FROM actor where actor_id=" + r + "");
            recordReadResultAppend();
            conn.close();
            output.append("SELECT : " + result + "\n");
            output.close();
        } catch (SQLException e) {
            System.out.println("Data selecting error:" + e);
        } catch (IOException e) {
            System.out.println(".: " + e);
        }
        return result;
    }
    public String recordRead() throws SQLException {
        try {
            rs = stmt.executeQuery("SELECT *FROM actor ");
            recordReadResultAppend();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Data selecting error:" + e);
        }
        return result;
    }
    public void recordReadResultAppend() throws SQLException {
        while (rs.next()) {
            actor_id = rs.getInt(1);
            first_name = rs.getString(2);
            last_name = rs.getString(3);
            last_update = rs.getString(4);
            result += first_name + " " + last_name + " " + last_update;
        }
    }

    public String recordInsert(String first_name, String last_name) {
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO actor VALUES(NULL,'" + first_name + "','" + last_name + "'," + "'" + sdf3.format(currentDate) + "'" + ")");
            result = first_name + " " + last_name + " " + sdf3.format(currentDate);
            conn.close();
            output.append("INSERT : " + result + "\n");
            output.close();
        } catch (SQLException | IOException e) {
            System.out.println("Data inserting error: " + e);
        }
        return result;
    }

    public String recordDelete(int actor_id, String first_name, String last_name) {
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM sakila.actor WHERE actor_id=" + "'" + actor_id + "'" + " AND " + " first_name=" + "'" + first_name + "'" + " AND " + "last_name=" + "'" + last_name + "'");
            result = first_name + " " + last_name + " " + sdf3.format(currentDate);
            output.append("DELETE : " + result + "\n");
            output.close();
            conn.close();
        } catch (SQLException | IOException e) {
            System.out.println("Data deleting error" + e);
        }
        return result;
    }

    public String recordUpdate(Integer actor_id, String first_name, String last_name) {
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE sakila.actor SET first_name=" + "'" + first_name + "'" + "," + "last_name=" + "'" + last_name + "'" + "," + "last_update=" + "'" + sdf3.format(currentDate) + "'" + " WHERE " + "actor_id=" + "'" + actor_id + "'");//???
            result = first_name + " " + last_name + " " + sdf3.format(currentDate);
            output.append("UPDATE : " + result + "\n");
            output.close();
            conn.close();
        } catch (SQLException | IOException e) {
            System.out.println("Updating error" + e);
        }
        return result;
    }
}