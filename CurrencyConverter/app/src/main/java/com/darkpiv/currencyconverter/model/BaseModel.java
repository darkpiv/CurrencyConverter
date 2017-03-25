package com.darkpiv.currencyconverter.model;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by darkpiv on 19/12/2016.
 */

public class BaseModel {

    protected  <M extends BaseModel> M getObjectFromJson(JSONObject jsonObject) {
        return (M) new Gson().fromJson(jsonObject.toString(),getClass());
    }

    protected <M extends BaseModel> ArrayList<M> getListObjectFromJson(JSONArray jsonArray) {
        ArrayList<M> listObject = new ArrayList<>();
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                M baseModel = getObjectFromJson(jsonArray.getJSONObject(i));
                listObject.add(baseModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listObject;
    }
}
