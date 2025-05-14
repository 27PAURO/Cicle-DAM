package dao;

import model.Client;
import model.Habitacio;
import model.Reserva;
import util.ConnexioBD;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReservaDAO {

    private HabitacioDAO habitacioDAO = new HabitacioDAO();
    private ClientDAO clientDAO = new ClientDAO();

    public void afegirReserva(Scanner sc) {
        System.out.println("=== NUEVA RESERVA ===");

        int numeroHabitacio;
        double preuPerNit = 0.0;

        //validaciones
        //si no existe la habitacion, no se hara la reserva
        while (true) {
        	numeroHabitacio = validarInt(sc, "ID de la habitación: ");
            String sqlHabitacio = "SELECT preuPerNit, disponible FROM Habitacio WHERE numeroHabitacio = ?";
            try (Connection con = ConnexioBD.obtenirConnexio(); PreparedStatement ps = con.prepareStatement(sqlHabitacio)) {
                ps.setInt(1, numeroHabitacio);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    preuPerNit = rs.getDouble("preuPerNit");
                    break;
                } else {
                    System.out.println("No existe ninguna habitación con ese número.");
                }
            } catch (SQLException e) {
                System.out.println("Error al buscar la habitación: " + e.getMessage());
            }
        }

        // valida si no existe el cliente, no se hara la reserva
        int idClient;
        while (true) {
            idClient = validarInt(sc, "ID del cliente: ");
            String sqlClient = "SELECT 1 FROM Client WHERE idClient = ?";
            try (Connection con = ConnexioBD.obtenirConnexio(); PreparedStatement ps = con.prepareStatement(sqlClient)) {
                ps.setInt(1, idClient);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    break;
                } else {
                    System.out.println("No existe ningún cliente con ese ID.");
                }
            } catch (SQLException e) {
                System.out.println("Error al buscar el cliente: " + e.getMessage());
            }
        }

        LocalDate dataEntrada = validarFecha(sc, "Fecha de entrada (yyyy-mm-dd): ");
        LocalDate dataSortida = validarFecha(sc, "Fecha de salida (yyyy-mm-dd): ");
        while (!dataSortida.isAfter(dataEntrada)) {
            System.out.println("La fecha de salida debe ser posterior a la de entrada.");
            dataSortida = validarFecha(sc, "Fecha de salida (yyyy-mm-dd): ");
        }

        String sqlDisponibilidad = "SELECT 1 FROM Reserva WHERE numeroHabitacio = ? AND NOT (dataSortida <= ? OR dataEntrada >= ?)";
        try (Connection con = ConnexioBD.obtenirConnexio(); PreparedStatement ps = con.prepareStatement(sqlDisponibilidad)) {
            ps.setInt(1, numeroHabitacio);
            ps.setDate(2, Date.valueOf(dataEntrada));
            ps.setDate(3, Date.valueOf(dataSortida));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("La habitación ya está reservada en las fechas seleccionadas.");
                return;
            }
        } catch (SQLException e) {
            System.out.println("Error al comprobar disponibilidad: " + e.getMessage());
            return;
        }

        long noches = java.time.temporal.ChronoUnit.DAYS.between(dataEntrada, dataSortida);
        double total = noches * preuPerNit;
        System.out.println("Total a pagar por " + noches + " noches: " + total + " €");

        String sqlInsert = "INSERT INTO Reserva (numeroHabitacio, idClient, dataEntrada, dataSortida, totalAPagar) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConnexioBD.obtenirConnexio(); PreparedStatement ps = con.prepareStatement(sqlInsert)) {
            ps.setInt(1, numeroHabitacio);
            ps.setInt(2, idClient);
            ps.setDate(3, Date.valueOf(dataEntrada));
            ps.setDate(4, Date.valueOf(dataSortida));
            ps.setDouble(5, total);
            ps.executeUpdate();
            System.out.println("Reserva realizada con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al realizar la reserva: " + e.getMessage());
            return;
        }

        //pone la habitacion ocupada Disponible = 0
        String sqlUpdateDisponible = "UPDATE Habitacio SET disponible = 0 WHERE numeroHabitacio = ?";
        try (Connection con = ConnexioBD.obtenirConnexio(); PreparedStatement ps = con.prepareStatement(sqlUpdateDisponible)) {
            ps.setInt(1, numeroHabitacio);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al cambiar la disponibilidad de la habitación: " + e.getMessage());
        }
    }


    public List<Reserva> obtenirTotesLesReservesActives() {
        List<Reserva> reservesActives = new ArrayList<>();
        String sql = "SELECT * FROM Reserva WHERE CURRENT_DATE BETWEEN dataEntrada AND dataSortida";

        try (Connection con = ConnexioBD.obtenirConnexio();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            int contador = 0;

            while (rs.next()) {
                int idReserva = rs.getInt("idReserva");
                int numeroHabitacio = rs.getInt("numeroHabitacio");
                int idClient = rs.getInt("idClient");

                Habitacio habitacio = habitacioDAO.obtenirHabitacioPerId(numeroHabitacio);
                Client client = clientDAO.obtenirClientPerId(idClient);

                if (habitacio != null && client != null) {
                    Reserva reserva = new Reserva(
                            idReserva,
                            habitacio,
                            client,
                            rs.getDate("dataEntrada").toLocalDate(),
                            rs.getDate("dataSortida").toLocalDate(),
                            rs.getDouble("totalAPagar")
                    );
                    reservesActives.add(reserva);
                    contador++;
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener las reservas activas: " + e.getMessage());
        }

        return reservesActives;
    }


    public void mostrarReservesActivesEnTaula() {
        List<Reserva> reservesActives = obtenirTotesLesReservesActives();

        if (reservesActives.isEmpty()) {
            System.out.println("No hay reservas activas");
            return;
        }

        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("| %-5s | %-13s | %-20s | %-12s | %-12s | %-10s |\n",
                          "ID", "Habitació Nº", "Client", "Entrada", "Sortida", "Total €");
        System.out.println("-------------------------------------------------------------------------------------------");

        for (Reserva r : reservesActives) {
            System.out.printf("| %-5d | %-13d | %-20s | %-12s | %-12s | %-10.2f |\n",
                              r.getIdReserva(),
                              r.getHabitacio().getNumeroHabitacio(),
                              r.getClient().getNom(), // o getNomComplet() si tienes nombre + apellido
                              r.getDataEntrada(),
                              r.getDataSortida(),
                              r.getTotalAPagar());
        }

        System.out.println("-------------------------------------------------------------------------------------------");
    }

    public List<Reserva> obtenirReservesPerClient(int idClient) {
        List<Reserva> reserves = new ArrayList<>();
        String sql = "SELECT * FROM Reserva WHERE idClient = ?";
        try (Connection con = ConnexioBD.obtenirConnexio(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idClient);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Habitacio habitacio = habitacioDAO.obtenirHabitacioPerId(rs.getInt("numeroHabitacio"));
                Client client = clientDAO.obtenirClientPerId(idClient);

                if (habitacio != null && client != null) {
                    Reserva reserva = new Reserva(
                            rs.getInt("idReserva"),
                            habitacio,
                            client,
                            rs.getDate("dataEntrada").toLocalDate(),
                            rs.getDate("dataSortida").toLocalDate(),
                            rs.getDouble("totalAPagar")
                    );
                    reserves.add(reserva);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las reservas del cliente: " + e.getMessage());
        }
        return reserves;
    }

    public void mostrarReservesPerClientEnTaula(int idClient) {
        List<Reserva> reservesDelClient = obtenirReservesPerClient(idClient);

        if (reservesDelClient.isEmpty()) {
            System.out.println("El client amb ID " + idClient + " no té reserves.");
            return;
        }

        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("| %-5s | %-13s | %-20s | %-12s | %-12s | %-10s |\n",
                          "ID", "Habitació Nº", "Client", "Entrada", "Sortida", "Total €");
        System.out.println("-------------------------------------------------------------------------------------------");

        for (Reserva r : reservesDelClient) {
            System.out.printf("| %-5d | %-13d | %-20s | %-12s | %-12s | %-10.2f |\n",
                              r.getIdReserva(),
                              r.getHabitacio().getNumeroHabitacio(),
                              r.getClient().getNom(), // o getNomComplet() si lo tienes
                              r.getDataEntrada(),
                              r.getDataSortida(),
                              r.getTotalAPagar());
        }

        System.out.println("-------------------------------------------------------------------------------------------");
    }

    public void cancelarReserva(int idReserva) {
        String sql = "DELETE FROM Reserva WHERE idReserva = ?";
        try (Connection con = ConnexioBD.obtenirConnexio(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idReserva);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Reserva cancelada con éxito.");
            } else {
                System.out.println("No se encontró la reserva con el ID proporcionado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cancelar la reserva: " + e.getMessage());
        }
    }

    //valdiaciones
    private int validarInt(Scanner sc, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número entero válido.");
            }
        }
    }

    private double validarDouble(Scanner sc, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número válido.");
            }
        }
    }

    private LocalDate validarFecha(Scanner sc, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return LocalDate.parse(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Formato incorrecto. Usa yyyy-mm-dd.");
            }
        }
    }
}
