package data;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

import model.Company;
import model.FECategory;
import util.JSONMethod;
import util.Util;

/**
 * Created by Nicholascwz on 11/14/2016.
 */

public class CategoryParser {

    public static ArrayList<FECategory> createCategories(String data){
        ArrayList<FECategory> categories = new ArrayList<>();

        //Only proceed if there is data to process
        if(data != null && data.length() > 0) {
            try {
                JSONObject jsonObj = new JSONObject(data);
                JSONArray categoriesJSON = JSONMethod.getJSONArary(Util.category, jsonObj);

                for (int i = 0; i < categoriesJSON.length(); i++) {
                    JSONObject categoryJson = categoriesJSON.getJSONObject(i);

                    int id = JSONMethod.getJSONInt(Util.categoryID, categoryJson);
                    String name = JSONMethod.getJSONString(Util.categoryName, categoryJson);
                    int sortNum = JSONMethod.getJSONInt(Util.categorySortNum, categoryJson);

                    FECategory category = Company.createCategory(id, name, sortNum);
                    categories.add(category);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return categories;

    }
}
