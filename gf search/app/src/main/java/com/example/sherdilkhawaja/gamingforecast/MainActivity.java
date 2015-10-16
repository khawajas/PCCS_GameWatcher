package com.example.sherdilkhawaja.gamingforecast;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    private Fragment contentFragment;
    ProductListFragment pdtListFragment;
    FavoriteListFragment favListFragment;
    private SearchView searchView;
    private MenuItem searchMenuItem;
    private ProductListAdapter productListAdapter;
    private ArrayList gamesArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();



        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("content")) {
                String content = savedInstanceState.getString("content");
                if (content != null) {
                    if (content.equals(FavoriteListFragment.ARG_ITEM_ID)) {
                        if (fragmentManager.findFragmentByTag(FavoriteListFragment.ARG_ITEM_ID) != null) {
                            setFragmentTitle(R.string.favorites);
                            contentFragment = fragmentManager
                                    .findFragmentByTag(FavoriteListFragment.ARG_ITEM_ID);
                        }
                    }
                }
            }
            if (fragmentManager.findFragmentByTag(ProductListFragment.ARG_ITEM_ID) != null) {
                pdtListFragment = (ProductListFragment) fragmentManager
                        .findFragmentByTag(ProductListFragment.ARG_ITEM_ID);
                contentFragment = pdtListFragment;
            }
        } else

        {
            pdtListFragment = new ProductListFragment();
            setFragmentTitle(R.string.names);
            switchContent(pdtListFragment, ProductListFragment.ARG_ITEM_ID);
        }

    }


    //Make sure we add the other videos later, this will suffice.
    public void goToSu (View view) {
        goToUrl("https://www.youtube.com/watch?v=tBGjx-4_R10");
    }

    public void badurl (View view) {
        goToUrl("https://wwww.youtube.com/idkbadurl");
    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (contentFragment instanceof FavoriteListFragment) {
            outState.putString("content", FavoriteListFragment.ARG_ITEM_ID);
        } else {
            outState.putString("content", ProductListFragment.ARG_ITEM_ID);
        }
        super.onSaveInstanceState(outState);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        //for the search function
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        SearchManager searchManager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);
        searchMenuItem = menu.findItem(R.id.search);
        searchView = (SearchView) searchMenuItem.getActionView();

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener((SearchView.OnQueryTextListener) this);



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_favorites:
                setFragmentTitle(R.string.favorites);
                favListFragment = new FavoriteListFragment();
                switchContent(favListFragment, FavoriteListFragment.ARG_ITEM_ID);

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void switchContent(Fragment fragment, String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        while (fragmentManager.popBackStackImmediate());

        if (fragment != null) {
            FragmentTransaction transaction = fragmentManager
                    .beginTransaction();
            transaction.replace(R.id.content_frame, fragment, tag);

            if (!(fragment instanceof ProductListFragment)) {
                transaction.addToBackStack(tag);
            }
            transaction.commit();
            contentFragment = fragment;
        }
    }

    protected void setFragmentTitle(int resourceId) {
        setTitle(resourceId);
        getActionBar().setTitle(resourceId);

    }


    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            super.onBackPressed();
        } else if (contentFragment instanceof ProductListFragment
                || fm.getBackStackEntryCount() == 0) {
            finish();
        }
    }

    public boolean onQueryTextSumbit(String query){
        return false;
    }

    public boolean onQueryTextChange (String newText){
        productListAdapter.getFilter().filter(newText);
        return true;
    }

    /*private void handleListItemClick(User user){
        if (searchView.isShown()) {
            searchMenuItem.collapseActionView();
            searchView.setQuery("", false);
        }
    }*/
}