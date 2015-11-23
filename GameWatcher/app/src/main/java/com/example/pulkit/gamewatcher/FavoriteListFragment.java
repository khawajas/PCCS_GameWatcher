package com.example.pulkit.gamewatcher;

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
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;


public class FavoriteListFragment extends Fragment {

    public static final String ARG_ITEM_ID = "favorite_list";

    ListView favoriteList;
    SharedPreferenceFavorite sharedPreferenceFavorite;
    SharedPreferenceFavoriteCopy sharedPreferenceFavoriteCopy;
    List<Product> favorites;
    List<Product> favoritescopy;

    Activity activity;
    ProductListAdapter productListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        sharedPreferenceFavorite = new SharedPreferenceFavorite();
        sharedPreferenceFavoriteCopy = new SharedPreferenceFavoriteCopy();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_favorite_list, container,
                false);

        favorites = sharedPreferenceFavorite.getFavorites(activity);
        favoritescopy = sharedPreferenceFavoriteCopy.getFavorites(activity);

        final ViewSwitcher viewSwitcher = (ViewSwitcher) view.findViewById(R.id.viewSwitcher);

        if (favorites == null) {

            favorites = new ArrayList<Product>();

            showAlert(getResources().getString(R.string.no_favorites_items),
                    getResources().getString(R.string.no_favorites_msg));

        } else {

            if (favorites.size() == 0) {
                showAlert(
                        getResources().getString(R.string.no_favorites_items),
                        getResources().getString(R.string.no_favorites_msg));
            }

            favoriteList = (ListView) view.findViewById(R.id.list_product);
            if (favorites != null) {

                favorites = sharedPreferenceFavorite.getFavorites(activity);
                productListAdapter = new ProductListAdapter(activity, favorites);
                favoriteList.setAdapter(productListAdapter);

                favoriteList.setOnItemClickListener(new OnItemClickListener() {

                                                        public void onItemClick(AdapterView<?> parent, View arg1,
                                                                                int position, long arg3) {

                                                            Product product = (Product) parent.getItemAtPosition(position);
                                                            Toast.makeText(activity, product.toString3(), Toast.LENGTH_SHORT).show();

                                                        }
                                                    }
                );


                favoriteList.setOnItemLongClickListener(new OnItemLongClickListener() {

                                                            @Override
                                                            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                                                                           int position, long id) {

                                                                ImageView button = (ImageView) view
                                                                        .findViewById(R.id.imgbtn_favorite);

                                                                String tag = button.getTag().toString();
                                                                if (tag.equalsIgnoreCase("grey")) {
                                                                    sharedPreferenceFavorite.addFavorite(activity,
                                                                            favorites.get(position));
                                                                    Toast.makeText(
                                                                            activity,
                                                                            activity.getResources().getString(
                                                                                    R.string.add_favr),
                                                                            Toast.LENGTH_SHORT).show();

                                                                    button.setTag("red");
                                                                    button.setImageResource(R.mipmap.heart_red);
                                                                } else {
                                                                    sharedPreferenceFavorite.removeFavorite(activity,
                                                                            favorites.get(position));
                                                                    button.setTag("grey");
                                                                    button.setImageResource(R.mipmap.grey_heart);
                                                                    productListAdapter.remove(favorites
                                                                            .get(position));
                                                                    Toast.makeText(
                                                                            activity,
                                                                            activity.getResources().getString(
                                                                                    R.string.remove_favr),
                                                                            Toast.LENGTH_SHORT).show();

                                                                    favorites = sharedPreferenceFavorite.getFavorites(activity);

                                                                    if (favorites.size() == 0) {
                                                                        showAlert(
                                                                                getResources().getString(R.string.no_favorites_items),
                                                                                getResources().getString(R.string.no_favorites_msg));
                                                                    }
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
        getActivity().setTitle(R.string.favorites);
        getActivity().getActionBar().setTitle(R.string.favorites);
        super.onResume();
    }
}
