package model;

public class Habitacio {
    private int numeroHabitacio;
    private String tipus;
    private double preuPerNit;
    private boolean disponible;
    
    public Habitacio(int numeroHabitacio, String tipus, double preuPerNit, boolean disponible) {
        this.numeroHabitacio = numeroHabitacio;
        this.tipus = tipus;
        this.preuPerNit = preuPerNit;
        this.disponible = disponible;
    }

    // Getters i Setters
    public int getNumeroHabitacio() {
        return numeroHabitacio;
    }

    public void setNumeroHabitacio(int numeroHabitacio) {
        this.numeroHabitacio = numeroHabitacio;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public double getPreuPerNit() {
        return preuPerNit;
    }

    public void setPreuPerNit(double preuPerNit) {
        this.preuPerNit = preuPerNit;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
