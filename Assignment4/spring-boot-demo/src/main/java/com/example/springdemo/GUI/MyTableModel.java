package com.example.springdemo.GUI;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
    public final Object objectDataX[][];
    public final String colNames[];

    MyTableModel(Object [][] dataX, String colNamesX []){
        this.objectDataX = dataX;
        this.colNames = colNamesX;
    }

    public int getRowCount(){
        return objectDataX.length;
    }

    public int getColumnCount(){
        return colNames.length;
    }

    public Class getColumnClass(int column){
        return objectDataX[0][column].getClass();
    }

    public String getColumnName(int column){
        return colNames[column];
    }

    public Object getValueAt(int row, int column){
        return objectDataX[row][column];
    }

    public void setValueAt(Object value,int row, int column){
        if(value instanceof Boolean){
            objectDataX[row][column] = value;
        }
    }



}