package com.example.sherdilkhawaja.gamingforecast;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.text.DateFormat;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Pulkit on 10/15/2015.
 */
public class Banner extends MainActivity  {

    NotificationCompat.Builder notification;
    private static int uniqueID = 45612;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Game> gameList = new ArrayList<Game>();
        gameList.add(new Game("1","Metal Gear","PS4","10/16/2015"));
        gameList.add(new Game("2", "Skyrim", "XBox", "11/16/2015"));
        gameList.add(new Game("3", "Fallout 4", "PC", "10/15/2015"));

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

    public void checkDate(Game inGame) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String currentDateTimeString = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
            if (currentDateTimeString.compareTo(inGame.getGameDate()) == 0) {
                uniqueID++;
                sendNotification(inGame.getGameName(), inGame.getGamePlatform());
            }
        }


    public void sendNotification(String inName, String inPlatform) {

        //Build the notification
        notification.setSmallIcon(R.drawable.heart_red);
        notification.setTicker("New Release!");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle(inName + " has been released!");
        notification.setContentText("Click here to find out more!");

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        //Builds notification and issues it
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID, notification.build());

    }


    class Game
    {
        private String gameID,gameName,gamePlatform,gameDate;

        Game(String inID, String inName, String inPlatform, String inDate)
        {
            this.gameID = inID;
            this.gameName = inName;
            this.gamePlatform = inPlatform;
            this.gameDate = inDate;
        }

        public String getGameID()
        { return gameID; }

        public void setGameID(String inID)
        { this.gameID = inID; }

        public String getGameName()
        { return gameName; }

        public void setGameName(String inName)
        { this.gameName = inName; }

        public String getGamePlatform()
        { return gamePlatform; }

        public void setGamePlatform(String inPlatform)
        { this.gamePlatform = inPlatform; }

        public String getGameDate()
        { return gameDate; }

        public void setGameDate(String inDate)
        { this.gameDate = inDate; }
    }

}

