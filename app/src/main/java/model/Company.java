package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by Nicholascwz on 11/15/2016.
 */

public class Company {
    public static ArrayList<FECategory> categories = new ArrayList<>();
    public static ArrayList<FECuisine> cuisines = new ArrayList<>();
    public static ArrayList<FEUser> users = new ArrayList<>();
    public static ArrayList<FERestaurant> restaurants = new ArrayList<>();
    public static ArrayList<FELocation> locations = new ArrayList<>();

    public static HashMap<String, FECategory> categoriesHM = new HashMap<>();
    public static HashMap<String, FECuisine> cuisinesHM = new HashMap<>();

    //Category Methods
    public static FECategory createCategory(int id, String name, int sort){
        FECategory category = categoriesHM.get(Integer.toString(id));

        if( category == null) {
            category = new FECategory(id, name, sort);
            categories.add(category);
            categoriesHM.put(Integer.toString(category.getId()), category);
        }

        category.setIsUsed(true);

        return category;
    }

    public static void resetCategoryIsUsed(){
        for (FECategory cat:categories) {
            cat.setIsUsed(false);
        }
    }

    public static void deleteUnusedCategory(){
        for (FECategory cat:categories) {
            if(!cat.getIsUsed()){
                categoriesHM.remove(cat.getId());
                categories.remove(cat);
                cat=null;
            }
        }
    }

    public static ArrayList<String> getSortedCategoryNames() {
        ArrayList<String> cats = new ArrayList<>();
        ArrayList<FECategory> fecats = Company.categories;

        Collections.sort(fecats, new Comparator<FECategory>() {
            @Override
            public int compare(FECategory cat1, FECategory cat2) {
                /*Return a negative value if object1 is smaller than object2
                  Return 0 (zero) if objec1 is equal to object2.
                  Return a positive value if object1 is larger than object2.*/
                return cat1.sortNum - cat2.sortNum;
            }
        });

        for(int i=0; i<fecats.size();i++){
            cats.add(fecats.get(i).getName());
        }

        return cats;
    }

    //Cuisine Methods
    public static FECuisine createCuisine(int id, String name, int sort){
        FECuisine cuisine = cuisinesHM.get(Integer.toString(id));

        if( cuisine == null) {
            cuisine = new FECuisine(id, name, sort);
            cuisines.add(cuisine);
            cuisinesHM.put(Integer.toString(cuisine.getId()), cuisine);
        }

        cuisine.setIsUsed(true);

        return cuisine;
    }

    public static void resetCuisineIsUsed(){
        for (FECuisine cui:cuisines) {
            cui.setIsUsed(false);
        }
    }

    public static void deleteUnusedCuisine(){
        for (FECuisine cui:cuisines) {
            if(!cui.getIsUsed()){
                cuisinesHM.remove(cui.getId());
                cuisines.remove(cui);
                cui=null;
            }
        }
    }

    public static ArrayList<String> getSortedCuisineNames() {
        ArrayList<String> cuis = new ArrayList<>();
        ArrayList<FECuisine> fecuis = Company.cuisines;

        Collections.sort(fecuis, new Comparator<FECuisine>() {
            @Override
            public int compare(FECuisine cui1, FECuisine cui2) {
                /*Return a negative value if object1 is smaller than object2
                  Return 0 (zero) if objec1 is equal to object2.
                  Return a positive value if object1 is larger than object2.*/
                return cui1.sortNum - cui2.sortNum;
            }
        });

        for(int i=0; i<fecuis.size();i++){
            cuis.add(fecuis.get(i).getName());
        }

        return cuis;
    }
}
