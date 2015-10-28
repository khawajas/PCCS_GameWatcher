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
import java.util.List;
import java.util.Collections;


/**
* * Created by Pulkit on 10/15/2015.
 */
public class Banner extends MainActivity  {

    public static final String ARG_ITEM_ID = "Banner";

    NotificationCompat.Builder notification;
    public static int uniqueID = 45612;
    List<Product> products;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Product> gameList = new ArrayList<Product>();

        gameList.add(new Product(1, "Bloodborne: The Old Hunters", "11/03/2015", "PS4", 0));
        gameList.add(new Product(2, "Kingdom Hearts III", "10/28/2015", "PS4/XBox 1", 0));
        gameList.add(new Product(3, "Final Fantasy XV", "10/28/2015", "PS4", 0));
        gameList.add(new Product(4, "Metal Gear Solid V", "10/29/2015", "PS4", 0));
        gameList.add(new Product(5, "Pokemon Rainbow", "10/30/2015", "3DS", 0));
        gameList.add(new Product(6, "Call of Duty: Black Ops III", "10/31/2015", "PS4/Xbox 1", 0));
        gameList.add(new Product(7, "Destiny: The Taken King", "11/01/2015", "PS4/PC", 0));
        gameList.add(new Product(8, "Fallout 4", "11/02/2015", "PS4/Xbox 1/PC", 0));
        gameList.add(new Product(9, "No Man's Sky", "11/04/2015", "PS4", 0));
        gameList.add(new Product(10, "Chariot", "11/03/2015", "WII U", 0));
        gameList.add(new Product(11, "Evolve", "11/04/2015", "PC", 0));
        gameList.add(new Product(12, "Citizens of Earth", "11/05/2015", "PS4/XBox 1", 0));
        gameList.add(new Product(13, "Dying Light", "11/06/2015", "PS4", 0));
        gameList.add(new Product(14, "Heroes of Might & Magic III", "11/07/2015", "PS4", 0));
        gameList.add(new Product(15, "Life is Strange", "11/07/2015", "PC", 0));
        gameList.add(new Product(16, "Grey Goo", "11/08/2015", "PC", 0));
        gameList.add(new Product(17, "Pix the Cat", "11/09/2015", "PC", 0));
        gameList.add(new Product(18, "Duke Nukem 3D", "11/10/2015", "PS Vita", 0));
        gameList.add(new Product(19, "Saints Row IV", "11/11/2015", "XBox/PS4", 0));

        //add more games later, just for banner functionality at the moment

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
}


