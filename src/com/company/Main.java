package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {
        System.out.println("Select one action: CREATE, READ, UPDATE, DELETE, LIST TABLE");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TableService ts1 = new TableService();
        String action = "";
        try {
            action = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (action) {
            case "CREATE": {
                System.out.println("enter first name");
                String firstName = br.readLine();
                System.out.println("enter last name");
                String lastName = br.readLine();
                System.out.println("Dodano:\n " + ts1.recordInsert(firstName, lastName));
            }
            break;
            case "READ": {
                System.out.println("enter id number");
                int id = Integer.parseInt(br.readLine());
                System.out.println(ts1.recordRead(id));
            }
            break;
            case "LIST TABLE": {
                System.out.println(ts1.recordRead());
            }
            break;
            case "UPDATE": {
                System.out.println("enter id number");
                int id = Integer.parseInt(br.readLine());
                System.out.println("enter new first name");
                String firstName = br.readLine();
                System.out.println("enter new last name");
                String lastName = br.readLine();
                System.out.println(ts1.recordUpdate(id, firstName, lastName));
            }
            break;
            case "DELETE": {
                System.out.println("enter id number");
                int id = Integer.parseInt(br.readLine());
                System.out.println("enter first name");
                String firstName = br.readLine();
                System.out.println("enter last name");
                String lastName = br.readLine();
                System.out.println(ts1.recordDelete(id, firstName, lastName));
            }
            break;
            default:
                System.out.println("Wrong input");
        }
    }
}