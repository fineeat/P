package data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import model.Company;
import model.FECategory;
import model.FECuisine;
import util.JSONMethod;
import util.Util;

/**
 * Created by Nicholascwz on 11/14/2016.
 */

public class CuisineParser {

    public static ArrayList<FECuisine> createCuisines(String data){
        ArrayList<FECuisine> cuisines = new ArrayList<>();

        //Only proceed if there is data to process
        if(data != null && data.length() > 0) {

            //Reset IsUsed for Cuisine
            Company.resetCuisineIsUsed();

            try {
                JSONObject jsonObj = new JSONObject(data);
                JSONArray categoriesJSON = JSONMethod.getJSONArary(Util.cuisine, jsonObj);

                for (int i = 0; i < categoriesJSON.length(); i++) {
                    JSONObject categoryJson = categoriesJSON.getJSONObject(i);

                    int id = JSONMethod.getJSONInt(Util.cuisineID, categoryJson);
                    String name = JSONMethod.getJSONString(Util.cuisineName, categoryJson);
                    int sortNum = JSONMethod.getJSONInt(Util.cuisineSortNum, categoryJson);

                    FECuisine cuisine = Company.createCuisine(id, name, sortNum);
                    cuisines.add(cuisine);
                }

                //Delete expired cuisines
                Company.deleteUnusedCuisine();

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return cuisines;

    }
}
