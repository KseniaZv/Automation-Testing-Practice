package second_file;

public class Eurovision {
    private int year;
    private String country;
    private String artist;
    private String song;
    private int points;
    private String hostcity;

    public Eurovision( int year, String country, String artist, String song, int points, String hostcity )    {
        this.year = year;
        this.country = country;
        this.artist = artist;
        this.song = song;
        this.points = points;
        this.hostcity = hostcity;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSong() {
        return song;
    }
    public void setSong(String song) {
        this.song = song;
    }

    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }

    public String getHostcity() {
        return hostcity;
    }
    public void setHostcity(String hostcity) {
        this.hostcity = hostcity;
    }


    @Override
    public String toString() {
        return "winner:: year="+this.year+" country=" + this.country + " artist=" + this.artist + " song=" + this.song +
                " points=" + this.points + " hostcity=" + this.hostcity;
    }

}