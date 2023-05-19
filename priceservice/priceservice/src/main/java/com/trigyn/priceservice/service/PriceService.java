package com.trigyn.priceservice.service;

import com.trigyn.priceservice.model.Price;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceService {
    List<Price> priceList = new ArrayList<>();

    public Boolean addPriceList(Price price){
        priceList.add(price);
        return true;
    }

    public List<Price> getPriceList(){
        return priceList;
    }
}