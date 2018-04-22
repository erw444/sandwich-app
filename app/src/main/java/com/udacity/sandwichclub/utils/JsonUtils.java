package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwichDetails = null;
        try {
            JSONObject sandwich = new JSONObject(json);
            JSONObject names = sandwich.getJSONObject("name");
            String mainName = names.getString("mainName");

           JSONArray alsoKnownAsArray = names.getJSONArray("alsoKnownAs");
           List<String> alsoKnownAsList = new ArrayList<String>();
           if(alsoKnownAsArray != null){
               for (int i=0; i<alsoKnownAsArray.length(); i++){
                   alsoKnownAsList.add(alsoKnownAsArray.getString(i));
               }
           }

            String placeOfOrigin = sandwich.getString("placeOfOrigin");
            String description = sandwich.getString("description");
            String image = sandwich.getString("image");

            JSONArray ingredientsArray = sandwich.getJSONArray("ingredients");
            List<String> ingredientsList = new ArrayList<String>();
            if(ingredientsArray != null){
                for (int i=0; i<ingredientsArray.length(); i++){
                    ingredientsList.add(ingredientsArray.getString(i));
                }
            }

            sandwichDetails = new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, image, ingredientsList);


        } catch(JSONException je){
            je.printStackTrace();
        }

        return sandwichDetails;

    }
}
