package com.fineeat;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.fineeat.Adapters.RecycleViewAdapterSearch;

import data.CategoryParser;
import data.HttpClient;
import model.Company;
import model.FECategory;
import model.FECuisine;
import model.FERestaurant;
import util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSearch extends Fragment {

    String[] restaurantNames = {
            "Royal Grill Room",
            "The Glass House",
            "Radius FERestaurant",
            "Casa Pascal",
            "Café des Amis",
            "Sugar Hut FERestaurant",
            "Cadillac Café & Bar",
            "Royal Grill Room",
            "The Glass House",
            "Radius FERestaurant",
            "Casa Pascal",
            "Café des Amis",
            "Sugar Hut FERestaurant",
            "Cadillac Café & Bar"
    };
    String[] restaurantImages = {
            "http://192.168.1.51:8888/Sample%20Restaurant%20Picture/restaurant0.jpg",
            "http://192.168.1.51:8888/Sample%20Restaurant%20Picture/restaurant1.jpg",
            "http://192.168.1.51:8888/Sample%20Restaurant%20Picture/restaurant2.jpg",
            "http://192.168.1.51:8888/Sample%20Restaurant%20Picture/restaurant3.jpg",
            "http://192.168.1.51:8888/Sample%20Restaurant%20Picture/restaurant4.jpg",
            "http://192.168.1.51:8888/Sample%20Restaurant%20Picture/restaurant5.jpg",
            "http://192.168.1.51:8888/Sample%20Restaurant%20Picture/restaurant6.jpg",
            "http://192.168.1.51:8888/Sample%20Restaurant%20Picture/restaurant0.jpg",
            "http://192.168.1.51:8888/Sample%20Restaurant%20Picture/restaurant1.jpg",
            "http://192.168.1.51:8888/Sample%20Restaurant%20Picture/restaurant2.jpg",
            "http://192.168.1.51:8888/Sample%20Restaurant%20Picture/restaurant3.jpg",
            "http://192.168.1.51:8888/Sample%20Restaurant%20Picture/restaurant4.jpg",
            "http://192.168.1.51:8888/Sample%20Restaurant%20Picture/restaurant5.jpg",
            "http://192.168.1.51:8888/Sample%20Restaurant%20Picture/restaurant6.jpg"
    };
    String[] restaurantLocations = {
            "Boatwright",
            "Bournemouth",
            "Blackpool",
            "Runswick",
            "Acton",
            "Martslock",
            "Barcombe",
            "Blackburn",
            "Runswick",
            "Acton",
            "Hewe",
            "Cromerth",
            "Longdale",
            "Baerney"
    };

    String[] restaurantCuisines = {
            "Korean",
            "Malaysian",
            "Mexican",
            "Western",
            "Japanese",
            "French",
            "Korean",
            "Malaysian",
            "Thai",
            "Western",
            "Western",
            "Japanese",
            "Chinese",
            "Spanish"
    };

    String[] restaurantCategories = {
            "Mexican",
            "Western",
            "Japanese",
            "French",
            "Korean",
            "Malaysian",
            "Thai",
            "Western",
            "Western",
            "Japanese",
            "Chinese",
            "Japanese",
            "Chinese",
            "Spanish"
    };

    RecyclerView recyclerView;
    Spinner spinnerCategory, spinnerCuisine;
    View fragmentSearch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Load data
        LoadingTask loadingTask = new LoadingTask();
        loadingTask.execute();

        // Inflate the layout for this fragment
        fragmentSearch = inflater.inflate(R.layout.fragment_search, container, false);

        return fragmentSearch;
    }

    public void initRecyclerView(View frag){
        recyclerView = (RecyclerView)frag.findViewById(R.id.cardRecyclerViewSearch);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(frag.getContext(), 1);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<FERestaurant> restaurants = prepareData();
        RecycleViewAdapterSearch adapter = new RecycleViewAdapterSearch(frag.getContext(), restaurants);
        recyclerView.setAdapter(adapter);
    }

    public ArrayList<FERestaurant> prepareData(){
        ArrayList<FERestaurant> restaurants = new ArrayList<>();

        for(int i=0; i<restaurantNames.length; i++){
            FERestaurant restaurant = new FERestaurant();

            restaurant.setRestaurantName(restaurantNames[i]);
            restaurant.setImagePath(restaurantImages[i]);
            restaurant.setCuisine(restaurantCuisines[i]);
            restaurant.setCategory(restaurantCategories[i]);
            restaurant.setLocationName(restaurantLocations[i]);

            restaurants.add(restaurant);
        }
        return restaurants;
    }

    private class LoadingTask extends AsyncTask<String, Void, ArrayList<FECategory>> {
        @Override
        protected ArrayList<FECategory> doInBackground(String... strings) {
            String jsonCategories = HttpClient.getData(Util.CategoryURLExt);
            ArrayList<FECategory> categories = CategoryParser.createCategories(jsonCategories);
            Log.v("Categories created: ", "" + Company.categories.size());
            return categories;
        }

        @Override
        protected void onPostExecute(ArrayList<FECategory> feCategories) {
            super.onPostExecute(feCategories);

            //Populate the spinner after data is completed
            initRecyclerView(fragmentSearch);
            initSpinners(fragmentSearch);
        }
    }

    public void initSpinners(View frag){
        spinnerCategory = (Spinner)frag.findViewById(R.id.spinnerCategory);
        spinnerCuisine = (Spinner)frag.findViewById(R.id.spinnerCuisine);

        populateSpinnerCategory(frag);
        //populateSpinnerCuisine();
    }

    public void populateSpinnerCategory(View frag)
    {
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

        for(int i=0; i< fecats.size();i++){
            cats.add(fecats.get(i).getName());
        }

        ArrayAdapter<String> categoriesAdapter = new ArrayAdapter<>(frag.getContext(), android.R.layout.simple_spinner_item, cats);
        categoriesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(categoriesAdapter);
    }

    public void populateSpinnerCuisine()
    {
        ArrayList<String> cats = new ArrayList<>();
        ArrayList<FECuisine> fecui = Company.cuisines;
        Collections.sort(fecui, new Comparator<FECuisine>() {

            @Override
            public int compare(FECuisine cui1, FECuisine cui2) {
                /*Return a negative value if object1 is smaller than object2
                  Return 0 (zero) if objec1 is equal to object2.
                  Return a positive value if object1 is larger than object2.*/
                return cui1.sortNum - cui2.sortNum;
            }
        });

        for(int i=0; i< fecui.size();i++){
            cats.add(fecui.get(i).getName());
        }
    }

}
