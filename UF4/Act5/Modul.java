package M3.UF4.Act5;
import java.util.ArrayList;

public class Modul {
    String codi;
    String nom;
    ArrayList<Uf> ufs;

    public Modul(String codi, String nom) {
        this.codi = codi;
        this.nom = nom;
        this.ufs = new ArrayList<>();
    }

    public void addUF(Uf uf) {
        ufs.add(uf);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(codi).append(": ").append(nom).append(":\n");
        
        for (Uf uf : ufs) {
            sb.append("     ").append(uf).append("\n");
        }
        return sb.toString();
    }
}