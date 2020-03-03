package com.example.springdemo.GUI;

import com.example.springdemo.rmi.Client;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.example.springdemo.rmi.Client.nr;
import static java.lang.String.valueOf;


public class GUI extends JFrame {

    private JPanel mainPanel, dataPanel, secondPanel, logPanel;
    private JButton startButton, takenButton;
    private ButtonModel mod ;
    private JTextArea logBox, hideBox;
    public ArrayList<Integer> delete ;
    private JLabel label;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");

    public GUI(int nr) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(710,710);
        this.setLocation(300,100);
        this.setResizable(false);
        this.setVisible(true);

        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(700, 700));
        mainPanel.setBackground(Color.LIGHT_GRAY);


        dataPanel = new JPanel();
        dataPanel.setPreferredSize(new Dimension(680, 100));
        dataPanel.setBackground(Color.LIGHT_GRAY.darker());



        logPanel = new JPanel();
        logPanel.setPreferredSize(new Dimension(680, 600));

        logBox = new JTextArea();
        logBox.setPreferredSize(new Dimension(680,600 ));

        Font font1 = new Font("SansSerif", Font.BOLD, 20);

        JTextField output =new JTextField("Medication Plan");
        output.setSize(180,50);
        output.setLocation(200,30);
        output.setFont(font1);
        output.setHorizontalAlignment(JTextField.CENTER);
        logBox.add(output);

        delete = new ArrayList<Integer>(nr);
        int rowY=100;
        System.out.println(nr);
        for (int i = 1; i <= nr; i++){
            takenButton = new JButton("TAKE MED " + i);
            takenButton.setBackground(Color.YELLOW);
            int Finish=i;
            takenButton.setBounds(250, rowY, 150, 30);
            takenButton.addActionListener(e -> {
                try
                {
                    System.out.println("Medication  " + valueOf(Finish) + "  has been taken corectly");
                    delete.add((Integer)Finish);
                    logBox.selectAll();
                    logBox.replaceSelection("");
                    new Client(delete);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }

            });


            logBox.add(takenButton);
            rowY += 100;
        }



        logPanel.add(logBox);
        mainPanel.add(logPanel);
        this.add(mainPanel);


        label = new JLabel(" ");
        label.setBounds(0,0,50,50);
        mainPanel.add(label);
        setVisible(true);

        pack();

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                while (true) {
                    Date date = getDate();
                    String dateString = simpleDateFormat.format(date);
                    label.setText(dateString);
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t = new Thread(runnable);
        t.start();
    }

    private BufferedImage image;



    public void prinln(String s) {

        logBox.append(s + "\n");
        logBox.setCaretPosition(logBox.getText().length());

    }

    public static void main(String args[]) {
        new GUI(nr);
    }
    public static java.util.Date getDate() {
        java.util.Date date = new java.util.Date();
        return date;
    }


}