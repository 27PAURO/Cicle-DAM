package M3.UF4.Act4;	

public class habitacion {
    private int id;
    private Categoria categoria;
    private int numCamas;
    private boolean ocupada;

    public habitacion(int id, Categoria categoria, int numCamas) {
        this.id = id;
        this.categoria = categoria;
        this.numCamas = numCamas;
        this.ocupada = false;
    }
    
    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Categoria getCategoria() {
        return categoria;
    }

	public int getID() {
		return id;
	}
}
