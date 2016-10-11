package com.fineeat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Nicholascwz on 10/11/2016.
 */

public class CustomGrid extends BaseAdapter {
    private Context mContext;
    private final String[] restaurants;
    private final int[] images;

    public CustomGrid(Context c, String[] r, int[] imgs){
        mContext = c;
        restaurants = r;
        images = imgs;
    }

    @Override
    public int getCount() {
        return restaurants.length;
    }

    @Override
    public Object getItem(int i) {
        return restaurants[i];
    }

    @Override
    public long getItemId(int i) {
        return images[i];
    }

    @Override
    public View getView(int i, View convertview, ViewGroup parent) {
        View grid = convertview;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Convert view is used to avoid layout inflation from resource which costs you time and memory. You should use the old inflated view, but set new data.
        if (convertview == null) {
            grid = inflater.inflate(R.layout.grid_single, null);
        }

        TextView textView = (TextView) grid.findViewById(R.id.gridText);
        ImageView imageView = (ImageView)grid.findViewById(R.id.gridImage);

        //For future reference - images needs to be resize to fit its purpose, otherwise it will cause The application may be doing too much work on its main thread.
        textView.setText(restaurants[i]);
        imageView.setImageResource(images[i]);

        return grid;
    }
}
