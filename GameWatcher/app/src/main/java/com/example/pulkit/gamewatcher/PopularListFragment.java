package com.example.pulkit.gamewatcher;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class PopularListFragment extends Fragment {

    public static final String ARG_ITEM_ID = "Popular list";

    ListView popularList;
    SharedPreferenceGeneric sharedPreference;
    List<Product> mostpopular;
    List<Product> products;
    List<Product> favorites;

    Activity activity;
    PopularListAdapter popularListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popular_list, container,
                false);

        sharedPreference = new SharedPreferenceGeneric();
        mostpopular = sharedPreference.getGeneric(activity);

        products = new ArrayList<Product>();
        favorites = new ArrayList<Product>();
        mostpopular = new ArrayList<Product>();
        popularList = (ListView) view.findViewById(R.id.list_popular);

        Typeface newtypeface = Typeface.createFromAsset(activity.getAssets(), "newtext.ttf");
        TextView suggText = (TextView) view.findViewById(R.id.popular);
        suggText.setText(R.string.currpop);
        suggText.setTypeface(newtypeface);

        //this is to be updated by the app creators based on searches/favorites. Manually add to most popular page below to let users know what others are searching.

        mostpopular.add(new Product(0, "Bloodborne: The Old Hunters", "02/03/2015", "PS4", 0, "RPG"));
        mostpopular.add(new Product(1, "Star Citizen", "08/23/2015", "PC", 0, "RTS"));
        mostpopular.add(new Product(2, "Kingdom Hearts III", "05/28/2015", "PS4/XBox 1", 0, "Adventure"));
        mostpopular.add(new Product(3, "Final Fantasy XV", "04/28/2015", "PS4", 0, "RPG"));
        mostpopular.add(new Product(4, "The Legend Of Zelda", "02/15/2016", "WII U", 0, "Adventure"));
        mostpopular.add(new Product(5, "Star Craft: Legacy Of The Void", "11/20/2015", "PC", 0, "RTS"));

        if (mostpopular == null) {
            showAlert(getResources().getString(R.string.nothing_pop),
                    getResources().getString(R.string.comeback));
        } else {

            if (mostpopular.size() == 0) {
                showAlert(
                        getResources().getString(R.string.nothing_pop),
                        getResources().getString(R.string.comeback));
            }

            popularList = (ListView) view.findViewById(R.id.list_popular);
            if (mostpopular != null) {
                popularListAdapter = new PopularListAdapter(activity, mostpopular);
                popularList.setAdapter(popularListAdapter);

                Toast.makeText(activity, activity.getResources().getString(R.string.otherslike), Toast.LENGTH_SHORT).show();


                popularList.setOnItemClickListener(new OnItemClickListener() {

                                                       public void onItemClick(AdapterView<?> parent, View arg1,
                                                                               int position, long arg3) {

                                                           Product product = (Product) parent.getItemAtPosition(position);
                                                           Toast.makeText(activity, product.toString3(), Toast.LENGTH_SHORT).show();

                                                       }
                                                   }
                );


                popularList.setOnItemLongClickListener(new OnItemLongClickListener() {

                                                           @Override
                                                           public boolean onItemLongClick(AdapterView<?> parent, View view,
                                                                                          int position, long id) {

                                                               ImageView button = (ImageView) view
                                                                       .findViewById(R.id.imgbtn_popular);
                                                               String tag = button.getTag().toString();
                                                               if (tag.equalsIgnoreCase("trending")) {
                                                                   Toast.makeText(activity, activity.getResources().getString(R.string.error), Toast.LENGTH_SHORT).show();
                                                               } else {
                                                                   sharedPreference.addFavorite(activity,
                                                                           mostpopular.get(position));
                                                                   Toast.makeText(
                                                                           activity,
                                                                           activity.getResources().getString(
                                                                                   R.string.add_favr),
                                                                           Toast.LENGTH_SHORT).show();

                                                                   button.setTag("trending");
                                                                   button.setImageResource(R.mipmap.stars);

                                                               }
                                                               return true;
                                                           }
                                                       }
                );
            }
        }
        return view;
    }


    public void showAlert(String title, String message) {
        if (activity != null && !activity.isFinishing()) {
            AlertDialog alertDialog = new AlertDialog.Builder(activity)
                    .create();
            alertDialog.setTitle(title);
            alertDialog.setMessage(message);
            alertDialog.setCancelable(false);

            // setting OK Button
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                    new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            getFragmentManager().popBackStackImmediate();
                        }
                    });
            alertDialog.show();
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onResume() {
        getActivity().setTitle(R.string.mostpopular);
        getActivity().getActionBar().setTitle(R.string.mostpopular);
        super.onResume();
    }
}