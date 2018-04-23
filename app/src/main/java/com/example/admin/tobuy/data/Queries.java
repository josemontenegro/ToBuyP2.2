package com.example.admin.tobuy.data;

import com.example.admin.tobuy.models.ToBuy;

import java.util.ArrayList;
import java.util.List;

public class Queries {

    public List<ToBuy> toBuys(){
        List<ToBuy> toBuys = new ArrayList<>();
        List<ToBuy> toBuyList = ToBuy.find(ToBuy.class,"done = 0");
        if (toBuyList != null && toBuyList.size() > 0){
            toBuys.addAll(toBuyList);
        }
        return toBuys;
    }
}
