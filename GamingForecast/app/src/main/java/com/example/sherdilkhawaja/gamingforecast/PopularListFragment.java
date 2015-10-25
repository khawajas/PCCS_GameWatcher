package com.example.sherdilkhawaja.gamingforecast;

import java.util.List;
import java.util.logging.Handler;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;


public class PopularListFragment extends Fragment {
    public static final String ARG_ITEM_ID = "Popular list";



    ListView popularList;
    SharedPreferencePopular sharedPreference2;
    List<Product> mostpopular;

    Activity activity;
    ProductListAdapter popularListAdapter2;

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

        // Get popular items from SharedPreferencePopulars.
        sharedPreference2 = new SharedPreferencePopular();
        mostpopular = sharedPreference2.getMostpopular(activity);

        popularList = (ListView) view.findViewById(R.id.list_product);

        if (mostpopular == null) {
            showAlert(getResources().getString(R.string.nothing_pop),
                    getResources().getString(R.string.comeback));
        } else {

            if (mostpopular.size() == 0) {
                showAlert(
                        getResources().getString(R.string.nothing_pop),
                        getResources().getString(R.string.comeback));
            }

            popularList = (ListView) view.findViewById(R.id.list_product);
            if (mostpopular != null) {
                popularListAdapter2 = new ProductListAdapter(activity, mostpopular);
                popularList.setAdapter(popularListAdapter2);

                popularList.setOnItemClickListener(new OnItemClickListener() {

                                                        public void onItemClick(AdapterView<?> parent, View arg1,
                                                                                int position, long arg3) {

                                                            Product product = (Product) parent.getItemAtPosition(position);
                                                            Toast.makeText(activity, product.toString3(), Toast.LENGTH_LONG).show();

                                                        }
                                                    }
                );


                popularList.setOnItemLongClickListener(new OnItemLongClickListener() {

                                                            @Override
                                                            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                                                                           int position, long id) {

                                                                ImageView button = (ImageView) view
                                                                        .findViewById(R.id.imgbtn_favorite);

                                                                String tag2 = button.getTag().toString();
                                                                if (tag2.equalsIgnoreCase("nottrending")) {
                                                                    sharedPreference2.addMostpopular(activity,
                                                                            mostpopular.get(position));
                                                                    Toast.makeText(
                                                                            activity,
                                                                            activity.getResources().getString(
                                                                                    R.string.add_pop),
                                                                            Toast.LENGTH_SHORT).show();

                                                                    button.setTag("trending");
                                                                    button.setImageResource(R.drawable.popular);
                                                                } else {
                                                                    sharedPreference2.removeMostpopular(activity,
                                                                            mostpopular.get(position));
                                                                    button.setTag("nottrending");
                                                                    button.setImageResource(R.drawable.popular);
                                                                    popularListAdapter2.remove(mostpopular
                                                                            .get(position));
                                                                    Toast.makeText(
                                                                            activity,
                                                                            activity.getResources().getString(
                                                                                    R.string.remove_pop),
                                                                            Toast.LENGTH_SHORT).show();
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

