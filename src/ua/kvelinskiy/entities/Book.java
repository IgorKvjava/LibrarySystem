package ua.kvelinskiy.entities;

import java.util.Date;

public class Book {
 	private int id;
    private int idGenre;
    private int numberPages;
    private String title;
    private String author;
    private String publisher;
    private Date publicationDate;
    private Date dateIssue;
    private Date dateReturn;
    private String statuss;
    private String orderStatuss;
    private int idCatalogue;


    public Book() {
    }
//public List<Book> showBooksList(int idGenre)
    public Book(int id, int numberPages, String title, String author, String publisher, Date publicationDate, Date dateIssue, Date dateReturn, String statuss, String orderStatuss) {
        this.id = id;
        this.numberPages = numberPages;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.dateIssue = dateIssue;
        this.dateReturn = dateReturn;
        this.statuss = statuss;
        this.orderStatuss = orderStatuss;
    }

    public Book(int id, int numberPages, String title, String author, String publisher, Date publicationDate) {
        this.id = id;
        this.numberPages = numberPages;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
    }
//public List<Book> showUserBooksList(int idUser)
    public Book(String title, String author, Date dateIssue, Date dateReturn, String statuss, String orderStatuss, int idCatalogue) {
        this.title = title;
        this.author = author;
        this.dateIssue = dateIssue;
        this.dateReturn = dateReturn;
        this.statuss = statuss;
        this.orderStatuss = orderStatuss;
        this.idCatalogue = idCatalogue;
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

    public Date getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(Date dateIssue) {
        this.dateIssue = dateIssue;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }

    public int getIdCatalogue() {
        return idCatalogue;
    }

    public void setIdCatalogue(int idCatalogue) {
        this.idCatalogue = idCatalogue;
    }

    public String getStatuss() {
        return statuss;
    }

    public void setStatuss(String statuss) {
        this.statuss = statuss;
    }

    public String getOrderStatuss() {
        return orderStatuss;
    }

    public void setOrderStatuss(String orderStatuss) {
        this.orderStatuss = orderStatuss;
    }
}
