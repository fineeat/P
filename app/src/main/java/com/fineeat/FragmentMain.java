package com.fineeat;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    View fragmentMain;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentMain = inflater.inflate(R.layout.fragment_main, container, false);
        initViews();

        return fragmentMain;
    }

    public void initViews(){
        recyclerView = (RecyclerView)fragmentMain.findViewById(R.id.cardRecyclerViewMain);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(fragmentMain.getContext(), 1);
        recyclerView.setLayoutManager(layoutManager);

        RecycleViewAdapterPromo adapter = new RecycleViewAdapterPromo(fragmentMain.getContext(), Company.promos);
        recyclerView.setAdapter(adapter);

        //Hide FAB on scroll
        ((ActivityMain)getActivity()).hideFABOnScroll(recyclerView);
    }

    public void refresh()
    {
        Log.d("Refresh","FragMain");
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}
