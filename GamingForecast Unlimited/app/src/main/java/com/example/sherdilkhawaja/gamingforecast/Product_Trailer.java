package com.example.sherdilkhawaja.gamingforecast;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Product_Trailer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_product_list);

        addButtonClickListener();
    }

    public void addButtonClickListener()
    {
        Button btnNavigator = (Button)findViewById(R.id.button);
        btnNavigator.setOnClickListener(new View.OnClickListener(){

            public void onClick(View arg)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ign.com/videos/2014/12/06/bloodborne-co-op-gameplay-trailer"));
                startActivity(intent);
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
        if (id == R.id.menu_favorites) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
