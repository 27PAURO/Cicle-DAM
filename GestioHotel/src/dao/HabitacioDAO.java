package dao;


import model.Habitacio;
import util.ConnexioBD;
import java.sql.*;
import java.util.*;

public class HabitacioDAO {
	public void afegirHabitacio(Scanner sc) {
	    int numero = validarInt(sc, "Número de habitación: ");
	    String tipus = validarString(sc, "Tipo de habitación: ", "[A-Za-z ]+", "No esta permitido caracteres especiales ni numeros");
	    double preu = validarDouble(sc, "Precio per noche: ");
	    boolean disponible = validarBoolean(sc, "Disponible");

	    String sql = "INSERT INTO Habitacio (numeroHabitacio, tipus, preuPerNit, disponible) VALUES (?, ?, ?, ?)";

	    try (Connection con = ConnexioBD.obtenirConnexio(); PreparedStatement ps = con.prepareStatement(sql)) {
	        ps.setInt(1, numero);
	        ps.setString(2, tipus);
	        ps.setDouble(3, preu);
	        ps.setBoolean(4, disponible);
	        ps.executeUpdate();
	        System.out.println("Habitación añadida");
	    } catch (SQLException e) {
	        if (e.getSQLState().startsWith("23")) { // violación de restricciones (pj ejemplo: clave primaria duplicada, etc.)
	            System.out.println("Ya existe una habitación con ese numero"); //esta esta verificacion porque puedes seleccionar el numero de habitacion, en cambio en cliente, es automatico
	        } else {
	            e.printStackTrace();
	        }
	    }
	}

	public void actualitzarHabitacio(Scanner sc, int numeroHabitacio) {
	    String selectSql = "SELECT * FROM Habitacio WHERE numeroHabitacio = ?";
	    try (Connection con = ConnexioBD.obtenirConnexio(); PreparedStatement selectPs = con.prepareStatement(selectSql)) {
	        selectPs.setInt(1, numeroHabitacio);
	        ResultSet rs = selectPs.executeQuery();

	        if (!rs.next()) {
	            System.out.println("No se ha encontrado la habitacion");
	            return;
	        }

	        String tipus = rs.getString("tipus");
	        double preu = rs.getDouble("preuPerNit");
	        boolean disponible = rs.getBoolean("disponible");

	        System.out.println("Información actual:");
	        System.out.println("1. Tipo de habitacion: " + tipus);
	        System.out.println("2. Precio por noche: " + preu);
	        System.out.println("3. Disponible: " + disponible);
	        System.out.println("Selecciona el campo a modificar (1-3) o 0 para salir:");
	        sc.nextLine();
	        int opcio = validarInt(sc, "Opcion: ");


	        switch (opcio) {
	            case 1:
	                tipus = validarString(sc, "Nuevo tipo de habitacion: ", "[A-Za-z ]+", "No esta permitido caracteres especiales ni numeros");
	                break;
	            case 2:
	                preu = validarDouble(sc, "Nuevo precio por noche: ");
	                break;
	            case 3:
	                disponible = validarBoolean(sc, "És disponible?");
	                break;
	            case 0:
	                System.out.println("Error: Actualizacion cancelada");
	                return;
	            default:
	                System.out.println("Opcion no valida");
	                return;
	        }

	        String updateSql = "UPDATE Habitacio SET tipus = ?, preuPerNit = ?, disponible = ? WHERE numeroHabitacio = ?";
	        try (PreparedStatement updatePs = con.prepareStatement(updateSql)) {
	            updatePs.setString(1, tipus);
	            updatePs.setDouble(2, preu);
	            updatePs.setBoolean(3, disponible);
	            updatePs.setInt(4, numeroHabitacio);
	            updatePs.executeUpdate();
	            System.out.println("Habitación actualizada");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public Habitacio obtenirHabitacioPerId(int numeroHabitacio) {
	    String sql = "SELECT * FROM Habitacio WHERE numeroHabitacio = ?";
	    try (Connection con = ConnexioBD.obtenirConnexio(); PreparedStatement ps = con.prepareStatement(sql)) {
	        ps.setInt(1, numeroHabitacio);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            return new Habitacio(
	                rs.getInt("numeroHabitacio"),
	                rs.getString("tipus"),
	                rs.getDouble("preuPerNit"),
	                rs.getBoolean("disponible")
	            );
	        }
	    } catch (SQLException e) {
	        System.out.println("Error al obtener la habitación: " + e.getMessage());
	    }
	    return null;
	}

    private String validarString(Scanner sc, String mensaje, String regex, String mensajeError) {
        String input;
        while (true) {
            System.out.print(mensaje);
            input = sc.nextLine();
            if (input.matches(regex)) {
                return input;
            } else {
                System.out.println(mensajeError);
            }
        }
    }

    private double validarDouble(Scanner sc, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número valido (decimales con punto)");
            }
        }
    }

    private boolean validarBoolean(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje + " (true/false): ");
            String input = sc.nextLine().toLowerCase();
            if (input.equals("true") || input.equals("false")) {
                return Boolean.parseBoolean(input);
            } else {
                System.out.println("Introduce true o false");
            }
        }
    }

    private int validarInt(Scanner sc, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número entero valido");
            }
        }
    }

    public void eliminarHabitacio(int numeroHabitacio) {
        String sql = "DELETE FROM Habitacio WHERE numeroHabitacio = ?";
        try (Connection con = ConnexioBD.obtenirConnexio(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, numeroHabitacio);
            int files = ps.executeUpdate();
            if (files > 0) {
                System.out.println("Habitación eliminada");
            } else {
                System.out.println("No se ha encontrado ninguna habitacion con ese numero");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Habitacio> obtenirTotesLesHabitacions() {
        List<Habitacio> habitacions = new ArrayList<>();
        String sql = "SELECT * FROM Habitacio";

        try (Connection con = ConnexioBD.obtenirConnexio(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Habitacio h = new Habitacio(
                    rs.getInt("numeroHabitacio"),
                    rs.getString("tipus"),
                    rs.getDouble("preuPerNit"),
                    rs.getBoolean("disponible")
                );
                habitacions.add(h);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return habitacions;
    }
    public void mostrarTotesLesHabitacions() {
        List<Habitacio> llista = obtenirTotesLesHabitacions();
        for (Habitacio h : llista) {
            System.out.println("Habitación " + h.getNumeroHabitacio() + " | Tipo de habitacion: " + h.getTipus() +
                " | Precio/Noche: " + h.getPreuPerNit() + " | Disponible: " + h.isDisponible());
        }
    }
    
  
}
