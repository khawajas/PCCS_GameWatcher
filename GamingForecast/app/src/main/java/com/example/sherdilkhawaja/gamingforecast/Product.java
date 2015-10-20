package com.example.sherdilkhawaja.gamingforecast;


public class Product {

    private int id;
    private String game;
    private String releaseDate;
    private String platform;
    private String rating;

    public Product() {
        super();
    }

    public Product(int id, String game, String releaseDate, String platform, String rating) {
        super();
        this.id = id;
        this.game = game;
        this.releaseDate = releaseDate;
        this.platform = platform;
        this.rating = rating;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getGame() {
        return game;
    }

    public void setName(String name) {
        this.game = game;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getRating() { return rating; }

    public void setRating(String rating) { this.rating = rating; }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
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
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Game: " + game + "\n" + "Release Date: "
                + releaseDate + "\n" + "Platform: " + platform + "";
    }

    public String toString2(){
        return "No information about the game is currently available!";
    }

    public String toString3(){
        return "This game is so popular! Click here to find out why it's trending!";

    }
}