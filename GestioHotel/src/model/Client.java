package model;

import java.time.LocalDate;

public class Client {
    private int idClient;
    private String nom;
    private String cognoms;
    private LocalDate dataNaixement;
    private String email;
    private String telefon;

    public Client(int idClient, String nom, String cognoms, LocalDate dataNaixement, String email, String telefon) {
        this.idClient = idClient;
        this.nom = nom;
        this.cognoms = cognoms;
        this.dataNaixement = dataNaixement;
        this.email = email;
        this.telefon = telefon;
    }

    // Getters i Setters
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public LocalDate getDataNaixement() {
        return dataNaixement;
    }

    public void setDataNaixement(LocalDate dataNaixement) {
        this.dataNaixement = dataNaixement;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
