package com.example.springdemo.rmi;

import com.example.springdemo.entities.MedicationPlan;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

// Creating Remote interface for our application
public interface Hello extends Remote {
    public List<MedicationPlan> getMedicationPlan () throws Exception;
}