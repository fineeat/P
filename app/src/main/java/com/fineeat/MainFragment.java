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
public class MainFragment extends Fragment {

    String[] restaurantnames = {
            "1Royal Grill Room & Wine Cellar, Royal Cliff",
            "2The Glass House",
            "3Radius Restaurant, Cape Dara Resort",
            "4Casa Pascal",
            "5Café des Amis",
            "6Sugar Hut Restaurant, Sugar Hut Resort",
            "7Cadillac Café & Bar, Wave Hotel",
            "8Royal Grill Room & Wine Cellar, Royal Cliff",
            "9The Glass House",
            "10Radius Restaurant, Cape Dara Resort",
            "11Casa Pascal",
            "12Café des Amis",
            "13Sugar Hut Restaurant, Sugar Hut Resort",
            "14Cadillac Café & Bar, Wave Hotel"
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
        View fragmentMain = inflater.inflate(R.layout.fragment_main, container, false);
        initViews(fragmentMain);

        return fragmentMain;
    }

    public void initViews(View fragmain){
        RecyclerView recyclerView = (RecyclerView)fragmain.findViewById(R.id.cardRecyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(fragmain.getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Restaurant> restaurants = prepareData();
        RecycleViewAdapter adapter = new RecycleViewAdapter(fragmain.getContext(), restaurants);
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
