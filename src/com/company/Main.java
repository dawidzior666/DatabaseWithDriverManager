package com.company;


import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class Main {

    public static void RetreiveRecords(int r){




    }
    public static void main(String[] args) throws SQLException, IOException {
	        TableService ts1=new TableService();
       // System.out.println(ts1.recordRetreive(22));
      //  System.out.println(ts1.recordInsert("JOHN","DEEP"));
       // System.out.println(ts1.recordUpdate(56,"Jan","Kowalski"));
        System.out.println(ts1.recordDelete("JOHN","DEEP"));
    }














    /*    Connection conn;
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
            // ...

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM author");

        while(rs.next()) {
            System.out.println(rs.getInt("id") + " : " + rs.getString("name"));
        }
            rs.close();
            stmt.close();
            conn.close();
        } catch ( SQLException e) {
            e.printStackTrace();
        }
*/


}
