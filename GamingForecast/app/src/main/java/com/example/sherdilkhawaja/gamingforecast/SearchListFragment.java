package com.example.sherdilkhawaja.gamingforecast;

import java.util.ArrayList;

import android.app.DialogFragment;
import android.app.ListFragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SearchView.OnQueryTextListener;




public class SearchListFragment extends Fragment {

    View games;
    public SearchView search;
    public ListView lv;

    public static final String ARG_ITEM_ID = "Search list";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.fragment_search, container, false);

        setHasOptionsMenu(true);

        ListView phoneListView = ((ListView) rootView.findViewById(R.id.games));

        ArrayList<String> gameList = new ArrayList<String>();
        gameList.add("Bloodborne: The Old Hunters");
        gameList.add("Kingdom Hearts III");
        gameList.add("Final Fantasy XV");

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, gameList);
        // Set The Adapter
        phoneListView.setAdapter(arrayAdapter);
        return rootView;


    }
}

