package com.example.sherdilkhawaja.gamingforecast;

<<<<<<< HEAD
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
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private Fragment contentFragment;
    ProductListFragment pdtListFragment;
    FavoriteListFragment favListFragment;
    PopularListFragment popListFragment;

    private ArrayList<Integer> list;
    List<Product> products;
    public MainActivity() {

        Product product1 = new Product(1, "Bloodborne", "2/25/2015", "PS4");
        Product product2 = new Product(2, "Kingdom Hearts III", "2/25/2015", "PS4/XBox 1");
        Product product3 = new Product(3, "Final Fantasy XV", "2/25/2015",  "PS4");
        Product product4 = new Product(4, "Metal Gear Solid V", "2/25/2015", "PS4");
        Product product5 = new Product(5, "Pokemon Rainbow", "7/25/2016", "3DS");
        Product product6 = new Product(6, "Call of Duty: Black Ops III", "10/12/2015", "PS4/Xbox 1");
        Product product7 = new Product(7, "Destiny: The Taken King", "9/20/2015", "PS4/PC");
        Product product8 = new Product(8, "Fallout 4", "11/10/2015", "PS4/Xbox 1/PC");

        products = new ArrayList<Product>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);
        products.add(product7);
        products.add(product8);

    }
=======
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
>>>>>>> Realbranch

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
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

    public void goToSu(View view) {
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
=======

        //This is how you make the list of upcoming games for the app...
        //First by making the array, which we turn into the list
        final String[] upcomingGames = {
                "Bloodborne - PS4 - 2/25/2015", "METAL GEAR SOLID V - PS4/XB1/PC - 9/1/2015",
                "THE WITCHER 3 - PS4/XB1 -3/16/2015", "FINAL FANTASY XV - PS4/XB1 - TBA 2016"};

        //The ListAdapter turns the Array into a List

        final ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                upcomingGames);
        //This tells us where to put the array in which layout
        ListView theListView = (ListView) findViewById(R.id.UpcomingGames);
        //tells the listview which data to use
        theListView.setAdapter(theAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                String gamesPicked = "You Selected " +
                        String.valueOf(theAdapter.getItemId(position));
                Toast.makeText(MainActivity.this, gamesPicked, Toast.LENGTH_SHORT).show();
            }
        });
>>>>>>> Realbranch
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        SearchManager searchManager = (SearchManager) getSystemService( Context.SEARCH_SERVICE );
        SearchView searchView = (SearchView) menu.findItem(R.id.options_menu_main_search).getActionView();

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return super.onCreateOptionsMenu( menu );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
<<<<<<< HEAD
        switch (item.getItemId()) {
            case R.id.menu_favorites:
                setFragmentTitle(R.string.favorites);
                favListFragment = new FavoriteListFragment();
                switchContent(favListFragment, FavoriteListFragment.ARG_ITEM_ID);
                return true;
            case R.id.most_popular:
                setFragmentTitle(R.string.mostpopular);
                popListFragment = new PopularListFragment();
                switchContent(popListFragment, PopularListFragment.ARG_ITEM_ID);
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
=======
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
>>>>>>> Realbranch
        }

        return super.onOptionsItemSelected(item);
    }
}