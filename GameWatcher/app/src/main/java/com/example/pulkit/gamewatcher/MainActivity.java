package com.example.pulkit.gamewatcher;

import android.app.ActionBar;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.CheckBox;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class MainActivity extends FragmentActivity {

    NotificationCompat.Builder notification;
    public static int uniqueID = 45612;

    private Fragment contentFragment;
    ProductListFragment pdtListFragment;
    FavoriteListFragment favListFragment;
    PopularListFragment popListFragment;
    SearchListFragment searchListFragment;
    SuggestedListFragment suggestedListFragment;
    ThisMonthListFragment thismonthListFragment;

    public WebView WebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();


        ArrayList<Product> gameList = new ArrayList<Product>();

        gameList.add(new Product(0, "Bloodborne: The Old Hunters", "02/03/2015", "PS4", 0, "RPG"));
        gameList.add(new Product(1, "Star Citizen", "08/23/2015", "PC", 0, "RTS"));
        gameList.add(new Product(2, "Kingdom Hearts III", "05/28/2015", "PS4/XBox 1", 0, "Adventure"));
        gameList.add(new Product(3, "Final Fantasy XV", "04/28/2015", "PS4", 0, "RPG"));
        gameList.add(new Product(4, "The Legend Of Zelda", "02/15/2016", "WII U", 0, "Adventure"));
        gameList.add(new Product(5, "Star Craft: Legacy Of The Void", "11/20/2015", "PC", 0, "RTS"));
        gameList.add(new Product(6, "Pokemon Rainbow", "10/30/2015", "3DS", 0, "RPG"));
        gameList.add(new Product(7, "Destiny: The Taken King", "03/01/2015", "PS4/PC", 0, "RPG"));
        gameList.add(new Product(8, "Fallout 4", "05/02/2015", "PS4/XBO/PC", 0, "RPG"));
        gameList.add(new Product(9, "Mass Effect: Andromeda", "06/04/2015", "PS4/XBO", 0, "Shooter"));
        gameList.add(new Product(10, "No Man's Sky", "08/04/2015", "PS4", 0, "Adventure"));
        gameList.add(new Product(11, "Evolve", "07/04/2015", "PC", 0, "Shooter"));
        gameList.add(new Product(12, "Citizens of Earth", "09/05/2015", "PS4/XBox 1", 0, "RPG"));
        gameList.add(new Product(13, "Dying Light", "10/06/2015", "PS4", 0, "RPG"));
        gameList.add(new Product(14, "Heroes of Might & Magic III", "12/07/2015", "PS4", 0, "RTS"));
        gameList.add(new Product(15, "Life is Strange", "07/07/2015", "PC", 0, "Adventure"));
        gameList.add(new Product(16, "Grey Goo", "04/08/2015", "PC", 0, "RTS"));
        gameList.add(new Product(17, "Pix the Cat", "07/22/2015", "PC", 0, "Puzzle"));
        gameList.add(new Product(18, "Duke Nukem 3D", "04/21/2015", "PS Vita", 0, "Shooter"));
        gameList.add(new Product(19, "Saints Row IV", "02/20/2015", "XBox/PS4", 0, "RPG"));
        gameList.add(new Product(20, "Call of Duty: Black Ops III", "01/31/2015", "PS4/XBO", 0, "Shooter"));
        gameList.add(new Product(21, "Metal Gear Solid V", "10/29/2015", "PS4", 0, "Shooter"));
        gameList.add(new Product(22, "Age Of Mythology", "11/24/2015", "PC", 0, "RTS"));
        gameList.add(new Product(23, "Fruit Ninja", "11/30/2015", "PC", 0, "Puzzle"));
        gameList.add(new Product(24, "Mirror's Edge Catalyst", "03/23/2016", "PS4", 0, "Adventure"));
        gameList.add(new Product(25, "Tom Clancy's The Division", "04/08/2016", "XBox/PS4/XBO", 0, "Shooter"));
        gameList.add(new Product(26, "Call of Duty: Black Ops III", "07/31/2015", "PS4/XBO", 0, "Shooter"));
        gameList.add(new Product(27, "Resident Evil Zero", "02/05/2016", "PC/XBO/X360/PS4/PS3", 0, "Shooter"));
        gameList.add(new Product(28, "Tetris Ultimate", "01/11/2014", "PS4", 0, "Puzzle"));
        gameList.add(new Product(29, "Chariot", "12/03/2015", "WII U", 0, "Adventure"));

        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);

        int i =0;
        try {
            while (i < gameList.size()) {
                checkDate(gameList.get(i));
                i++;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }


        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("content")) {
                String content = savedInstanceState.getString("content");
                if (content != null) {
                    if (content.equals(SearchListFragment.ARG_ITEM_ID)) {
                        if (fragmentManager.findFragmentByTag(SearchListFragment.ARG_ITEM_ID) != null) {
                            setFragmentTitle(R.string.search);
                            contentFragment = fragmentManager
                                    .findFragmentByTag(SearchListFragment.ARG_ITEM_ID);
                        }
                    }

                    if ((content.equals(FavoriteListFragment.ARG_ITEM_ID))) {
                        if (fragmentManager.findFragmentByTag(FavoriteListFragment.ARG_ITEM_ID) != null) {
                            setFragmentTitle(R.string.favorites);
                            contentFragment = fragmentManager
                                    .findFragmentByTag(FavoriteListFragment.ARG_ITEM_ID);
                        }
                    }
                    if (content.equals(PopularListFragment.ARG_ITEM_ID)) {
                        if (fragmentManager.findFragmentByTag(PopularListFragment.ARG_ITEM_ID) != null) {
                            setFragmentTitle(R.string.mostpopular);
                            contentFragment = fragmentManager
                                    .findFragmentByTag(PopularListFragment.ARG_ITEM_ID);
                        }
                    }
                    if (content.equals(SuggestedListFragment.ARG_ITEM_ID)) {
                        if (fragmentManager.findFragmentByTag(SuggestedListFragment.ARG_ITEM_ID) != null) {
                            setFragmentTitle(R.string.suggested);
                            contentFragment = fragmentManager
                                    .findFragmentByTag(SuggestedListFragment.ARG_ITEM_ID);
                        }
                    }
                    if (content.equals(ThisMonthListFragment.ARG_ITEM_ID)) {
                        if (fragmentManager.findFragmentByTag(ThisMonthListFragment.ARG_ITEM_ID) != null) {
                            setFragmentTitle(R.string.suggested);
                            contentFragment = fragmentManager
                                    .findFragmentByTag(ThisMonthListFragment.ARG_ITEM_ID);
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

    public void checkDate(Product inGame) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String currentDateTimeString = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
        if (currentDateTimeString.compareTo(inGame.getReleaseDate()) == 0) {
            uniqueID++;
            sendNotification(inGame.getGame());
        }
    }


    public void sendNotification(String Name) {

        //Build the notification
        notification.setSmallIcon(R.drawable.popular);
        notification.setTicker("New Release!");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("A new game was released: ");
        notification.setContentText(Name);
        notification.setSubText("Click here to find out more!");

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);


        //Builds notification and issues it
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID, notification.build());


    }


    public void YoutubeButton(View view)
    {
        goToUrl("https://www.youtube.com/watch?v=tBGjx-4_R10");
    }
    public void YoutubePlayer(View view)
    {
        goToUrl("https://www.youtube.com/watch?v=tBGjx-4_R10");
    }
    public void badurl(View view)
    {
        goToUrl("https://wwww.youtube.com/idkbadurl");
    }

    private void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (contentFragment instanceof FavoriteListFragment)  {
            outState.putString("content", FavoriteListFragment.ARG_ITEM_ID);
        }
        if (contentFragment instanceof PopularListFragment) {
            outState.putString("content", PopularListFragment.ARG_ITEM_ID);
        }
        if (contentFragment instanceof SearchListFragment) {
            outState.putString("content", SearchListFragment.ARG_ITEM_ID);
        }
        if (contentFragment instanceof ProductListFragment) {
            outState.putString("content", ProductListFragment.ARG_ITEM_ID);
        }
        if (contentFragment instanceof SuggestedListFragment) {
            outState.putString("content", SuggestedListFragment.ARG_ITEM_ID);
        }
        if (contentFragment instanceof ThisMonthListFragment) {
            outState.putString("content", ThisMonthListFragment.ARG_ITEM_ID);
        }
        super.onSaveInstanceState(outState);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
            case R.id.search:
                setFragmentTitle(R.string.searchforgame);
                searchListFragment = new SearchListFragment();
                switchContent(searchListFragment, SearchListFragment.ARG_ITEM_ID);
                return true;
            case R.id.suggested:
                setFragmentTitle(R.string.suggested);
                suggestedListFragment = new SuggestedListFragment();
                switchContent(suggestedListFragment, SuggestedListFragment.ARG_ITEM_ID);
                return true;
            case R.id.thismonth:
                setFragmentTitle(R.string.thismonth);
                thismonthListFragment = new ThisMonthListFragment();
                switchContent(thismonthListFragment, ThisMonthListFragment.ARG_ITEM_ID);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void switchContent(Fragment fragment, String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        while (fragmentManager.popBackStackImmediate()) ;
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
        ActionBar actionBar = getActionBar();
        actionBar.setTitle(resourceId);
//        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));
//        actionBar.setBackgroundDrawable(colorDrawable);
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

}