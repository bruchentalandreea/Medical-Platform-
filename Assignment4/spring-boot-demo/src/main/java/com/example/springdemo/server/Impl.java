package com.example.springdemo.server;


import com.example.springdemo.entities.MedicationPlan;

import javax.jws.WebService;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebService(endpointInterface = "com.example.springdemo.server.Server")
public class Impl implements Server{
    ArrayList<String> list_start=new ArrayList<String>();
    ArrayList<String> list_end=new ArrayList<String>();
    ArrayList<Integer> list_id=new ArrayList<Integer>();
    ArrayList<Integer> list_id_sleep=new ArrayList<Integer>();
    int list_sleep_size ;
    String activity;
    @Override
    public String[] getActivityData(String activity_name) throws SQLException, ParseException {
        String url = "jdbc:mysql://localhost:3306/medication";
        String userName = "root";
        String password = "root";
        //int i=0;
        String[] array = new String[2];
        String start_time=null;
        String end_time=null;
        int idactivity;
        int idSleep;




        Connection conn = null;
        Statement stmt=null , stmt1= null;


        //Register JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        //Open a connection
        System.out.println("Connecting to a selected database...");
        try {
            conn = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        MedicationPlan medicationPlan = new MedicationPlan();
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "SELECT idactivity, start_time, end_time FROM activity WHERE activity_name= '" + activity_name + "'";

        try {
            stmt1 = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sleep = "SELECT idactivity FROM activity WHERE activity_name= 'Sleeping'";


        ResultSet rs = null;
        ResultSet rs1=null;
        try {
            rs = stmt.executeQuery(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            rs1 = stmt1.executeQuery(sleep);

        } catch (SQLException e) {
            e.printStackTrace();
        }


        //Extract data from result set
        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (!rs1.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //taken = rs.getInt("taken");
            idSleep=rs1.getInt("idactivity");
            idactivity=rs.getInt("idactivity");
            start_time=rs.getString("start_time");
            end_time=rs.getString("end_time");




            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date start_date = (Date) df.parse(start_time);
            Date end_date = (Date)df.parse(end_time);
            String newStartDateString = df.format(start_date);
            String newEndDateString = df.format(end_date);

            list_start.add(newStartDateString);
            list_end.add(newEndDateString);
            list_id.add(idactivity);
            list_id_sleep.add(idSleep);
            list_sleep_size=list_id_sleep.size();
            System.out.println("Start date : " + newStartDateString + "\n" + "  End date: " + newEndDateString + "\n" + "\n" );
            System.out.println("SIZE" + list_sleep_size);
            //System.out.println("LISTAAAA" + list_id_sleep);
            // list_end.add(end_time);



            // array[i]= Integer.toString(taken);
            // ++i;



        }
       // System.out.println(list_start);
        // System.out.println(list_end);
        rs.close();
        rs1.close();
        return array;
    }
        public Impl()
        {

        }

    public Impl(String activity) {
       try{
           getActivityData(activity);
       }
        catch (ParseException e) {
           e.printStackTrace();
       } catch (SQLException e) {
           e.printStackTrace();
       }
    }


    public Impl(ArrayList<Integer> list_id_sleep, int list_sleep_size) {
        this.list_id_sleep = list_id_sleep;
        this.list_sleep_size = list_sleep_size;
    }

    public ArrayList<Integer> getList_id() {
        return list_id;
    }

    public void setList_id(ArrayList<Integer> list_id) {
        this.list_id = list_id;
    }

    public  ArrayList<String> getList_start() {
        return list_start;
    }

    public void setList_start(ArrayList<String> list_start) {
        this.list_start = list_start;
    }

    public ArrayList<String> getList_end() {
        return list_end;
    }

    public void setList_end(ArrayList<String> list_end) {
        this.list_end = list_end;
    }

    public ArrayList<Integer> getList_id_sleep() {
        return list_id_sleep;
    }

    public void setList_id_sleep(ArrayList<Integer> list_id_sleep) {
        this.list_id_sleep = list_id_sleep;
    }

    public int getList_sleep_size() {
        return list_sleep_size;
    }

    public void setList_sleep_size(int list_sleep_size) {
        this.list_sleep_size = list_sleep_size;
    }
}

