package M3.UF5.Act4;
public class FonsInversio implements compte {
    private static final double INTERES_POSITIU = 0.34;
    private static final double INTERES_NEGATIU = 0.2;
    private static final double LIMITE_DEUTE = 100000;
    private String numeroCompte;
    private String titular;
    private double saldo;

    public FonsInversio(String numeroCompte, String titular) {
        this.numeroCompte = numeroCompte;
        this.titular = titular;
        this.saldo = 0;
    }

    public FonsInversio(String numeroCompte, String titular, double saldoInicial) {
        this.numeroCompte = numeroCompte;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    @Override
    public void ingressarDiners(double quantitat) {
        saldo += quantitat;
    }

    @Override
    public void treureDiners(double quantitat) throws Exception {
        if (saldo < quantitat) {
            throw new Exception("No hay suficiente saldo para realizar la retirada");
        }
        if (saldo - quantitat < -LIMITE_DEUTE) {
            throw new Exception("Se ha alcanzado el límite de deuda de la cuenta");
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
        if (saldo < 0) {
            double intereses = saldo * INTERES_NEGATIU;
            saldo += intereses;
        } else {
            double intereses = saldo * INTERES_POSITIU;
            saldo += intereses;
        }
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
