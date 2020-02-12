package com.company;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.*;


public class TableService {
    private int actor_id;
    private String first_name;
    private String last_name;
    private String last_update;


    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;


    public String recordRetreive(int r){
        String result="";

        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?user=root&password=Noobplx0&serverTimezone=UTC");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT *FROM actor where actor_id="+r+"");


            while (rs.next()) {
                actor_id=rs.getInt(1);
                first_name=rs.getString(2);
                last_name=rs.getString(3);
                last_update=rs.getString(4);
                result+=actor_id+" "+first_name+" "+last_name+" "+last_update;
            }
            conn.close();

            Writer output = new BufferedWriter(new FileWriter("uzytkownicy.txt",true));
            output.append(result+"\n");
            output.close();

        }catch(SQLException e){
            System.out.println("błąd w uzyskiwaniu danych z bazy MySQL:"+e);

        }catch(IOException e){
            System.out.println("bła przy zapisie danych do pliku: "+e);

        }
        return result;

    }
    public String recordUpdate(String first_name, String last_name){
        this.first_name=first_name;
        this.last_name=last_name;
        last_update="2020-01-06";
        String result="";
        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?user=root&password=Noobplx0&serverTimezone=UTC");
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO actor VALUES(NULL,'"+first_name+"','"+last_name+"',\"2020-01-06\")");
            result = first_name+" "+last_name+" "+last_update;
            conn.close();
        }catch(SQLException e){
            System.out.println("błąd we wprowadzaniu danych do bazy MySQL:"+e);

        }

    return result;
    }
}
