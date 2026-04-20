package com.realSplitter.realSplitter.Controller;

import com.realSplitter.realSplitter.Model.RealObject;
import com.realSplitter.realSplitter.Model.SettlementObject;
import com.realSplitter.realSplitter.Service.RealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class RealController {
    @Autowired
    private RealService service;
    @PostMapping("/createTable")
    public void createTable(){

    }
    @PostMapping("/saveRecord")
    public void saveRecord(@RequestBody RealObject record){
        service.saveRecord(record);
    }

    @GetMapping("/allRecords")
    public List<RealObject> allRecords(){
        return service.allRecords();
    }

    @GetMapping("/showSettlements")
    public List<SettlementObject> showSettlements(){
        return service.settlementRecords();
    }
}
