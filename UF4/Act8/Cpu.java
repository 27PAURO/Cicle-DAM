package M3.UF4.Act8;

public class Cpu extends Article {
    protected float velocitat;

    public Cpu(String codi, String descripcio, int unitats, float preuBase, float velocitat) {
    	super(codi, descripcio, unitats, preuBase);
        this.velocitat = velocitat;
    }

    public float getVelocitat() {
		return velocitat;
	}

	public void setVelocitat(float velocitat) {
		this.velocitat = velocitat;
	}

	
	public float calcularPreuFinal() {
        return this.preuBase * this.velocitat;
    }
	@Override
    protected String prueba() {
        return String.valueOf(this.velocitat);
    }
}
