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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;


public class SearchListFragment extends Fragment {
    public static final String ARG_ITEM_ID = "Search list";
    ArrayAdapter<String> adapter;
    String[] games={"Pokemon", "Naruto"};

    Activity activity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_search, null);

        getActivity().setTitle("Search");

        adapter = new ArrayAdapter<String>(getActivity(), R.layout.searchable);

        return rootView;
    }



    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onResume() {
        getActivity().setTitle(R.string.label);
        getActivity().getActionBar().setTitle(R.string.label);
        super.onResume();
    }
}

