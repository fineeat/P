package com.fineeat;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    GridView gridView;
    String[] restaurants = {
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
    int[] images = {
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
    View fragmentMain;
    CustomGrid adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentMain= inflater.inflate(R.layout.fragment_main, container, false);
        adapter = new CustomGrid(this.getActivity(), restaurants, images);

        gridView = (GridView)fragmentMain.findViewById(R.id.gridView);
        gridView.setAdapter(adapter);
        return fragmentMain;
    }

}
