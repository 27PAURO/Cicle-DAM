package M3.UF5.Act4;
public class ComptePunts implements compte {
    private static final double PUNTS_PER_6_EUROS = 1;
    private String numeroCompte;
    private String titular;
    private double saldo;
    private int punts;

    public ComptePunts(String numeroCompte, String titular) {
        this.numeroCompte = numeroCompte;
        this.titular = titular;
        this.saldo = 0;
        this.punts = 0;
    }

    public ComptePunts(String numeroCompte, String titular, double saldoInicial) {
        this.numeroCompte = numeroCompte;
        this.titular = titular;
        this.saldo = saldoInicial;
        this.punts = 0;
    }

    @Override
    public void ingressarDiners(double quantitat) {
        saldo += quantitat;
        punts += quantitat / 6; // Se suman puntos por cada 6 euros ingresados
    }

    @Override
    public void treureDiners(double quantitat) throws Exception {
        if (saldo < quantitat) {
            throw new Exception("No hay suficiente saldo para realizar la retirada");
        }
        saldo -= quantitat;
    }

    @Override
    public double consultarSaldo() {
        return saldo;
    }

    @Override
    public void canviarTitular(String nouTitular) {
        titular = nouTitular;
    }

    @Override
    public void revisioMensual() {
        // Implementación de la revisión mensual específica para ComptePunts
    }

	@Override
	public double getComision() {
		// TODO Esbozo de método generado automáticamente
		return 0;
	}

	@Override
	public void bloquearCuenta() {
		// TODO Esbozo de método generado automáticamente
		
	}

	@Override
	public double veureSaldo() {
		// TODO Esbozo de método generado automáticamente
		return 0;
	}

	@Override
	public double getComissio() {
		// TODO Esbozo de método generado automáticamente
		return 0;
	}

	@Override
	public void bloquejarCompte() {
		// TODO Esbozo de método generado automáticamente
		
	}

	@Override
	public String getNumeroCompte() {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	@Override
	public M3.UF5.Act4.titular getTitular() {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	@Override
	public double getSaldo() {
		// TODO Esbozo de método generado automáticamente
		return 0;
	}
}