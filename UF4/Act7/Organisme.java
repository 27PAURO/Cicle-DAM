package M3.UF4.Act7;

public abstract class Organisme {
	protected String nom;
	protected String familia;
	protected char llum;
	protected double tempMax;
	protected double tempMin;
	protected double phMax;
	protected double phMin;
	
	public Organisme(String nom, String familia, char llum, double tempMax, double tempMin, double phMax,
			double phMin) {
		super();
		this.nom = nom;
		this.familia = familia;
		this.llum = llum;
		this.tempMax = tempMax;
		this.tempMin = tempMin;
		this.phMax = phMax;
		this.phMin = phMin;
	}

	    public String acidesa() {
	        return phMax+"-"+phMin;
	    }

	    public String temperatura() {
	        return tempMax+"-"+tempMin;
	    }

	    public String tipusLlum() {
	        switch (llum) {
	            case 'A':
	                return "Necessitat alta";
	            case 'M':
	                return "Necessitat mitjana";
	            case 'B':
	                return "Necessitat baixa";
	            default:
	                return "Cap llum";
	        }
	    }

		public abstract String dadesMostrar();
	}
