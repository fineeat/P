package model;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by Nicholascwz on 11/15/2016.
 */

public class Company {
    public static FEUser user;

    public static ArrayList<FECategory> categories = new ArrayList<>();
    public static ArrayList<FECuisine> cuisines = new ArrayList<>();
    public static ArrayList<FERestaurant> restaurants = new ArrayList<>();
    public static ArrayList<FERestaurantPromo> promos = new ArrayList<>();

    public static HashMap<Integer, FECategory> categoriesHM = new HashMap<>();
    public static HashMap<Integer, FECuisine> cuisinesHM = new HashMap<>();
    public static HashMap<Integer, FERestaurant> restaurantsHM = new HashMap<>();
    public static HashMap<Integer, FERestaurantPromo> promosHM = new HashMap<>();

    // Sorting methods
    public static ArrayList<String> getSortedCategoryNames() {
        ArrayList<String> cats = new ArrayList<>();
        ArrayList<FECategory> fecats = Company.categories;

        Collections.sort(fecats, new Comparator<FECategory>() {
            @Override
            public int compare(FECategory cat1, FECategory cat2) {
                return cat1.getSortNum() - cat2.getSortNum();
            }
        });

        for(int i=0; i<fecats.size();i++){
            cats.add(fecats.get(i).getName());
        }

        return cats;
    }
    public static ArrayList<String> getSortedCuisineNames() {
        ArrayList<String> cuis = new ArrayList<>();
        ArrayList<FECuisine> fecuis = Company.cuisines;

        Collections.sort(fecuis, new Comparator<FECuisine>() {
            @Override
            public int compare(FECuisine cui1, FECuisine cui2) {
                return cui1.getSortNum() - cui2.getSortNum();
            }
        });

        for(int i=0; i<fecuis.size();i++){
            cuis.add(fecuis.get(i).getName());
        }

        return cuis;
    }

    //Category Methods
    public static void addCategory(FECategory cat){
        int id = cat.getId();
        FECategory category = categoriesHM.get(id);

        if( category == null) {
            categories.add(cat);
            categoriesHM.put(id, cat);
            category = cat;
        }else{
            category.setName(cat.getName());
            category.setSortNum(cat.getSortNum());
        }

        category.setIsUsed(true);
    }

    public static void resetCategoryIsUsed(){
        for (FECategory cat:categories) {
            cat.setIsUsed(false);
        }
    }

    public static void deleteUnusedCategory(){
        ArrayList<FECategory> expiredCategories = new ArrayList<>();
        for(FECategory cat:categories) {
            if(!cat.getIsUsed()){
                expiredCategories.add(cat);
            }
        }

        for(FECategory exp:expiredCategories){
            categories.remove(exp);
            categoriesHM.remove(exp.getId());
            exp=null;
        }
    }

    //Cuisine Methods
    public static void addCuisine(FECuisine cui){
        int id = cui.getId();
        FECuisine cuisine = cuisinesHM.get(id);

        if( cuisine == null) {
            cuisines.add(cui);
            cuisinesHM.put(id, cui);
            cuisine = cui;
        }else{
            cuisine.setName(cui.getName());
            cuisine.setSortNum(cui.getSortNum());
        }

        cuisine.setIsUsed(true);
    }

    public static void resetCuisineIsUsed(){
        for (FECuisine cui:cuisines) {
            cui.setIsUsed(false);
        }
    }

    public static void deleteUnusedCuisine(){
        ArrayList<FECuisine> expiredCuisines = new ArrayList<>();
        for(FECuisine cui:cuisines) {
            if(!cui.getIsUsed()){
                expiredCuisines.add(cui);
            }
        }

        for(FECuisine exp:expiredCuisines){
            categories.remove(exp);
            categoriesHM.remove(exp.getId());
            exp=null;
        }
    }

    //Restaurant Methods
    public static void addRestaurant(FERestaurant res){
        int id = res.getRestaurantID();
        FERestaurant restaurant = restaurantsHM.get(id);

        if( restaurant == null) {
            restaurants.add(res);
            restaurantsHM.put(id, res);
            restaurant = res;
        }else{
            restaurant.update(res);
        }

        restaurant.updateNMObjects();
    }

    //Promo Methods
    public static void addPromo(FERestaurantPromo pro){
        int id = pro.getRestaurantPromoID();
        FERestaurantPromo promo = promosHM.get(id);

        if( promo == null) {
            promos.add(pro);
            promosHM.put(id, pro);
            promo = pro;
        }else{
            promo.update(pro);
        }

        promo.updateRestaurantLink();
    }
}
