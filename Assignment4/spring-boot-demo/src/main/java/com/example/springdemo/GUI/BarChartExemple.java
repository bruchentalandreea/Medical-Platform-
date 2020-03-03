package com.example.springdemo.GUI;

import javax.swing.*;

import com.example.springdemo.server.Impl;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChartExemple extends JFrame {

    private static final long serialVersionUID = 1L;

    public BarChartExemple(String appTitle) {
        super(appTitle);

        // Create Dataset
        CategoryDataset dataset = createDataset();

        //Create chart
        JFreeChart chart=ChartFactory.createBarChart(
                "Patient history daily activities", //Chart Title
                "Year", // Category axis
                "Nr", // Value axis
                dataset,
                PlotOrientation.VERTICAL,
                true,true,false
        );

        ChartPanel panel=new ChartPanel(chart);
        setContentPane(panel);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Impl impl=new Impl();
        int sleep = impl.getList_sleep_size();

        // Population in 2005
        dataset.addValue(2, "Grooming", "2011");
        dataset.addValue(5, "Toileting", "2011");
        dataset.addValue(10, "Sleeping", "2011");
        dataset.addValue(8, "Lunch", "2011");
        dataset.addValue(3, "Breakfast", "2011");
        dataset.addValue(6, "Snack", "2011");
        // Population in 2010
       /* dataset.addValue(15, "USA", "2010");
        dataset.addValue(20, "India", "2010");
        dataset.addValue(25, "China", "2010");

        // Population in 2015
        dataset.addValue(20, "USA", "2015");
        dataset.addValue(25, "India", "2015");
        dataset.addValue(30, "China", "2015");

        */

        return dataset;
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(()->{
            BarChartExemple example=new BarChartExemple("Bar Chart Window");
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}