package com.example.pulkit.gamewatcher;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class SearchListFragment extends Fragment implements SearchView.OnQueryTextListener {

    RadioButton checkSearch;
    ListView lv;
    SearchView sv;
    ArrayList<String> gamers;
    ArrayAdapter<String> adapter;

    public static final String ARG_ITEM_ID = "Search list";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.fragment_search, container, false);


        lv = (ListView) rootView.findViewById(R.id.list_viewsearch);
        sv = (SearchView) rootView.findViewById(R.id.searchbar);

        checkSearch = (RadioButton) rootView.findViewById(R.id.checkBoxSearch);

        final String[] games = {"Bloodborne: The Old Hunters","Pokemon Rainbow","The Legend of Zelda", "Star Citizen", "League of Legends", "Metal Gear solid V: The Phantom Pain", "Final Fantasy XV", "The Witcher 3: The Wild Hunt", "Uncharted 4", "Fallout 4", "No Man's Sky",
                "Destiny: The Taken King", "Call Of Duty: Black Ops 3", "Kingdom Hearts III", "Persona V", "Xenoblade Chronicles X", "Half Life 3", "Pacman", "The Legend of Zelda: Twilight Princess",
                "Madden 2016", "NBA 2k16", "Grand Theft Auto V", "Digimon Story: Cyber Sleuth", "Pix The Cat", "Yugioh! Legacy of the Duelist", "Tetris Ultimate", "Splatoon", "Star Wars Battlefront", "Rise Of The Tomb Raider", "Need For Speed",
                "WWE 2k16", "Assassin's Creed Syndicate", "Watchdogs", "Halo 4", "Overwatch", "Street Fighter V"};

        gamers = new ArrayList<String>(Arrays.asList(games));

        adapter = new ArrayAdapter<String>(getActivity(),
                R.layout.list_items, R.id.name, gamers);

        lv.setAdapter(adapter);
        sv.setOnQueryTextListener(this);

        checkSearch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (checkSearch.isChecked()) {
                    Collections.sort(gamers);
                    adapter.notifyDataSetChanged();
                }
            }
        });


        return rootView;

    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onResume() {
        getActivity().setTitle(R.string.searchforgame);
        getActivity().getActionBar().setTitle(R.string.searchforgame);
        super.onResume();
    }
}




