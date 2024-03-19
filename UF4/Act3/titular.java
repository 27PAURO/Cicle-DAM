package M3.UF4.Act3;

public class titular {
    private String dni;
    private String nom;
    private String cognoms;

    public titular(String dni, String nom, String cognoms) {
        this.dni = dni;
        this.nom = nom;
        this.cognoms = cognoms;
    }

    public String toString() {
        return nom + " " + cognoms + " (DNI: " + dni + ")";
    }
}