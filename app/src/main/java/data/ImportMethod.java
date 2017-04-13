package data;

import android.util.Log;

import java.util.List;

import model.Company;
import model.FECategory;
import model.FECuisine;
import model.FERestaurant;
import model.FERestaurantPromo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nicholascwz on 11/29/2016.
 */

public class ImportMethod {
    public static void ImportCategories()
    {
        Log.v("ImportCategories", "--------------------");
        // prepare call in Retrofit 2.0
        FineEatServices categoryService = FineEatServices.retrofit.create(FineEatServices.class);

        Call<List<FECategory>> call = categoryService.loadCategories();
        call.enqueue(new Callback<List<FECategory>>() { // synchronous call would be with execute()
            @Override
            public void onResponse(Call<List<FECategory>> call, Response<List<FECategory>> response) {
                Log.v("OnResponse ImportCat", response.message());

                Company.resetCategoryIsUsed();

                if( response.body() != null){
                    List<FECategory> categories = response.body();

                    for(FECategory cat:categories){
                        Log.v("Imported cat", cat.getId() + " - " + cat.getName());
                        Company.addCategory(cat);
                    }
                }

                Company.deleteUnusedCategory();

                call.cancel(); // to cancel a running request call.cancel();
                Log.v("ImportCategories", "Finish importing");
            }

            @Override
            public void onFailure(Call<List<FECategory>> call, Throwable t) {
                Log.v("onFailure ImportCat", t.getMessage());
            }
        });
    }

    public static void ImportCuisines()
    {
        Log.v("ImportCuisines", "--------------------");
        // prepare call in Retrofit 2.0
        FineEatServices categoryService = FineEatServices.retrofit.create(FineEatServices.class);

        Call<List<FECuisine>> call = categoryService.loadCuisines();
        call.enqueue(new Callback<List<FECuisine>>() { // synchronous call would be with execute()
            @Override
            public void onResponse(Call<List<FECuisine>> call, Response<List<FECuisine>> response) {
                Log.v("OnResponse ImportCui", response.message());

                Company.resetCuisineIsUsed();

                if( response.body() != null){
                    List<FECuisine> cuisines = response.body();

                    for(FECuisine cui:cuisines){
                        Log.v("Imported cui", cui.getId() + " - " + cui.getName());
                        Company.addCuisine(cui);
                    }
                }

                Company.deleteUnusedCuisine();

                call.cancel(); // to cancel a running request call.cancel();
                Log.v("ImportCuisines", "Finish importing");
            }

            @Override
            public void onFailure(Call<List<FECuisine>> call, Throwable t) {
                Log.v("onFailure ImportCui", t.getMessage());
            }
        });
    }

    public static void ImportRestaurant()
    {
        Log.v("ImportRestaurant", "--------------------");
        // prepare call in Retrofit 2.0
        FineEatServices categoryService = FineEatServices.retrofit.create(FineEatServices.class);

        Call<List<FERestaurant>> call = categoryService.loadRestaurant();
        call.enqueue(new Callback<List<FERestaurant>>() { // synchronous call would be with execute()
            @Override
            public void onResponse(Call<List<FERestaurant>> call, Response<List<FERestaurant>> response) {
                Log.v("OnResponse ImportRes", response.message());

                if( response.body() != null){
                    List<FERestaurant> restaurants = response.body();

                    for(FERestaurant res:restaurants){
                        Log.v("Imported res", res.getRestaurantID() + " - " + res.getRestaurantName());
                        Company.addRestaurant(res);
                    }
                }

                call.cancel(); // to cancel a running request call.cancel();
                Log.v("ImportRestaurant", "Finish importing");

                //Import Promo after restaurant
                ImportPromo();
                Company.setImportStatusRestaurant(true);
            }

            @Override
            public void onFailure(Call<List<FERestaurant>> call, Throwable t) {
                Log.v("onFailure ImportRes", t.getMessage());
            }
        });
    }

    public static void ImportPromo()
    {
        Log.v("ImportPromo", "--------------------");
        // prepare call in Retrofit 2.0
        FineEatServices categoryService = FineEatServices.retrofit.create(FineEatServices.class);

        Call<List<FERestaurantPromo>> call = categoryService.loadPromo();
        call.enqueue(new Callback<List<FERestaurantPromo>>() { // synchronous call would be with execute()
            @Override
            public void onResponse(Call<List<FERestaurantPromo>> call, Response<List<FERestaurantPromo>> response) {
                Log.v("OnResponse ImportPromo", response.message());

                if( response.body() != null){
                    List<FERestaurantPromo> promos = response.body();

                    for(FERestaurantPromo pro:promos){
                        Log.v("Imported pro", pro.getRestaurantPromoID() + " - " + pro.getRestaurantID());
                        Company.addPromo(pro);
                    }
                }

                call.cancel(); // to cancel a running request call.cancel();
                Log.v("ImportPromo", "Finish importing");

            }

            @Override
            public void onFailure(Call<List<FERestaurantPromo>> call, Throwable t) {
                Log.v("onFailure ImportPromo", t.getMessage());
            }
        });
    }
}
