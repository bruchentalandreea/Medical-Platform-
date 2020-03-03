package com.example.springdemo.rmi;

import com.example.springdemo.GUI.GUI;
import com.example.springdemo.entities.MedicationPlan;

import javax.swing.*;
import java.awt.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
import java.util.List;

public class Client {

    private static GUI GUI ;
    public static int nr=0;
    public static Integer number = 0;
    public static String start;
    public static String end;

    public static ArrayList<Integer> delete ;

    public Client(ArrayList delete) throws Exception {
        this.delete = delete;
        logger(listCreater(), delete);
    }
    public static void main(String[] args)throws Exception {
        try {

            // Getting the registry
            Registry registry = LocateRegistry.getRegistry(null);

            // Looking up the registry for the remote object
            Hello stub = (Hello) registry.lookup("Hello");

            // Calling the remote method using the obtained object
            List<MedicationPlan> list = (List)stub.getMedicationPlan();

            all(list, delete);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
    public List<MedicationPlan> listCreater ()
    {
        try {
            // Getting the registry
            Registry registry = LocateRegistry.getRegistry(null);

            // Looking up the registry for the remote object
            Hello stub = (Hello) registry.lookup("Hello");

            // Calling the remote method using the obtained object
            List<MedicationPlan> list = (List) stub.getMedicationPlan();

            // System.out.println(list);

           return list;
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }


        return null;
    }

    public static void all(List <MedicationPlan> list, ArrayList delete) throws Exception {
        for (MedicationPlan med:list) {
            nr++;
        }
        GUI=new GUI(nr);



        GUI.prinln("\n \n  \n \n");
        for (MedicationPlan med:list) {

            System.out.println("Id: " + med.getId());
            GUI.prinln("        Id: " + med.getId());
            System.out.println("Name: " + med.getName());
            GUI.prinln("        Name: " + med.getName());
            System.out.println("Start date: " + med.getStartDate());
            GUI.prinln("        Start date: " + med.getStartDate());
            System.out.println("End date: " + med.getEndDate());
            GUI.prinln("        End date: " + med.getEndDate());
            GUI.prinln("\n");


        }

    }


    private static void logger(List<MedicationPlan> list,ArrayList delete) {


        GUI.prinln("\n\n\n");

        int found = 0;
        System.out.println(delete);
        for (MedicationPlan med : list) {


            for( int i =0 ; i<delete.size(); i++)
            {
                if ( delete.get(i).equals((Integer)med.getId())) {
                    found = 1;
                }
            }

            if(found == 0)
            {
                System.out.println("Id: " + med.getId());
                GUI.prinln("        Id: " + med.getId());
                System.out.println("Name: " + med.getName());
                GUI.prinln("        Name: " + med.getName());
                System.out.println("Start date: " + med.getStartDate());
                start = med.getStartDate();
                GUI.prinln("        Start date: " + med.getStartDate());
                System.out.println("End date: " + med.getEndDate());
                end = med.getEndDate();
                GUI.prinln("        End date: " + med.getEndDate());
                GUI.prinln(" \n");
            }

            found = 0;
        }
    }


    public static String getStart() {
        return start;
    }

    public static String getEnd() {
        return end;
    }
}