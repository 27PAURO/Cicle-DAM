package M3.UF5.Act4;

public class titular {
    private String dni;
    private String nom;
    private String cognoms;
    private String adreca;
    private String telefon;

    public titular(String dni, String nom, String cognoms, String adreca, String telefon) {
        this.dni = dni;
        this.nom = nom;
        this.cognoms = cognoms;
        this.adreca = adreca;
        this.telefon = telefon;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return nom + " " + cognoms + " (DNI: " + dni + ")" + "\n" +
                "Adreça: " + adreca + "\n" +
                "Telèfon: " + telefon;
    }
}
