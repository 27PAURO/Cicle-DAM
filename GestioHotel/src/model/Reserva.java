package model;

import java.time.LocalDate;

public class Reserva {
    private int idReserva;
    private Habitacio habitacio;
    private Client client;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;
    private double totalAPagar;

    public Reserva(int idReserva, Habitacio habitacio, Client client, LocalDate dataEntrada, LocalDate dataSortida, double totalAPagar) {
        this.idReserva = idReserva;
        this.habitacio = habitacio;
        this.client = client;
        this.dataEntrada = dataEntrada;
        this.dataSortida = dataSortida;
        this.totalAPagar = totalAPagar;
    }

    // Getters i Setters
    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Habitacio getHabitacio() {
        return habitacio;
    }

    public void setHabitacio(Habitacio habitacio) {
        this.habitacio = habitacio;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSortida() {
        return dataSortida;
    }

    public void setDataSortida(LocalDate dataSortida) {
        this.dataSortida = dataSortida;
    }

    public double getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(double totalAPagar) {
        this.totalAPagar = totalAPagar;
    }
}
