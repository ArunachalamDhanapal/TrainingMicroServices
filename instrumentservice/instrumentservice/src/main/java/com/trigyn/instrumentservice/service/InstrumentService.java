package com.trigyn.instrumentservice.service;

import com.trigyn.instrumentservice.model.Instrument;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstrumentService {
    List<Instrument> instrumentList = new ArrayList<>();
    public Boolean addInstrument(Instrument instrument){
        instrumentList.add(instrument);
        return true;
    }
    public List<Instrument> getInstrumentList(){
        return instrumentList;
    }
}