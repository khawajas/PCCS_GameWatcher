package com.example.sherdilkhawaja.gamingforecast;


public class Product {

    private int id;
    private String game;
    private String releaseDate;
    private String platform;


    public Product() {
        super();
    }

    public Product(int id, String game, String releaseDate, String platform) {
        super();
        this.id = id;
        this.game = game;
        this.releaseDate = releaseDate;
        this.platform = platform;
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
}