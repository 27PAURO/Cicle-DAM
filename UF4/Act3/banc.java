package M3.UF4.Act3;

public class banc {
    private String nom;
    private compte[] llistaComptes;
    private int num;

    public banc(String nom) {
        this.nom = nom;
        this.llistaComptes = new compte[4];
        this.num = 0; 
    }

    public void afegirCompte(compte compte) {
        if (num < llistaComptes.length) {
            llistaComptes[num] = compte;
            num++;
        } else {
            System.out.println("No es pot afegir més comptes");
        }
    }

    @Override
    public String toString() {
        String resultat = nom + "\n";
        for (compte compte : llistaComptes) {
        	if (compte != null) {
        		resultat += compte.toString() + "\n";
        	}
        }
        return resultat;
        
    }
}
