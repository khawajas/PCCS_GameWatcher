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
                "NBA 2K16 - PS4/XB1/PC - 9/29/2015",
                "NBA Live 16 - PS4/XB1/PC - 9/29/2015",
                "Persona 4: Dancing All Night - PS4/XB1/PC - 9/29/2015",
                "Digaea 5 - PS4 - 10/6/2015",
                "Uncharted Collection - PS4 - 10/9/2015",
                "Tales of Zestiria - PS4/PC - 10/20/2015",
                "WWE 2K16 - PS4/XB1/PC - 10/27/2015",
                "Divinity Original Sin - PS4 - 10/27/2015",
                "Call of Duty: Black Ops III - PS4/XB1/PC - 11/6/2015",
                "Star Wars BattleFront - PS4/XB1/PC - 11/17/2015",
                "Sword Art Online: Lost Song - PS4 - 11/17/2015",
                "Deadpool - PS4/XB1 - 11/17/2015",
                "Just Cause 3 - PS4/XB1 - 12/1/2015",
                "Bloodborne: The Old Hunters - PS4 - 12/1/2015"


        };

        //The ListAdapter turns the Array into a List

        final ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                upcomingGames);
        //This tells us where to put the array in which layout
        ListView theListView = (ListView) findViewById(R.id.UpcomingGames);
        //Tells the ListView which data to use
        theListView.setAdapter(theAdapter);

        //when the user clicks, the app notifies the user
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