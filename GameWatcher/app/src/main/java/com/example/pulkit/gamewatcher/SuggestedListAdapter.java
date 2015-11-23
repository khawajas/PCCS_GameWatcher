package com.example.pulkit.gamewatcher;

//This is the custom class which displays product name, description, price and populars

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class SuggestedListAdapter extends ArrayAdapter<Product>{

    private Context context;
    List<Product> products;
    SharedPreferenceFavorite sharedPreference;


    public SuggestedListAdapter(Context context, List<Product> products) {
        super(context, R.layout.suggested_list_item, products);
        this.context = context;
        this.products = products;
        getFilter();
        sharedPreference = new SharedPreferenceFavorite();
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
                List<Product> suggestedList = new ArrayList<Product>();

                for (Product p : products) {
                    if (p.getGame().toUpperCase().startsWith(constraint.toString().toUpperCase()))
                        suggestedList.add(p);
                }

                results.values = suggestedList;
                results.count = suggestedList.size();

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
        TextView suggestedGameTxt;
        TextView suggestedGenre;
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
            convertView = inflater.inflate(R.layout.suggested_list_item, null);
            holder = new ViewHolder();
            holder.suggestedGameTxt = (TextView) convertView
                    .findViewById(R.id.txt_sgst_name);
            holder.suggestedGenre = (TextView) convertView
                    .findViewById(R.id.txt_sgst_genre);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Product product = (Product) getItem(position);
        holder.suggestedGameTxt.setText(product.getGame());
        holder.suggestedGenre.setText(product.getGenre());

        return convertView;
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