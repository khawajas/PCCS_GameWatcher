package com.example.pulkit.gamewatcher;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SharedPreferenceProduct {

    public static final String PREFS_NAME = "Gaming Forecast";
    public static final String PRODUCT = "Most Popular";

    public SharedPreferenceProduct() {
        super();
    }

    //These methods are used to maintain product items

    public void saveProducts(Context context, List<Product> products) {
        SharedPreferences settings;
        Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonProducts = gson.toJson(products);
        editor.putString(PRODUCT, jsonProducts);
        editor.apply();
    }

    public void removeProducts(Context context, Product product) {
        ArrayList<Product> products = getProducts(context);
        if (products != null) {
            products.remove(product);
            saveProducts(context, products);
        }
    }

    public void addProducts(Context context, Product product) {
        List<Product> products = getProducts(context);
        if (products == null)
            products = new ArrayList<Product>();
        products.add(product);
        saveProducts(context, products);
    }

    public ArrayList<Product> getProducts(Context context) {
        SharedPreferences settings;
        List<Product> products;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        if (settings.contains(PRODUCT)) {
            String jsonProducts = settings.getString(PRODUCT, null);
            Gson gson = new Gson();
            Product[] popularItems = gson.fromJson(jsonProducts,
                    Product[].class);

            products = Arrays.asList(popularItems);
            products = new ArrayList<Product>(products);
        }
        else
            return null;

        return (ArrayList<Product>) products;
    }

}