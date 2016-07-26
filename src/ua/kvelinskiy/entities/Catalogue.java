package ua.kvelinskiy.entities;

import java.util.Date;

public class Catalogue {

    private int id;
    private int idBook;
    private int idUser;
    private String status;
    private String orderStatus;
    private Date dateIssue;
    private Date dateReturn;

    public Catalogue() {
    }
    //CheckedBooksCommand catalogueList.addAll(catalogueDao.getCatalogueListUser(idUser));
    public Catalogue(int id, int idBook, int idUser, String status, String orderStatus, Date dateIssue, Date dateReturn) {
        this.id = id;
        this.idBook = idBook;
        this.idUser = idUser;
        this.status = status;
        this.orderStatus = orderStatus;
        this.dateIssue = dateIssue;
        this.dateReturn = dateReturn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

}
