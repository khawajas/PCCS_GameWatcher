package com.example.sherdilkhawaja.gamingforecast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}