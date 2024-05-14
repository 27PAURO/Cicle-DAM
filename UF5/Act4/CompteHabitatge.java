package M3.UF5.Act4;
public class CompteHabitatge implements compte {
    private static final double INTERES = 0.2;
    private String numeroCompte;
    private double saldo;

    public CompteHabitatge(String numeroCompte, String titular) {
        this.setNumeroCompte(numeroCompte);
        this.setTitular(titular);
        this.saldo = 0;
    }

    public CompteHabitatge(String numeroCompte, String titular, double saldoInicial) {
        this.setNumeroCompte(numeroCompte);
        this.setTitular(titular);
        this.saldo = saldoInicial;
    }

    @Override
    public void ingressarDiners(double quantitat) {
        saldo += quantitat;
    }

    @Override
    public void treureDiners(double quantitat) throws Exception {
        throw new Exception("No se pueden retirar fondos de una cuenta de CompteHabitatge");
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void canviarTitular(String nouTitular) {
        setTitular(nouTitular);
    }

    @Override
    public void revisioMensual() {
        double intereses = saldo * INTERES;
        saldo += intereses;
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
	public M3.UF5.Act4.titular getTitular() {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	@Override
	public double getSaldo() {
		// TODO Esbozo de método generado automáticamente
		return 0;
	}

	public String getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public void setTitular(String titular) {
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
}
