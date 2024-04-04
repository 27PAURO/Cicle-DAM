package M3.UF4.Act8;

public class DiscDur extends Article {
    protected float capacitat;

	public DiscDur(String codi, String descripcio, int unitats, float preuBase, float capacitat) {
		super(codi, descripcio, unitats, preuBase);
        this.capacitat = capacitat;
    }

    public float getCapacitat() {
		return capacitat;
	}

	public void setCapacitat(float capacitat) {
		this.capacitat = capacitat;
	}

	public float calcularPreuFinal() {
        float descompte = 0.1f; 
        return preuBase * capacitat * (1 - descompte); 
    }
	@Override
    protected String prueba() {
        return String.valueOf(this.capacitat);
    }
}