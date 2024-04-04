package M3.UF4.Act7;

public class Planta extends Organisme {
	protected char tipus;
	
	public Planta(String nom, String familia, char llum, double tempMax, double tempMin, double phMax, double phMin, char tipus) {
		super(nom, familia, llum, tempMax, tempMin, phMax, phMin);
		this.tipus = tipus;
	}
	
	public char getTipus() {
		return tipus;
	}

	public void setTipus(char tipus) {
		this.tipus = tipus;
	}

	public String tipusPlanta() {
	  switch (tipus) {
	      case 'T':
	          return "Tija";
	      case 'B':
	          return "Bulb";
	      case 'A':
	          return "Arrels";
	      default:
	          return "Cap tipus";
	  }
	}
	
	@Override
	public String dadesMostrar() {
		return "Nom: " + super.nom + "\nAcidesa: " + super.acidesa() 
		+ "\nTemperatura: " + super.temperatura() + "\nLlum: " + super.tipusLlum() +"\nTipus: "+ tipusPlanta();
	}
}

