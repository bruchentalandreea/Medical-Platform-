package com.example.springdemo.GUI;



import com.example.springdemo.server.Impl;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


public class GUI extends JFrame {

    //Impl impl = new Impl();

    public GUI() {
        JFrame f= new JFrame("TextField Example");

        f.getContentPane().setBackground(Color.pink);
        JTextField t1,t2,t3 ;
        JLabel select  =new JLabel("Select Patient Id");
        select.setBounds(50,50,100,30);

        JButton b=new JButton("Display");
        b.setBounds(50,150,130,30);

        JLabel data = new JLabel();
        data.setBounds(50, 250, 1000,200);



        JTextArea logBox= new JTextArea();
        JTextArea logBoxR= new JTextArea();

        JScrollPane scroll= new JScrollPane(logBox);
        scroll.setBounds(50,250,320,600);

        JScrollPane scrollR= new JScrollPane(logBoxR);
        scrollR.setBounds(600,250,320,600);

        JLabel activity=new JLabel("Select Activity");
        activity.setBounds(250,50,100,30);

        JLabel recomandation=new JLabel("Send a Recomandation");
        recomandation.setBounds(450,50,150,30);

        JButton b2 =new JButton("Display Chart");
        b2.setBounds(250,150,130,30);


        JButton b3 =new JButton("Send");
        b3.setBounds(450,150,130,30);

        t1=new JTextField("Enter id");
        t1.setBounds(50,100,130,30);

        t2=new JTextField("Enter activity");
        t2.setBounds(250,100,130,30);

        t3=new JTextField("Enter recomandation");
        t3.setBounds(450,100,130,30);

        JLabel patient= new JLabel();
        patient.setBounds(50,150,100,100);




        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String text=t2.getText();

                String text1=t1.getText();
                patient.setText("Patient id :" + text1);



                Impl impl =new Impl(text);
                for(int i=0;i<impl.getList_start().size();i++)
                {
                    logBox.append("Activity :" + text + "\nId: " + impl.getList_id().get(i) + "\nStart Time :" + impl.getList_start().get(i) + "\nEnd Time :" + impl.getList_end().get(i) + "\n\n");
                    logBox.setCaretPosition(logBox.getText().length());
                }


               // JTable dataTable = new JTable(getRandomTableModel());
               // dataTable.setBounds(50,250,2000,2000);

               // f.add(dataTable);

            }
        });



        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                String text=t2.getText();
               Impl impl =new Impl(text);
                System.out.println("LISTA NOUA" + impl.getList_id_sleep());

                int sleep=0;
                for(int i=0;i<impl.getList_id_sleep().size();i++)
                {
                    sleep ++;

                }
                //t2.setText(String.valueOf(sleep));

                //t2.setText(String.valueOf(impl.getList_id_sleep().size()));

                /*

                JFrame frame=new JFrame("Bar Chart");

                BarChart chart = new BarChart();
                chart.addBar(Color.red, sleep);
                chart.addBar(Color.green, 8);
                chart.addBar(Color.blue, 54);
                chart.addBar(Color.black, 23);

                frame.getContentPane().add(chart);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(true);
                frame.setSize(500,500);
                frame.setVisible(true);
                */



                        BarChartExemple example=new BarChartExemple("Bar Chart Window");
                        example.getContentPane().setBackground(Color.pink);
                        example.setSize(800, 400);
                        example.setLocationRelativeTo(null);
                        example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                        example.setVisible(true);


            }
        });


        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String text = t3.getText();


                Impl impl = new Impl(text);
                //ArrayList<String> list_reco = new ArrayList<String>();
                //list_reco.add(text);
               // for (int i = 0; i < list_reco.size(); i++){
                    logBoxR.append(  text + "\n\n");
                    logBoxR.setCaretPosition(logBoxR.getText().length());
                 //}


                // JTable dataTable = new JTable(getRandomTableModel());
                // dataTable.setBounds(50,250,2000,2000);

                // f.add(dataTable);

            }
        });
        f.add(b);
        f.add(b2);
        f.add(b3);
        f.add(scroll);
        f.add(scrollR);
        f.add(patient);
        //f.add(logBox);
        f.add(data);




        f.add(select);
        f.add(t1);
        f.add(activity);
        f.add(t2);
       f.add(recomandation);
        f.add(t3);
        f.setSize(1000,1000);
        f.setLayout(null);
        f.setVisible(true);
    }



    /*public TableModel getRandomTableModel() {
        Object data[][] = new Object[1][3];
        for(int i = 0 ; i < impl.getList_id().size() ; ++i){
            int x = (int)(Math.random()*10);
            data[i][0] = impl.getList_id();
            data[i][1] = impl.getList_start();
            data[i][2] = impl.getList_end();
        }
        String colNames[] = new String[]{"Id","Start Time","End Time"};

        return new MyTableModel(data,colNames);
    }*/

    public static void main(String args[]) throws SQLException, ParseException {
        GUI gui = new GUI();
    }
    public static java.util.Date getDate() {
        java.util.Date date = new java.util.Date();
        return date;
    }


}