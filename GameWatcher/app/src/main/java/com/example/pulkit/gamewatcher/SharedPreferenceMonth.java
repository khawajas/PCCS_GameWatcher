package com.example.pulkit.gamewatcher;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SharedPreferenceMonth {

    public static final String PREFS_NAME = "Gaming Forecast";
    public static final String MONTHS = "Most Popular";

    public SharedPreferenceMonth() {
        super();
    }


    //These methods are used to maintain months items.

    public void saveMonths(Context context, List<Product> months) {
        SharedPreferences settings;
        Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonMonths = gson.toJson(months);
        editor.putString(MONTHS, jsonMonths);
        editor.apply();
    }


    public ArrayList<Product> getMonths(Context context) {
        SharedPreferences settings;
        List<Product> products;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        if (settings.contains(MONTHS)) {
            String jsonMonths = settings.getString(MONTHS, null);
            Gson gson = new Gson();
            Product[] productItems = gson.fromJson(jsonMonths,
                    Product[].class);

            products = Arrays.asList(productItems);
            products = new ArrayList<Product>(products);
        }
        else
            return null;

        return (ArrayList<Product>) products;
    }

}