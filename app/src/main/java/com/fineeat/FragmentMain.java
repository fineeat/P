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
public class FragmentMain extends Fragment {

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
    int[] restaurantPromoImages = {
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

    String[] restaurantPromoMessage = {
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam ut tortor et ipsum laoreet aliquam. Nulla non nunc in lectus dignissim aliquet. Duis ut purus ipsum. Sed vitae sapien non velit semper tincidunt. In tempus mattis mauris, sit amet molestie diam placerat ac. Praesent viverra vel augue eu dictum. Fusce in arcu vel orci fringilla pretium id at urna. Quisque a diam sollicitudin, dignissim lacus et, volutpat magna.",
            "Vivamus tincidunt vestibulum metus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Curabitur tristique risus finibus, viverra libero et, dignissim est. Mauris ut eros ac sapien cursus euismod. Ut ut neque sapien. Maecenas nec ultricies odio. Etiam tristique mattis nunc, eu rhoncus diam interdum a. Curabitur sed ligula mi. Nulla tempus ante quis ullamcorper luctus.",
            "Integer ante nisl, ullamcorper sit amet nibh non, lacinia consequat velit. Nunc ex diam, condimentum in tristique in, porta a nulla. Nullam ultricies urna id rutrum sagittis. Aliquam ut efficitur leo. Proin ac euismod lacus, nec malesuada massa. Suspendisse potenti. Cras molestie risus ut lacus euismod sollicitudin.",
            "Pellentesque faucibus velit a interdum mattis. Curabitur et tincidunt ipsum. Morbi pretium eget tellus a auctor. Maecenas quis sem in risus molestie ornare ut quis purus.",
            "Nunc ex diam, condimentum in tristique in, porta a nulla. ",
            "Sed eu sapien mollis, tincidunt risus sit amet, dictum leo.",
            "Sed eu sapien mollis, tincidunt risus sit amet, dictum leo.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam ut tortor et ipsum laoreet aliquam. Nulla non nunc in lectus dignissim aliquet. Duis ut purus ipsum. Sed vitae sapien non velit semper tincidunt. In tempus mattis mauris, sit amet molestie diam placerat ac. Praesent viverra vel augue eu dictum. Fusce in arcu vel orci fringilla pretium id at urna. Quisque a diam sollicitudin, dignissim lacus et, volutpat magna.",
            "Pellentesque faucibus velit a interdum mattis. Curabitur et tincidunt ipsum. Morbi pretium eget tellus a auctor. Maecenas quis sem in risus molestie ornare ut quis purus.",
            "Nunc ex diam, condimentum in tristique in, porta a nulla. ",
            "Sed eu sapien mollis, tincidunt risus sit amet, dictum leo.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam ut tortor et ipsum laoreet aliquam. Nulla non nunc in lectus dignissim aliquet. Duis ut purus ipsum. Sed vitae sapien non velit semper tincidunt. In tempus mattis mauris, sit amet molestie diam placerat ac. Praesent viverra vel augue eu dictum. Fusce in arcu vel orci fringilla pretium id at urna. Quisque a diam sollicitudin, dignissim lacus et, volutpat magna.",
            "Vivamus tincidunt vestibulum metus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Curabitur tristique risus finibus, viverra libero et, dignissim est. Mauris ut eros ac sapien cursus euismod. Ut ut neque sapien. Maecenas nec ultricies odio. Etiam tristique mattis nunc, eu rhoncus diam interdum a. Curabitur sed ligula mi. Nulla tempus ante quis ullamcorper luctus.",
            "Integer ante nisl, ullamcorper sit amet nibh non, lacinia consequat velit. Nunc ex diam, condimentum in tristique in, porta a nulla. Nullam ultricies urna id rutrum sagittis. Aliquam ut efficitur leo. Proin ac euismod lacus, nec malesuada massa. Suspendisse potenti. Cras molestie risus ut lacus euismod sollicitudin."
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
        RecyclerView recyclerView = (RecyclerView)fragmain.findViewById(R.id.cardRecyclerViewMain);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(fragmain.getContext(), 1);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<FERestaurantPromo> restaurants = prepareData();
        RecycleViewAdapterPromo adapter = new RecycleViewAdapterPromo(fragmain.getContext(), restaurants);
        recyclerView.setAdapter(adapter);
    }

    public ArrayList<FERestaurantPromo> prepareData(){
        ArrayList<FERestaurantPromo> restaurants = new ArrayList<>();

        for(int i=0; i<restaurantNames.length; i++){
            FERestaurantPromo restaurant = new FERestaurantPromo();

            restaurant.setRestaurantName(restaurantNames[i]);
            restaurant.setImagePromoLink(restaurantPromoImages[i]);
            restaurant.setLocationName(restaurantLocations[i]);
            restaurant.setCuisine(restaurantCuisines[i]);
            restaurant.setCategory(restaurantCategories[i]);
            restaurant.setPromoMessage(restaurantPromoMessage[i]);

            restaurants.add(restaurant);
        }
        return restaurants;
    }

}
