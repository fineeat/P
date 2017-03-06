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

import com.fineeat.Adapters.RecycleViewAdapterSearch;

import model.Company;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSearch extends Fragment {
    RecyclerView recyclerView;
    Button buttonCategory, buttonCuisine;
    View fragmentSearch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentSearch = inflater.inflate(R.layout.fragment_search, container, false);

        initRecyclerView();
        initButtons();

        return fragmentSearch;
    }

    public void initButtons(){
        buttonCategory = (Button)fragmentSearch.findViewById(R.id.buttonCategory);
        buttonCuisine = (Button)fragmentSearch.findViewById(R.id.buttonCuisine);

        View.OnClickListener onClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.buttonCategory:
                        populateCategoryDialog().show();
                        break;

                    case R.id.buttonCuisine:
                        populateCuisineDialog().show();
                        break;
                }
            }
        };

        buttonCategory.setOnClickListener(onClickListener);
        buttonCuisine.setOnClickListener(onClickListener);
    }

    public Dialog populateCategoryDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.category);

        ArrayAdapter<String> categoriesAdapter = new ArrayAdapter<>(fragmentSearch.getContext(), android.R.layout.select_dialog_item, Company.getSortedCategoryNames());
        builder.setAdapter(categoriesAdapter, new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        return builder.create();
    }

    public Dialog populateCuisineDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.cuisine);

        ArrayAdapter<String> categoriesAdapter = new ArrayAdapter<>(fragmentSearch.getContext(), android.R.layout.select_dialog_item, Company.getSortedCuisineNames());
        builder.setAdapter(categoriesAdapter, new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        return builder.create();
    }

    public void initRecyclerView(){
        recyclerView = (RecyclerView)fragmentSearch.findViewById(R.id.cardRecyclerViewSearch);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(fragmentSearch.getContext(), 1);
        recyclerView.setLayoutManager(layoutManager);

        RecycleViewAdapterSearch adapter = new RecycleViewAdapterSearch(fragmentSearch.getContext(), Company.restaurants);
        recyclerView.setAdapter(adapter);
    }

    public void refresh()
    {
        Log.d("Refresh","FragSearch");
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}
