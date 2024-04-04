package M3.UF4.Act8;

public abstract class Article {
	protected String codi;
	protected String descripcio;
	protected int unitats;
	protected float preuBase;
	
	public Article(String codi, String descripcio, int unitats, float preuBase) {
		super();
		this.codi = codi;
		this.descripcio = descripcio;
		this.unitats = unitats;
		this.preuBase = preuBase;
	}

	protected abstract float calcularPreuFinal();
	protected abstract String prueba();
	
	public String getCodi() {
		return codi;
	}

	public void setCodi(String codi) {
		this.codi = codi;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	public int getUnitats() {
		return unitats;
	}

	public void setUnitats(int unitats) {
		this.unitats = unitats;
	}

	public float getPreuBase() {
		return preuBase;
	}

	public void setPreuBase(float preuBase) {
		this.preuBase = preuBase;
	}
	
}
