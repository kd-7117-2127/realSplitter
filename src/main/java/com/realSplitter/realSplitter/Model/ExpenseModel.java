package com.realSplitter.realSplitter.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ExpenseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
