package M3.UF4.Act6;

public class EstudiantInternacional extends Estudiant {
	private String pais;

	public EstudiantInternacional(String nom, String adreça, String cicle, int curs, String pais) {
		super(nom, adreça, cicle, curs);
		this.pais = pais;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	
}
