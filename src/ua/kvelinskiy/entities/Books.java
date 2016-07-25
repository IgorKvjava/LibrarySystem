package ua.kvelinskiy.entities;

import java.util.Date;

public class Books {
 	private int id;
    private int idGenre;
    private int numberPages;
    private String title;
    private String author;
    private String publisher;
    private Date publicationDate;

    public Books() {
    }

    public Books(int id, int numberPages, String title, String author, String publisher, Date publicationDate) {
        this.id = id;
        this.numberPages = numberPages;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
    }

    public Books(String title, String author, Date dateIssue, Date dateReturn, String status) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }
}
