package com.trigyn.instrumentservice.controller;

import com.trigyn.instrumentservice.model.Instrument;
import com.trigyn.instrumentservice.service.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InstrumentController {
    @Autowired
    InstrumentService instrumentService;
    @GetMapping("/instrument")
    public List<Instrument> getInstrumentList(){
        return instrumentService.getInstrumentList();
    }

    @PostMapping("/instrument")
    public Boolean addInstrument(@RequestBody Instrument instrument){
        instrumentService.addInstrument(instrument);
        return true;
    }
}