package ua.kvelinskiy.entities;

public class Genres  {
    private int id;
    private String genre;

    public Genres() {
    }

    public Genres(int id, String genre) {
        this.id = id;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
