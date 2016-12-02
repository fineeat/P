package com.fineeat;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fineeat.Adapters.RecycleViewAdapterPromo;

import model.Company;



/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMain extends Fragment {
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentMain = inflater.inflate(R.layout.fragment_main, container, false);
        initViews(fragmentMain);

        return fragmentMain;
    }

    @Override
    public void onStart() {
        super.onStart();
        refresh();
    }

    public void initViews(View fragmain){
        recyclerView = (RecyclerView)fragmain.findViewById(R.id.cardRecyclerViewMain);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(fragmain.getContext(), 1);
        recyclerView.setLayoutManager(layoutManager);

        RecycleViewAdapterPromo adapter = new RecycleViewAdapterPromo(fragmain.getContext(), Company.promos);
        recyclerView.setAdapter(adapter);

    }

    public void refresh()
    {
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}
