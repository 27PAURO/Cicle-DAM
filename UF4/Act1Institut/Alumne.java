package clases;

public class Alumne {
    private String nom;
    private int edat;
    private String dni;
    private String email;

    public Alumne(String nom, int edat, String dni, String email) {
        this.nom = nom;
        this.edat = edat;
        this.dni = dni;
        this.email = email;
    }

    
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getEdat() {
		return edat;
	}

	public void setEdat(int edat) {
		this.edat = edat;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return this.nom;
	}
}