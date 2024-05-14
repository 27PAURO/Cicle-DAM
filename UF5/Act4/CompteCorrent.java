package M3.UF5.Act4;

public class CompteCorrent implements compte {
    private static final double INTERES = 0.1;
    private static final double COMISSIO = 100;
    private String numeroCompte;
    private titular titular;
    private double saldo;

    public CompteCorrent(String numeroCompte, titular titular) {
        this.numeroCompte = numeroCompte;
        this.titular = titular;
        this.saldo = 0;
    }

    public CompteCorrent(String numeroCompte, titular titular, double saldoInicial) {
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
            throw new Exception("No hi ha suficient saldo per realitzar la retirada");
        }
        saldo -= quantitat;
    }

    @Override
    public void revisioMensual() {
        double interessos = saldo * INTERES;
        saldo += interessos - COMISSIO;
    }

    @Override
    public double consultarSaldo() {
        return saldo;
    }

    @Override
    public void canviarTitular(String nouTitular) {
        titular.setNom(nouTitular);
    }

    @Override
    public double getComissio() {
        return COMISSIO;
    }

    @Override
    public void bloquejarCompte() {
        // Implementación de la lógica para bloquear el cuenta si se supera el límite de deuda
    }

    @Override
    public String getNumeroCompte() {
        return numeroCompte;
    }

    @Override
    public titular getTitular() {
        return titular;
    }

    @Override
    public double getSaldo() {
        return saldo;
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
}