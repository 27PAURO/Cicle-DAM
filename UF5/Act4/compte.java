package M3.UF5.Act4;

public interface compte {
    void ingressarDiners(double quantitat);

    void treureDiners(double quantitat) throws Exception;

    void revisioMensual();

    double consultarSaldo();

    void canviarTitular(String nouTitular);

    double getComissio();

    void bloquejarCompte();

    String getNumeroCompte();

    titular getTitular();

    double getSaldo();

	double getComision();

	void bloquearCuenta();

	double veureSaldo();
}

