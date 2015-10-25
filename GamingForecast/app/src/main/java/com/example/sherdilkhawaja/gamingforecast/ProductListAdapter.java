package com.example.sherdilkhawaja.gamingforecast;

//This is the custom class which displays product name, description, price and favorites
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ProductListAdapter extends ArrayAdapter<Product>{

    private Context context;
    List<Product> products;
    SharedPreference sharedPreference;
    SharedPreferencePopular sharedPreference2;
    public boolean cookie = false;


    public ProductListAdapter (Context context, List<Product> products) {
        super(context, R.layout.product_list_item, products);
        this.context = context;
        this.products = products;
        getFilter();
        sharedPreference = new SharedPreference();
        sharedPreference2 = new SharedPreferencePopular();
    }



    private class ViewHolder {
        TextView productGameTxt;
        TextView productReleaseTxt;
        TextView productPlatformTxt;
        ImageView favoriteImg;
        TextView ratingTxt;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    public Product getGameDate(int position) {
        return products.get(position);
    }
    @Override
    public Product getItem(int position) {
        return products.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }

    public int getRaters(String position) {
        return 0;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.product_list_item, null);
            holder = new ViewHolder();
            holder.productGameTxt = (TextView) convertView
                    .findViewById(R.id.txt_pdt_name);
            holder.productPlatformTxt = (TextView) convertView
                    .findViewById(R.id.txt_pdt_desc);
            holder.productReleaseTxt = (TextView) convertView
                    .findViewById(R.id.txt_pdt_price);
            holder.favoriteImg = (ImageView) convertView
                    .findViewById(R.id.imgbtn_favorite);
            holder.ratingTxt = (TextView) convertView
                    .findViewById(R.id.txt_rating_value);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Product product = (Product) getItem(position);
        holder.productGameTxt.setText(product.getGame());
        /*If a product exists in shared preferences then set heart_red drawable
         * and set a tag*/

        if (checkFavoriteItem(product)) {
            holder.favoriteImg.setImageResource(R.drawable.heart_red);
            holder.favoriteImg.setTag("red");
        } else {
            holder.favoriteImg.setImageResource(R.drawable.grey_heart);
            holder.favoriteImg.setTag("grey");
        }
        return convertView;
    }

    public View getView2(int position2, View convertView2, ViewGroup parent2) {
        ViewHolder holder2 = null;
        if (convertView2 == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView2 = inflater.inflate(R.layout.product_list_item, null);
            holder2 = new ViewHolder();
            holder2.productGameTxt = (TextView) convertView2
                    .findViewById(R.id.txt_pdt_name);
            holder2.productPlatformTxt = (TextView) convertView2
                    .findViewById(R.id.txt_pdt_desc);
            holder2.productReleaseTxt = (TextView) convertView2
                    .findViewById(R.id.txt_pdt_price);
            convertView2.setTag(holder2);
        } else {
            holder2 = (ViewHolder) convertView2.getTag();
        }
        Product product = (Product) getItem(position2);

        /*If a product exists in shared preferences 2 set a tag; */
        if (checkPopularItem(product)) {
            holder2.favoriteImg.setTag("trending");
            holder2.favoriteImg.setImageResource(R.drawable.popular);

        } else {
            holder2.favoriteImg.setTag("nottrending");
            holder2.favoriteImg.setImageResource(R.drawable.popular);
        }
        return convertView2;
    }

    /*Checks whether a particular product exists in SharedPreferences*/
    public boolean checkFavoriteItem(Product checkProduct) {
        boolean check = false;
        List<Product> favorites = sharedPreference.getFavorites(context);
        if (favorites != null) {
            for (Product product : favorites) {
                if (product.equals(checkProduct)) {
                    check = true;
                    break;
                }
            }
        }
        return check;
    }

    public boolean checkPopularItem(Product checkProduct2) {
        boolean check2 = false;
        List<Product> mostpopular = sharedPreference2.getMostpopular(context);
        if (mostpopular != null) {
            for (Product product : mostpopular) {
                if (product.equals(mostpopular)) {
                    check2 = true;
                    break;
                }
            }
        }
        return check2;
    }




    @Override
    public void add(Product product) {
        super.add(product);
        products.add(product);
        notifyDataSetChanged();
    }


    @Override
    public void remove(Product product) {
        super.remove(product);
        products.remove(product);
        notifyDataSetChanged();
    }

}

