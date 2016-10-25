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

    String[] restaurantnames = {
            "Royal Grill Room",
            "The Glass House",
            "Radius Restaurant",
            "Casa Pascal",
            "Café des Amis",
            "Sugar Hut Restaurant",
            "Cadillac Café & Bar",
            "Royal Grill Room",
            "The Glass House",
            "Radius Restaurant",
            "Casa Pascal",
            "Café des Amis",
            "Sugar Hut Restaurant",
            "Cadillac Café & Bar"
    };
    int[] restaurantimages = {
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
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(frag.getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Restaurant> restaurants = prepareData();
        RecycleViewAdapter adapter = new RecycleViewAdapter(frag.getContext(), restaurants);
        recyclerView.setAdapter(adapter);
    }

    public ArrayList<Restaurant> prepareData(){
        ArrayList<Restaurant> restaurants = new ArrayList<>();

        for(int i=0; i<restaurantnames.length; i++){
            Restaurant restaurant = new Restaurant();

            restaurant.setRestaurantName(restaurantnames[i]);
            restaurant.setImageLink(restaurantimages[i]);

            restaurants.add(restaurant);
        }
        return restaurants;
    }

}
