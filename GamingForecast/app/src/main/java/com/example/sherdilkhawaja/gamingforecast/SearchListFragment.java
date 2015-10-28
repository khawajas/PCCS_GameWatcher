package com.example.sherdilkhawaja.gamingforecast;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;


public class SearchListFragment extends Fragment implements SearchView.OnQueryTextListener {

    ListView lv;
    SearchView search_view;
    ArrayList<String> gamers;
    ArrayAdapter<String> adapter;
    public ArrayList<Product> products;

    public static final String ARG_ITEM_ID = "Search list";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.fragment_search, container, false);


        lv = (ListView) rootView.findViewById(R.id.list_view2);
        search_view = (SearchView) rootView.findViewById(R.id.search_view);


        String[] games = {"Bloodborne: The Old Hunters","Pokemon Rainbow","Metal Gear solid V: The Phantom Pain", "Final Fantasy XV", "The Witcher 3: The Wild Hunt", "Uncharted 4", "Fallout 4", "No Man's Sky",
                "Destiny: The Taken King", "Call Of Duty: Black Ops 3", "Kingdom Hearts III", "Persona V", "Xenoblade Chronicles X", "Half Life 3", "Pacman", "The Legend of Zelda: Twilight Princess", "League of Legends",
                "Madden 2016", "NBA 2k16", "Digimon", "Yugioh", "Splatoon", "Star Wars Battlefront", "Rise Of The Tomb Raider", "Need For Speed", "WWE 2k16", "Assassin's Creed Syndicate", "Watchdogs", "Halo 4",
                "Overwatch", "Street Fighter V"};

        gamers = new ArrayList<String>();

        for (String gameList : games) {
            Locale obj = new Locale("", gameList);
            gamers.add(obj.getDisplayCountry());
        }

        adapter = new ArrayAdapter<String>(getActivity(),
                R.layout.list_items, R.id.name, gamers);

        lv.setAdapter(adapter);
        search_view.setOnQueryTextListener(this);

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
}



