package com.example.jonmid.tareasasincronas.Parser;

import com.example.jonmid.tareasasincronas.Models.Country;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonmid on 17/04/18.
 */

public class JsonCountry {

    public static List<Country> getData(String content) throws JSONException {

        JSONObject jsonData = new JSONObject(content);
        JSONObject itemData = jsonData.getJSONObject("RestResponse");
        JSONArray jsonArray = itemData.getJSONArray("result");

        List<Country> countryList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++){

            JSONObject item = jsonArray.getJSONObject(i);

            Country country = new Country();
            country.setName(item.getString("name"));
            country.setAlpha2_code(item.getString("alpha2_code"));
            country.setAlpha3_code(item.getString("alpha3_code"));

            countryList.add(country);
        }

        return countryList;
    }

}
