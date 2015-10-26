package com.example.sherdilkhawaja.gamingforecast;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
* * Created by Pulkit on 10/15/2015.
 */
public class Banner extends MainActivity  {

    public static final String ARG_ITEM_ID = "Banner";

    NotificationCompat.Builder notification;
    public static int uniqueID = 45612;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Product> gameList = new ArrayList<Product>();
        gameList.add(new Product(1, "Bloodborne: The Old Hunters", "10/26/2015", "PS4", "1"));
        gameList.add(new Product(2, "Kingdom Hearts III", "10/20/2015", "PS4/XBox 1", "2"));
        gameList.add(new Product(3, "Final Fantasy XV", "2/25/2015", "PS4", "3"));
        gameList.add(new Product(4, "Metal Gear Solid V", "2/25/2015", "PS4", "4"));
        gameList.add(new Product(5, "Pokemon Rainbow", "10/25/2016", "3DS", "5"));
        gameList.add(new Product(6, "Call of Duty: Black Ops III", "10/25/2015", "PS4/Xbox 1", "3"));
        gameList.add(new Product(7, "Destiny: The Taken King", "10/24/2015", "PS4/PC", "2"));
        gameList.add(new Product(8, "Fallout 4", "11/10/2015", "PS4/Xbox 1/PC", "1"));


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
        notification.setSmallIcon(R.drawable.heart_red);
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
}


