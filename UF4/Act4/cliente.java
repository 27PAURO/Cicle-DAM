package M3.UF4.Act4;

public class cliente {
	private String nombreCliente;
    private String dni;
    private String numeroTarjeta;

    public cliente(String nombreCliente, String dni, String numeroTarjeta) {
        this.nombreCliente = nombreCliente;
        this.dni = dni;
        this.numeroTarjeta = numeroTarjeta;
    }

	public String getNombreCliente() {
		return nombreCliente;
	}

	public String getDni() {
		return dni;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

}
