package com.fineeat;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


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
    int[] restaurantImages = {
            R.drawable.restaurant0,
            R.drawable.restaurant1,
            R.drawable.restaurant2,
            R.drawable.restaurant3,
            R.drawable.restaurant4,
            R.drawable.restaurant5,
            R.drawable.restaurant6,
            R.drawable.restaurant0,
            R.drawable.restaurant1,
            R.drawable.restaurant2,
            R.drawable.restaurant3,
            R.drawable.restaurant4,
            R.drawable.restaurant5,
            R.drawable.restaurant6
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentSearch = inflater.inflate(R.layout.fragment_search, container, false);
        initViews(fragmentSearch);

        return fragmentSearch;
    }

    public void initViews(View frag){
        RecyclerView recyclerView = (RecyclerView)frag.findViewById(R.id.cardRecyclerViewSearch);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(frag.getContext(), 1);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<FERestaurant> restaurants = prepareData();
        RecycleViewAdapterRestaurant adapter = new RecycleViewAdapterRestaurant(frag.getContext(), restaurants);
        recyclerView.setAdapter(adapter);
    }

    public ArrayList<FERestaurant> prepareData(){
        ArrayList<FERestaurant> restaurants = new ArrayList<>();

        for(int i=0; i<restaurantNames.length; i++){
            FERestaurant restaurant = new FERestaurant();

            restaurant.setRestaurantName(restaurantNames[i]);
            restaurant.setImageLink(restaurantImages[i]);
            restaurant.setCuisine(restaurantCuisines[i]);
            restaurant.setCategory(restaurantCategories[i]);

            restaurants.add(restaurant);
        }
        return restaurants;
    }

}
