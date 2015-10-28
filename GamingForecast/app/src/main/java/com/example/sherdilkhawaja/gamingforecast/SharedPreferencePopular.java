package com.example.sherdilkhawaja.gamingforecast;
import static com.example.sherdilkhawaja.gamingforecast.R.string.names;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SharedPreferencePopular {

    public static final String PREFS_NAME = "Gaming Forecast";
    public static final String MOSTPOPULAR = "Most Popular";

    public SharedPreferencePopular() {
        super();
    }


    //These methods are used to maintaining mostpopular
    public void saveMostpopular(Context context2, List<Product> mostpopular) {
        SharedPreferences settings;
        Editor editor;

        settings = context2.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonMostpopular = gson.toJson(mostpopular);
        editor.putString(MOSTPOPULAR, jsonMostpopular);
        editor.apply();
    }


    public void addMostpopular(Context context, Product product) {
        List<Product> mostpopular = getMostpopular(context);
        if (mostpopular == null)
            mostpopular = new ArrayList<Product>();
        mostpopular.add(product);
        saveMostpopular(context, mostpopular);
    }

    public void removeMostpopular(Context context, Product product) {
        ArrayList<Product> mostpopular = getMostpopular(context);
        if (mostpopular != null) {
            mostpopular.remove(product);
            saveMostpopular(context, mostpopular);
        }
    }

    public void addFavorite(Context context, Product product) {
        List<Product> favorites = SharedPreference.getFavorites(context);
        if (favorites == null)
            favorites = new ArrayList<Product>();
        favorites.add(product);
        SharedPreference.saveFavorites(context, favorites);
    }

    public void removeFavorite(Context context, Product product) {
        ArrayList<Product> favorites = SharedPreference.getFavorites(context);
        if (favorites != null) {
            favorites.remove(product);
            SharedPreference.saveFavorites(context, favorites);
        }
    }


    public ArrayList<Product> getMostpopular(Context context) {
        SharedPreferences settings;
        List<Product> mostpopular;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        if (settings.contains(MOSTPOPULAR)) {
            String jsonMostpopular = settings.getString(MOSTPOPULAR, null);
            Gson gson = new Gson();
            Product[] popularItems = gson.fromJson(jsonMostpopular,
                    Product[].class);

            mostpopular = Arrays.asList(popularItems);
            mostpopular = new ArrayList<Product>(mostpopular);
        }
        else
            return null;

        return (ArrayList<Product>) mostpopular;
    }
    
}