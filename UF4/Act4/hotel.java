package M3.UF4.Act4;

import java.util.ArrayList;

public class hotel {
    private String nombreHotel;
    private int numEstrellas;
    private ArrayList<habitacion> llistaHabitaciones;

    public hotel(String nombreHotel, int numEstrellas) {
        this.nombreHotel = nombreHotel;
        this.numEstrellas = numEstrellas;
        this.llistaHabitaciones = new ArrayList<>();
    }

    public void agregarHabitacion(habitacion h) {
        llistaHabitaciones.add(h);
    }

    public ArrayList<habitacion> habitacionesDisponibles() {
        ArrayList<habitacion> listaDisponibles = new ArrayList<>();

        for (habitacion h : llistaHabitaciones) {
            if (!h.isOcupada()) {
                listaDisponibles.add(h);
            }
        }
        return listaDisponibles;
    }

    public static int calcularPrecio(habitacion h, int numNoches) {
    	int precio = 0;
        if (h.getCategoria() == Categoria.NORMAL) {
            precio = numNoches * 60;
        } else if (h.getCategoria() == Categoria.LUXE) {
            precio = numNoches * 100;
        } else if (h.getCategoria() == Categoria.SUPERLUXE) {
            precio = numNoches * 200;
        }
        return precio;
    }

    public static void main(String[] args) {
        int numNoches = 3;
        hotel hotel = new hotel("Hotel Miramar", 3);
        habitacion h1 = new habitacion(1, Categoria.NORMAL, 2);
        habitacion h2 = new habitacion(2, Categoria.LUXE, 2);
        habitacion h3 = new habitacion(3, Categoria.SUPERLUXE, 2);
   

        cliente c1 = new cliente("Federico", "12345678A", "1234-5678");
        hotel.agregarHabitacion(h1);
        hotel.agregarHabitacion(h2);
        hotel.agregarHabitacion(h3);
        
        ArrayList<habitacion> disponibles = hotel.habitacionesDisponibles();

        System.out.println("Habitaciones disponibles: ");
        for (habitacion h : disponibles) {
            System.out.println("Habitación " + h.getID() + ": " + h.getCategoria());
        }

        reserva r1 = new reserva("123", c1, h1, numNoches);
        int total = (calcularPrecio(h1, numNoches));
        
        System.out.println("El cliente " + c1.getNombreCliente() + " con DNI: " + c1.getDni() + " recibirá una factura de " + total + "€ en la tarjeta " + c1.getNumeroTarjeta() + "por la habitación " + r1.getHabitacion().getID());
        System.out.println("Total a pagar por la reserva: " + total + "€");
        
        disponibles = hotel.habitacionesDisponibles();
        System.out.println("Habitaciones disponibles: ");
        for (habitacion h : disponibles) {
            System.out.println("Habitación " + h.getID() + ": " + h.getCategoria());
        }
    }
}