package com.example.pulkit.gamewatcher;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SharedPreferenceGeneric {

    public static final String PREFS_NAME = "Gaming Forecast";
    public static final String GENERIC = "Most Popular";

    public SharedPreferenceGeneric() {
        super();
    }


    //These methods are used to maintain generic/popular items

    public void saveGeneric(Context context, List<Product> generic) {
        SharedPreferences settings;
        Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonGeneric = gson.toJson(generic);
        editor.putString(GENERIC, jsonGeneric);
        editor.apply();
    }

    public void removeGeneric(Context context, Product product) {
        ArrayList<Product> generic = getGeneric(context);
        if (generic != null) {
            generic.remove(product);
            saveGeneric(context, generic);
        }
    }

    public void addFavorite(Context context, Product product) {
        List<Product> favorites = SharedPreferenceFavorite.getFavorites(context);
        if (favorites == null)
            favorites = new ArrayList<Product>();
        favorites.add(product);
        SharedPreferenceFavorite.saveFavorites(context, favorites);
    }


    public ArrayList<Product> getGeneric(Context context) {
        SharedPreferences settings;
        List<Product> products;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        if (settings.contains(GENERIC)) {
            String jsonGeneric = settings.getString(GENERIC, null);
            Gson gson = new Gson();
            Product[] productItems = gson.fromJson(jsonGeneric,
                    Product[].class);

            products = Arrays.asList(productItems);
            products = new ArrayList<Product>(products);
        }
        else
            return null;

        return (ArrayList<Product>) products;
    }

}