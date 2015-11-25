package com.example.pulkit.gamewatcher;

//This is the custom class which displays product name, description, price and populars

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class PopularListAdapter extends ArrayAdapter<Product>{

    private Context context;
    List<Product> products;
    SharedPreferenceFavorite sharedPreferenceFavorite;


    public PopularListAdapter(Context context, List<Product> products) {
        super(context, R.layout.popular_list_item, products);
        this.context = context;
        this.products = products;
        getFilter();
        sharedPreferenceFavorite = new SharedPreferenceFavorite();
    }

    public abstract class ProductFilter extends Filter {
        @Override
        public FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            // We implement here the filter logic
            if (constraint == null || constraint.length() == 0) {
                // No filter implemented we return all the list
                results.values = products;
                results.count = products.size();
            } else {
                // We perform filtering operation
                List<Product> nPlanetList = new ArrayList<Product>();

                for (Product p : products) {
                    if (p.getGame().toUpperCase().startsWith(constraint.toString().toUpperCase()))
                        nPlanetList.add(p);
                }

                results.values = nPlanetList;
                results.count = nPlanetList.size();

            }
            return results;
        }


        @Override
        public void publishResults(CharSequence constraint, FilterResults results) {

            // Now we have to inform the adapter about the new list filtered
            if (results.count == 0)
                notifyDataSetInvalidated();
            else {
                products = (List<Product>) results.values;
                notifyDataSetChanged();
            }

        }

    }

    private class ViewHolder {
        TextView productGameTxt;
        ImageView popularImg;
    }

    @Override
    public int getCount() {
        return products.size();
    }
    @Override
    public Product getItem(int position) {
        return products.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.popular_list_item, null);
            holder = new ViewHolder();
            holder.productGameTxt = (TextView) convertView
                    .findViewById(R.id.popular_name);
            holder.popularImg = (ImageView) convertView
                    .findViewById(R.id.imgbtn_popular);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Product product = (Product) getItem(position);
        holder.productGameTxt.setText(product.getGame());

             /*If a product exists in shared preferences popular then set popular drawable
         * and set a tag*/

        if (checkFavoriteItem(product)) {
            holder.popularImg.setImageResource(R.mipmap.stars);
            holder.popularImg.setTag("trending");
        } else {
            holder.popularImg.setImageResource(R.mipmap.stars);
            holder.popularImg.setTag("not trending");
        }
        return convertView;
    }

    /*Checks whether a particular product exists in SharedPreferences*/

    public boolean checkFavoriteItem(Product checkProduct) {
        boolean check = false;
        List<Product> favorites = sharedPreferenceFavorite.getFavorites(context);
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

