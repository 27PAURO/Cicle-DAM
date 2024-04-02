package M3.UF4.Act5;

public class Uf {
	private String codi;
	private String nom;

    public Uf(String codi, String nom) {
        this.codi = codi;
        this.nom = nom;
    }

    
    public String getCodi() {
		return codi;
	}


	public void setCodi(String codi) {
		this.codi = codi;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String toString() {
        return "UF" + codi + ": " + nom;
    }
}