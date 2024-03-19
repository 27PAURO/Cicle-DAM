package M3.UF4.Act3;

public class compte {
    private String numCompte;
    titular titular;
    private double saldo;

    public compte(String numCompte, titular titular) {
        this.numCompte = numCompte;
        this.titular = titular;
        this.saldo = 0;
    }

    public compte(String numCompte, titular titular, double saldoInicial) {
        this.numCompte = numCompte;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void ingressarDiners(int quantitat) {
        saldo += quantitat;
    }

    public void treureDiners(int quantitat) throws Exception {
        if (this.saldo-quantitat < 0) {
            throw new Exception("No tens aquesta quantitat de diners");
        }else {
            this.saldo -= quantitat;
        }
    }


    public double veureSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Compte " + numCompte + ": " + titular + ", Saldo: " + saldo + "€";
    }

	public double getSaldo() {
		// TODO Esbozo de método generado automáticamente
		return saldo;
	}

	public M3.UF4.Act3.titular getTitular() {
		// TODO Esbozo de método generado automáticamente
		return titular;
	}

}
