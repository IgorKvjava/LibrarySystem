package ua.kvelinskiy.entities;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String abonnement;
    private String contactInformation;
    private String login;
    private String password;
    private boolean isLibrarian;

    public User() {
    }

    public User(int id, String firstName, String lastName,
                String abonnement, String contactInformation, String login, String password, boolean isLibrarian) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.abonnement = abonnement;
        this.contactInformation = contactInformation;
        this.login = login;
        this.password = password;
        this.isLibrarian = isLibrarian;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAbonnement() {
        return abonnement;
    }

    public void setAbonnement(String abonnement) {
        this.abonnement = abonnement;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsLibrarian() {
        return isLibrarian;
    }

    public void setIsLibrarian(boolean isLibrarian) {
        this.isLibrarian = isLibrarian;
    }
}

