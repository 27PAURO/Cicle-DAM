package M3.UF4.Act5;
import java.util.ArrayList;

public class Modul {
    private String codi;
    private String nom;
    private ArrayList<Uf> ufs;

    public Modul(String codi, String nom) {
        this.codi = codi;
        this.nom = nom;
        this.ufs = new ArrayList<>();
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


	public void afegirUF(Uf uf) {
        ufs.add(uf);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(codi + ": " + nom + "\n");
        for (Uf uf : ufs) {
            sb.append("    " + uf + "\n");
        }
        return sb.toString();
    }
}
