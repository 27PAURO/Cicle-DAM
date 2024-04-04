package M3.UF4.Act7;

public class Peix extends Organisme {
    protected String procedencia;
    protected char dieta;
    protected double longitud;

    public Peix(String nom, String familia, char llum, double tempMax, double tempMin, double phMax, double phMin,
                String procedencia, char dieta, double longitud) {
        super(nom, familia, llum, tempMax, tempMin, phMax, phMin);
        this.procedencia = procedencia;
        this.dieta = dieta;
        this.longitud = longitud;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public char getDieta() {
        return dieta;
    }

    public double getLongitud() {
        return longitud;
    }

    public String tipusDieta() {
        switch (dieta) {
            case 'A':
                return "Algues";
            case 'O':
                return "Omnívor";
            case 'F':
                return "Fulles";
            default:
                return "Cap dieta";
        }
    }

	@Override
	public String dadesMostrar() {
		return "Nom: " + super.nom + "\nAcidesa: " + super.acidesa() 
		+ "\nTemperatura: " + super.temperatura() + "\nLlum: " + super.tipusLlum() +"\nLongitud: "+ longitud + "\nDieta: "+ tipusDieta();
	}
	}