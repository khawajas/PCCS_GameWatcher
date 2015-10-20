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
        gameList.add(new Game("1", "Bloodborne", "10/20/2015", "PS4", "1"));
        gameList.add(new Game("2", "Kingdom Hearts III", "10/20/2015", "PS4/XBox 1", "2"));
        gameList.add(new Game("3", "Final Fantasy XV", "10/21/2015",  "PS4", "3"));
        gameList.add(new Game("4", "Metal Gear Solid V", "2/25/2015", "PS4", "4"));
        gameList.add(new Game("5", "Pokemon Rainbow", "7/25/2016", "3DS", "5"));
        gameList.add(new Game("6", "Call of Duty: Black Ops III", "10/12/2015", "PS4/Xbox 1", "3"));
        gameList.add(new Game("7", "Destiny: The Taken King", "9/20/2015", "PS4/PC", "2"));
        gameList.add(new Game("8", "Fallout 4", "11/10/2015", "PS4/Xbox 1/PC", "1"));

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
        private String gameID,gameName,gamePlatform,gameDate,gameRating;

        Game(String inID, String inName, String inDate, String inPlatform, String inRating)
        {
            this.gameID = inID;
            this.gameName = inName;
            this.gamePlatform = inPlatform;
            this.gameDate = inDate;
            this.gameRating = inRating;
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

        public void setGameRating(String inRating)
        { this.gameRating = inRating; }

        public String getGameRating()
        { return gameRating; }
    }

}

