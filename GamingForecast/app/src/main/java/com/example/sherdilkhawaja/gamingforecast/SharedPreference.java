package com.example.sherdilkhawaja.gamingforecast;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.gson.Gson;

import com.example.sherdilkhawaja.gamingforecast.Product;

public class SharedPreference {

    public static final String PREFS_NAME = "Gaming Forecast";
    public static final String FAVORITES = "Favorites";

    public SharedPreference() {
        super();
    }

    //These methods are used to maintaining favorites
    public void saveFavorites(Context context, List<Product> favorites) {
        SharedPreferences settings;
        Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);

        editor.putString(FAVORITES, jsonFavorites);

        editor.apply();
    }

    public void addFavorite(Context context, Product product)
    {
        List<Product> favorites = getFavorites(context);
        if (favorites == null)
            favorites = new ArrayList<Product>();
        favorites.add(product);
        saveFavorites(context, favorites);
    }


    public void removeFavorite(Context context, Product product) {
        ArrayList<Product> favorites = getFavorites(context);
        if (favorites != null) {
            favorites.remove(product);
            saveFavorites(context, favorites);
        }
    }

    public ArrayList<Product> getFavorites(Context context) {
        SharedPreferences settings;
        List<Product> favorites;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        if (settings.contains(FAVORITES)) {
            String jsonFavorites = settings.getString(FAVORITES, null);
            Gson gson = new Gson();
            Product[] favoriteItems = gson.fromJson(jsonFavorites,
                    Product[].class);

            favorites = Arrays.asList(favoriteItems);
            favorites = new ArrayList<Product>(favorites);
        }
        else
            return null;

        return (ArrayList<Product>) favorites;
    }
}