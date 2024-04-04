package M3.UF4.Act6;

public class Estudiant extends Persona {
    protected String cicle;
    protected int curs;
    
	public Estudiant(String nom, String adreça, String cicle, int curs) {
		super(nom, adreça);
		this.cicle = cicle;
		this.curs = curs;
	}

	public String getCicle() {
		return cicle;
	}

	public void setCicle(String cicle) {
		this.cicle = cicle;
	}

	public int getCurs() {
		return curs;
	}

	public void setCurs(int curs) {
		this.curs = curs;
	}

	@Override
	public String toString() {
		return nom + "és un estudiant del cicle " + cicle + " i del curs curs=" + curs ;
	}
    
}
