package com.example.pulkit.gamewatcher;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SuggestedListFragment extends Fragment {

    public static final String ARG_ITEM_ID = "Suggested list";

    ListView suggestedList;
    SharedPreferenceGeneric sharedPreferenceSugg;
    SharedPreferenceFavorite sharedPreferenceFav;
    List<Product> suggested;
    List<Product> favorites;

    Activity activity;
    SuggestedListAdapter suggestedListAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        sharedPreferenceSugg = new SharedPreferenceGeneric();
        sharedPreferenceFav = new SharedPreferenceFavorite();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_suggested_list, container,
                false);

        favorites = sharedPreferenceFav.getFavorites(activity);
        suggested = sharedPreferenceSugg.getGeneric(activity);

        suggestedList = (ListView) view.findViewById(R.id.list_suggested);

        Typeface newtypeface = Typeface.createFromAsset(activity.getAssets(), "newtext.ttf");
        TextView suggText = (TextView) view.findViewById(R.id.suggestedxd);
        suggText.setText(R.string.suggestedgames);
        suggText.setTypeface(newtypeface);

        if (favorites.size() != 0) {

            favorites = sharedPreferenceFav.getFavorites(activity);
            suggested = new ArrayList<Product>();

            if (favorites.toString().contains("RPG")) {
                suggested.add(new Product(1, "Bloodborne: The Old Hunters", "", "PS4", 0, "RPG"));
                suggested.add(new Product(2, "Final Fantasy XV", "", "PS4", 0, "RPG"));
                suggested.add(new Product(3, "Pokemon Rainbow", "", "3DS", 0, "RPG"));
                suggested.add(new Product(4, "Destiny: The Taken King", "", "PS4/PC", 0, "RPG"));
                suggested.add(new Product(5, "Fallout 4", "", "PS4/Xbox 1/PC", 0, "RPG"));
                suggested.add(new Product(6, "Citizens of Earth", "", "PS4/XBox 1", 0, "RPG"));
                suggested.add(new Product(7, "Dying Light", "", "PS4", 0, "RPG"));
                suggested.add(new Product(8, "Saints Row IV", "", "XBox/PS4", 0, "RPG"));
            } else if (favorites.toString().contains("Adventure")) {
                suggested.add(new Product(1, "Kingdom Hearts III", "", "PS4/XBox 1", 0, "Adventure"));
                suggested.add(new Product(2, "No Man's Sky", "", "PS4", 0, "Adventure"));
                suggested.add(new Product(3, "Chariot", "", "WII U", 0, "Adventure"));
                suggested.add(new Product(4, "Life is Strange", "5", "PC", 0, "Adventure"));
            } else if (favorites.toString().contains("FPS")) {
                suggested.add(new Product(1, "Metal Gear Solid V", "", "PS4", 0, "FPS"));
                suggested.add(new Product(2, "Evolve", "", "PC", 0, "FPS"));
                suggested.add(new Product(3, "Call of Duty: Black Ops III", "", "PS4/Xbox 1", 0, "FPS"));
                suggested.add(new Product(4, "Duke Nukem 3D", "", "PS Vita", 0, "FPS"));
            } else if (favorites.toString().contains("RTS")) {
                suggested.add(new Product(1, "Star Citizen", "08/23/2015", "PC", 0, "RTS"));
                suggested.add(new Product(2, "Star Craft: Legacy Of The Void", "11/20/2015", "PC", 0, "RTS"));
                suggested.add(new Product(3, "Heroes of Might & Magic III", "11/07/2015", "PS4", 0, "RTS"));
                suggested.add(new Product(4, "Grey Goo", "11/08/2015", "PC", 0, "RTS"));
                suggested.add(new Product(5, "Age Of Myhtology", "11/31/2015", "PS4/Xbox 1", 0, "RTS"));
            } else if (favorites.toString().contains("PUZZLE")) {
                suggested.add(new Product(1, "Pix the Cat", "11/22/2015", "PC", 0, "Puzzle"));
                suggested.add(new Product(2, "Fruit Ninja", "11/31/2015", "PC", 0, "Puzzle"));
                suggested.add(new Product(28, "Tetris Ultimate", "11/11/2014", "PS4", 0, "Puzzle"));
            }
        }

        if (suggested == null) {

            suggested = new ArrayList<Product>();

            showAlert(getResources().getString(R.string.nothing_suggested),
                    getResources().getString(R.string.comeback));

        } else {

            if (suggested.size() == 0) {
                showAlert(
                        getResources().getString(R.string.nothing_suggested),
                        getResources().getString(R.string.comeback));
            }

            suggestedList = (ListView) view.findViewById(R.id.list_suggested);
            if (suggested != null) {
                suggestedListAdapter = new SuggestedListAdapter(activity, suggested);
                suggestedList.setAdapter(suggestedListAdapter);

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
        getActivity().setTitle(R.string.suggestedgames);
        getActivity().getActionBar().setTitle(R.string.suggestedgames);
        super.onResume();
    }
}