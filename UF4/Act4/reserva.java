package M3.UF4.Act4;

public class reserva {
	private String id;
    private cliente cliente;
    private habitacion habitacion;
    private int numNoches;

    public reserva(String id, cliente cliente, habitacion habitacion, int numNoches) {
        this.id = id;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.setNumNoches(numNoches);
        habitacion.setOcupada(true);
    }
    
	public int getNumNoches() {
		return numNoches;
	}

	public void setNumNoches(int numNoches) {
		this.numNoches = numNoches;
	}

	public habitacion getHabitacion() {
		return habitacion;
	}


}
