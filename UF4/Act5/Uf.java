package M3.UF4.Act5;

public class Uf {
	    String codi;
	    String nom;

	    public Uf(String codi, String nom) {
	        this.codi = codi;
	        this.nom = nom;
	    }

	    public String toString() {
	        return "UF" + codi + ": " + nom;
	    }
	}