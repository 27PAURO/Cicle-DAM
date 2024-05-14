package M3.UF5.Act4;

import java.util.ArrayList;

public class banc {
    private String nom;
    private ArrayList<compte> llistaComptes;

    public banc(String nom) {
        this.nom = nom;
        this.llistaComptes = new ArrayList<>();
    }

    public void afegirCompte(compte compte) {
        llistaComptes.add(compte);
    }

    @Override
    public String toString() { 
        StringBuilder resultat = new StringBuilder(); // Crea SB para hacer la cadena de salida
        resultat.append(nom).append("\n"); 
        for (compte compte : llistaComptes) {
            resultat.append(compte).append("\n"); // Agrega la representacion en forma de cadena de cada cuenta al SB
        }
        return resultat.toString(); // Convierte el contenido del SB en una cadena y returnea
    }

    public int getNumComptes() {
        return llistaComptes.size();
    }

    public compte getCompte(int i) { // Segun i obtiene una cuenta
        if (i >= 0 && i < llistaComptes.size()) { // Verifica si i es valido
            return llistaComptes.get(i); // Returnea la cuenta en la posicion i
        } else { 
            return null; // Returnea null para indicar que no se encontró ninguna cuenta correspondiente al i 
        }
    }

	public String getNom() {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	public void revisioMensual() {
		// TODO Esbozo de método generado automáticamente
		
	}	
}
