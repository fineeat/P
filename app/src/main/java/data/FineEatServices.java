package data;

import java.util.List;

import model.FECategory;
import model.FECuisine;
import model.FERestaurant;
import model.FERestaurantPromo;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import util.Util;

/**
 * Created by Nicholascwz on 11/24/2016.
 */

public interface FineEatServices {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Util.BaseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("categories.php")
    Call<List<FECategory>> loadCategories();

    @GET("cuisines.php")
    Call<List<FECuisine>> loadCuisines();

    @GET("restaurants.php")
    Call<List<FERestaurant>> loadRestaurant();

    @GET("promos.php")
    Call<List<FERestaurantPromo>> loadPromo();
}