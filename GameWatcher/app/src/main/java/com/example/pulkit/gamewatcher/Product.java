package com.example.pulkit.gamewatcher;


public class Product {

    public int Game;
    public String Name;
    public String Date;
    public String Platform;
    public int Rating;
    public String Genre;

    Product(int gameID, String gameName, String releaseDate, String platform, int gameRating, String genre) {
        this.Game = gameID;
        this.Name = gameName;
        this.Date = releaseDate;
        this.Platform = platform;
        this.Rating = gameRating;
        this.Genre = genre;
    }


    public int getId() {
        return Game;
    }

    public String getGame() {
        return Name;
    }

    public String getReleaseDate() {
        return Date;
    }

    public String getGenre() {
        return Genre;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Game;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (Game != other.Game)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Game: " + Name + "\n" + "Genre: " + Genre + "\n" + "Release Date: "
                + Date + "\n" + "Platform: " + Platform + "";
    }

    public String toString2(){
        return "No information about the game is currently available!";
    }

    public String toString3(){
        return "This game is so popular! Click here to find out why it's trending!";
    }


}