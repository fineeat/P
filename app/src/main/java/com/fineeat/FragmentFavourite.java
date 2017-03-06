package com.fineeat;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.fineeat.Adapters.RecycleViewAdapterFavourite;
import com.fineeat.Adapters.RecycleViewAdapterSearch;

import model.Company;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFavourite extends Fragment {

    RecyclerView recyclerView;
    View fragmentFavourite;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentFavourite = inflater.inflate(R.layout.fragment_favourite, container, false);

        initRecyclerView();

        return fragmentFavourite;
    }

    public void initRecyclerView(){
        recyclerView = (RecyclerView)fragmentFavourite.findViewById(R.id.cardRecyclerViewFav);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(fragmentFavourite.getContext(), 1);
        recyclerView.setLayoutManager(layoutManager);

        RecycleViewAdapterFavourite adapter = new RecycleViewAdapterFavourite(fragmentFavourite.getContext(), Company.loggedUser.getFavouriteRestaurants());
        recyclerView.setAdapter(adapter);
    }

    public void refresh()
    {
        Log.d("Refresh","FragFav");
        recyclerView.getAdapter().notifyDataSetChanged();
    }

}
