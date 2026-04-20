package com.realSplitter.realSplitter.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RealObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String activity;
    double amountSpent;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getActivity() {
        return activity;
    }
    public void setActivity(String activity) {
        this.activity = activity;
    }

    public double getAmountSpent() {
        return amountSpent;
    }
    public void setAmountSpent(double amountSpent) {
        this.amountSpent = amountSpent;
    }
}
