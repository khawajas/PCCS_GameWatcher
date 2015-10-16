package com.example.sherdilkhawaja.gamingforecast;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Pulkit on 10/16/2015.
 */
public class PopularListFragment extends Fragment {

    public static final String ARG_ITEM_ID = "popular_list";

    ListView popularList;
    SharedPreference sharedPreference2;
    List<Product> populars;

    Activity activity;
    ProductListAdapter productListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_list, container,
                false);
        // Get favorite items from SharedPreferences.
        sharedPreference2 = new SharedPreference();
        populars = sharedPreference2.getFavorites(activity);

        if (populars == null) {
            showAlert(getResources().getString(R.string.nothing_pop),
                    getResources().getString(R.string.nothing_pop));
        } else {

            if (populars.size() == 0) {
                showAlert(
                        getResources().getString(R.string.nothing_pop),
                        getResources().getString(R.string.nothing_pop));
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
                                activity.finish();
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
