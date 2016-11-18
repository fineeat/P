package com.fineeat;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

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
    Button buttonCategory, buttonCuisine;
    View fragmentSearch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentSearch = inflater.inflate(R.layout.fragment_search, container, false);

        initRecyclerView(fragmentSearch);
        initButtons(fragmentSearch);

        return fragmentSearch;
    }

    public void initButtons(final View frag){
        buttonCategory = (Button)frag.findViewById(R.id.buttonCategory);
        buttonCuisine = (Button)frag.findViewById(R.id.buttonCuisine);

        View.OnClickListener onClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.buttonCategory:
                        Log.v("Entered onClick", "Cat");
                        Toast.makeText(frag.getContext(), R.string.category, Toast.LENGTH_SHORT).show();
                        populateCategoryDialog(frag).show();
                        break;

                    case R.id.buttonCuisine:
                        Log.v("Entered onClick", "Cui");
                        Toast.makeText(frag.getContext(), R.string.cuisine, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

        buttonCategory.setOnClickListener(onClickListener);
        buttonCuisine.setOnClickListener(onClickListener);
    }

    public Dialog populateCategoryDialog(View frag){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.category);

        ArrayAdapter<String> categoriesAdapter = new ArrayAdapter<>(frag.getContext(), android.R.layout.select_dialog_item, Company.getSortedCategoryNames());
        builder.setAdapter(categoriesAdapter, new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        return builder.create();
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
}
