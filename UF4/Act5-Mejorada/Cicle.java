package M3.UF4.Act5;
import java.util.ArrayList;

public class Cicle {
    private String codi;
    private String nom;
    private ArrayList<Modul> moduls;

    public Cicle(String codi, String nom) {
        this.codi = codi;
        this.nom = nom;
        this.moduls = new ArrayList<>();
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


	public void afegirModul(Modul modul) {
        moduls.add(modul);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(codi + ": " + nom + "\n");
        sb.append("------------------------------------------------------------------------\n");
        for (Modul modul : moduls) {
            sb.append(modul);
        }
        sb.append("------------------------------------------------------------------------\n");
        return sb.toString();
    }
}

