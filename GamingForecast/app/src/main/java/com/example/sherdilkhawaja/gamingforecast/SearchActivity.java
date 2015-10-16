package com.example.sherdilkhawaja.gamingforecast;

import android.app.ActionBar;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;

/**
 * Created by sherdilkhawaja on 10/15/15.
 */
public class SearchActivity extends MainActivity {

    private ListView listResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchable);
        handleIntent(getIntent());


        // get the action bar
        ActionBar actionBar = getActionBar();

        // Enabling Back navigation on Action Bar icon
        actionBar.setDisplayHomeAsUpEnabled(true);

        listResults = (ListView) findViewById(R.id.list_product);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }

    /**
     * Handling intent data
     */
    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);

            listResults.setAdapter(new ArrayAdapter(this, R.layout.fragment_product_list));
            listResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Serializable selectedResult = (Serializable) parent.getItemAtPosition(position);
                    setResult(RESULT_OK, new Intent().putExtra("result", selectedResult));
                    finish();
                }
            });
        }
    }
}


