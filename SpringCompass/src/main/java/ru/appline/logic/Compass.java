package ru.appline.logic;

public class Compass
{
    private String north;
    private String east;
    private String south;
    private String west;

    public Compass()
    {
        super();
    }

    public Compass(String north, String east, String south, String west)
    {
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
    }

    public String getNorth() {
        return north;
    }

    public void setNorth(String north) {
        this.north = north;
    }

    public String getEast() {
        return east;
    }

    public void setEast(String east) {
        this.east = east;
    }

    public String getSouth() {
        return south;
    }

    public void setSouth(String south) {
        this.south = south;
    }

    public String getWest() {
        return west;
    }

    public void setWest(String west) {
        this.west = west;
    }
}
