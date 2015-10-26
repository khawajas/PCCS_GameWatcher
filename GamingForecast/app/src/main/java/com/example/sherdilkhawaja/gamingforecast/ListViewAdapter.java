package com.example.sherdilkhawaja.gamingforecast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<Product> productList = null;
    private ArrayList<Product> arraylist;

    public ListViewAdapter(Context context, List<Product> productList) {
        mContext = context;
        this.productList = productList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Product>();
        this.arraylist.addAll(productList);
    }

    public class ViewHolder {
        TextView games;

    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Product getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.fragment_search, null);
            // Locate the TextViews in listview_item.xml
            holder.games = (TextView) view.findViewById(R.id.games);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.games.setText(productList.get(position).getGame());

        // Listen for ListView Item Click
        view.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Send single item click data to SingleItemView Class
                Intent intent = new Intent(mContext, SearchListFragment.class);
                // Pass all data rank
                intent.putExtra("Games",(productList.get(position).getGame()));
                // Pass all data flag
                // Start SingleItemView Class
                mContext.startActivity(intent);
            }
        });

        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        productList.clear();
        if (charText.length() == 0) {
            productList.addAll(arraylist);
        }
        else
        {
            for (Product wp : arraylist)
            {
                if (wp.getGame().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    productList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}