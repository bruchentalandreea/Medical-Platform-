package com.example.springdemo.rmi;

import com.example.springdemo.entities.MedicationPlan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Impl implements Hello {

// Implementing the interface method
public List<MedicationPlan> getMedicationPlan () throws Exception {
        List<MedicationPlan> list = new ArrayList<MedicationPlan>();

        // JDBC driver name and database URL
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/medication";

        // Database credentials
        String USER = "root";
        String PASS = "root";

        Connection conn = null;
        Statement stmt = null;

        //Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        //Open a connection
        System.out.println("Connecting to a selected database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Connected database successfully...");

        //Execute a query
        System.out.println("Creating statement...");

        stmt = conn.createStatement();
        String sql = "SELECT * FROM medication_plan";
        ResultSet rs = stmt.executeQuery(sql);

        //Extract data from result set
        while(rs.next()) {
        // Retrieve by column name
        int id  = rs.getInt("id");
        String name = rs.getString("name");
        String start_date = rs.getString("start_date");
        String end_date= rs.getString("end_date");

        // Setting the values
            MedicationPlan med = new MedicationPlan();
        med.setId(id);
        med.setName(name);
        med.setStartDate(start_date);
        med.setEndDate(end_date);
        list.add(med);
        }
        rs.close();
        return list;

        }
}
