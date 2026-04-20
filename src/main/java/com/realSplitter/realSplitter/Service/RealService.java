package com.realSplitter.realSplitter.Service;

import com.realSplitter.realSplitter.Model.RealObject;
import com.realSplitter.realSplitter.Model.SettlementObject;
import com.realSplitter.realSplitter.RealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RealService {
    @Autowired
    private RealRepository REPO;

    public List<RealObject> allRecords(){
        return REPO.findAll();
    }
    public void saveRecord(RealObject record) {
        REPO.save(record);
    }
    public Map<String,Double> payRecords(){
        List<RealObject> records = REPO.findAll();
        Map<String,Double> map = new HashMap<>();
        for(RealObject record : records){
            map.put(record.getName(),record.getAmountSpent());
        }
        return map;
    }
    public List<SettlementObject> settlementRecords(){
        Map<String,Double> map = payRecords();
        double total = 0;
        double persons = map.size();
        for(Map.Entry<String,Double> entry:map.entrySet()){
            total+=entry.getValue();
        }
        double perHead = total/persons;
        ArrayList<ArrayList<String>> liz = new  ArrayList<>();
        for(Map.Entry<String,Double> entry:map.entrySet()){
            ArrayList<String> l = new ArrayList<>();
            l.add(entry.getKey());
            l.add(String.valueOf(entry.getValue()-perHead));
            liz.add(l);
        }
        Collections.sort(liz,(a, b)->{
            double val1 = Double.parseDouble(a.get(1));
            double val2 = Double.parseDouble(b.get(1));
            return Double.compare(val1,val2);
        });
        int l = 0;
        int r = liz.size()-1;
        List<SettlementObject> recordList = new ArrayList<>();
        while(l<=r) {
            double val1 = Double.parseDouble(liz.get(l).get(1));
            double val2 = Double.parseDouble(liz.get(r).get(1));
            if (Math.abs(val1) > Math.abs(val2)) {
                double amount = Math.abs(val2);
                val1 = val1 + val2;
                val2 = 0;
                liz.get(l).set(1, String.valueOf(val1));
                liz.get(r).set(1, String.valueOf(val2));
                SettlementObject set = new SettlementObject();
                set.setFrom(liz.get(l).get(0));
                set.setTo(liz.get(r).get(0));
                set.setAmount(Math.abs(amount));
                recordList.add(set);
                r--;
            } else {
                double amount = Math.abs(val1);
                val2 = val2 + val1;
                val1 = 0;
                liz.get(l).set(1, String.valueOf(val1));
                liz.get(r).set(1, String.valueOf(val2));
                SettlementObject set = new SettlementObject();
                set.setFrom(liz.get(l).get(0));
                set.setTo(liz.get(r).get(0));
                set.setAmount(amount);
                recordList.add(set);
                l++;
            }
        }
        return recordList;
    }
}
