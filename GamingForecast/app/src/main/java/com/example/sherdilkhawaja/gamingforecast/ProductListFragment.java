package com.example.sherdilkhawaja.gamingforecast;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class ProductListFragment extends Fragment implements
        OnItemClickListener, OnItemLongClickListener  {

    public static final String ARG_ITEM_ID = "Product_list";

    Activity activity;
    ListView productListView;
    public static ArrayList<Product> products;
    ProductListAdapter productListAdapter;
    SharedPreference sharedPreference;
    SharedPreferencePopular sharedPreferencePopular;

    ListView lv;
    SearchView search_view;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        sharedPreference = new SharedPreference();
        sharedPreferencePopular = new SharedPreferencePopular();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_product_list, container,
                false);

        findViewsById(view);

        setProducts();

        productListAdapter = new ProductListAdapter(activity, products);
        productListView.setAdapter(productListAdapter);
        productListView.setOnItemClickListener(this);
        productListView.setOnItemLongClickListener(this);

        return view;
    }

        public void setProducts() {

            products = new ArrayList<Product>();

            products.add(new Product(1, "Bloodborne: The Old Hunters", "11/03/2015", "PS4", 0));
            products.add(new Product(2, "Kingdom Hearts III", "10/28/2015", "PS4/XBox 1", 0));
            products.add(new Product(3, "Final Fantasy XV", "10/28/2015", "PS4", 0));
            products.add(new Product(4, "Metal Gear Solid V", "10/29/2015", "PS4", 0));
            products.add(new Product(5, "Pokemon Rainbow", "10/30/2015", "3DS", 0));
            products.add(new Product(6, "Call of Duty: Black Ops III", "10/31/2015", "PS4/Xbox 1", 0));
            products.add(new Product(7, "Destiny: The Taken King", "11/01/2015", "PS4/PC", 0));
            products.add(new Product(8, "Fallout 4", "11/02/2015", "PS4/Xbox 1/PC", 0));
            products.add(new Product(9, "No Man's Sky", "11/04/2015", "PS4", 0));
            products.add(new Product(10, "Chariot", "11/03/2015", "WII U", 0));
            products.add(new Product(11, "Evolve", "11/04/2015", "PC", 0));
            products.add(new Product(12, "Citizens of Earth", "11/05/2015", "PS4/XBox 1", 0));
            products.add(new Product(13, "Dying Light", "11/06/2015", "PS4", 0));
            products.add(new Product(14, "Heroes of Might & Magic III", "11/07/2015", "PS4", 0));
            products.add(new Product(15, "Life is Strange", "11/07/2015", "PC", 0));
            products.add(new Product(16, "Grey Goo", "11/08/2015", "PC", 0));
            products.add(new Product(17, "Pix the Cat", "11/09/2015", "PC", 0));
            products.add(new Product(18, "Duke Nukem 3D", "11/10/2015", "PS Vita", 0));
            products.add(new Product(19, "Saints Row IV", "11/11/2015", "XBox/PS4", 0));

    }

    public ArrayList getArrayList() {
        return products;
    }



    public void findViewsById(View view) {
        productListView = (ListView) view.findViewById(R.id.list_product);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        Product product = (Product) parent.getItemAtPosition(position);
        Toast.makeText(activity, product.toString(), Toast.LENGTH_LONG).show();

    }


    @Override
    public boolean onItemLongClick(AdapterView<?> arg0, View view, int position, long arg3) {
        ImageView button = (ImageView) view.findViewById(R.id.imgbtn_favorite);

        String tag = button.getTag().toString();
        if (tag.equalsIgnoreCase("grey")) {
            sharedPreference.addFavorite(activity, products.get(position));
            Toast.makeText(activity, activity.getResources().getString(R.string.add_favr),
                    Toast.LENGTH_SHORT).show();
            button.setTag("red");
            button.setImageResource(R.drawable.heart_red);
        }
        else {
            sharedPreference.removeFavorite(activity, products.get(position));
            sharedPreferencePopular.removeMostpopular(activity, products.get(position));
            button.setTag("grey");
            button.setImageResource(R.drawable.grey_heart);
            Toast.makeText(activity, activity.getResources().getString(R.string.remove_favr),
                    Toast.LENGTH_SHORT).show();

            }
            return true;
        }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onResume() {
        getActivity().setTitle(R.string.names);
        getActivity().getActionBar().setTitle(R.string.names);
        super.onResume();
    }
}


