package clases;

public class Institut {
    private String nom;
    private Alumne[] llistaAlumnes;
    private int numeroAlumnes;

    
    public String getNom() {
		return nom;
	}
    

	public Alumne[] getLlistaAlumnes() {
		return llistaAlumnes;
	}


	public void setLlistaAlumnes(Alumne[] llistaAlumnes) {
		this.llistaAlumnes = llistaAlumnes;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	public Institut(String nom) {
        this.nom = nom;
        this.llistaAlumnes = new Alumne[100];
        this.numeroAlumnes = 0;
    }
    
    public Institut(String nom, int maximAlumnes) {
        this.nom = nom;
        this.llistaAlumnes = new Alumne[maximAlumnes];
        this.numeroAlumnes = 0;
    }
    
    public void afegirAlumne(Alumne al) {
        if (numeroAlumnes < llistaAlumnes.length) {
            llistaAlumnes[numeroAlumnes] = al;
            numeroAlumnes++;
        }
        else {
        	System.out.println("hay 100 alumnos, no se puede añadir mas");
        }
    }
}