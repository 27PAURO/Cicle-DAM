package dao;

import model.Client;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import util.ConnexioBD;
import java.sql.*;
import java.util.*;

public class ClientDAO {
    private List<Client> clients = new ArrayList<>();
    private int nextId = 1;

    public void afegirClient(Scanner sc) {
        String sqlInsert = "INSERT INTO CLIENT (NOM, COGNOMS, DATANAIXEMENT, EMAIL, TELEFON) VALUES (?, ?, ?, ?, ?)";
        String sqlComprobarMail = "SELECT COUNT(*) FROM CLIENT WHERE EMAIL = ?";

        String nom = validarCampo(sc, "Nombre: ", "[A-Za-z]+", "El nombre solo puede contener letras");
        String cognoms = validarCampo(sc, "Apellidos: ", "[A-Za-z]+", "Los apellidos solo pueden contener letras");

        String email;
        while (true) {
            email = validarCampo(sc, "Email: ", "^[A-Za-z0-9+_.-]+@(.+)$", "El correo electronico no es valido");

            // Comprueba si ya existe en la BD el mail
            try (Connection con = ConnexioBD.obtenirConnexio();
                 PreparedStatement checkPs = con.prepareStatement(sqlComprobarMail)) {
                checkPs.setString(1, email);
                ResultSet rs = checkPs.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    System.out.println("Ese email ya está registrado. Introduce otro");
                } else {
                    break; // email valido y no duplicado, siguiente
                }
            } catch (SQLException e) {
                System.out.println("Error al comprobar el email");
                e.printStackTrace();
                return;
            }
        }

        String telefon = validarCampo(sc, "Telefono: ", "\\d{9}", "El número de telefono debe tener 9 dígitos");
        LocalDate dataNaixement = validarFecha(sc, "Fecha de nacimiento (yyyy-mm-dd): ");

        try (Connection con = ConnexioBD.obtenirConnexio(); PreparedStatement ps = con.prepareStatement(sqlInsert)) {
            ps.setString(1, nom);
            ps.setString(2, cognoms);
            ps.setDate(3, java.sql.Date.valueOf(dataNaixement));
            ps.setString(4, email);
            ps.setString(5, telefon);
            ps.executeUpdate();
            System.out.println("Cliente añadido ");
        } catch (SQLException e) {
            System.out.println("Error al añadir el cliente");
            e.printStackTrace();
        }
    }

    
    public void actualitzarClient(Scanner sc, int idClient) {
        String selectSql = "SELECT * FROM CLIENT WHERE IDCLIENT = ?";
        try (Connection con = ConnexioBD.obtenirConnexio();
             PreparedStatement selectPs = con.prepareStatement(selectSql)) {
            selectPs.setInt(1, idClient);
            ResultSet rs = selectPs.executeQuery();

            if (!rs.next()) {
                System.out.println("No se ha encontrado el cliente");
                return;
            }

            String nom = rs.getString("NOM");
            String cognoms = rs.getString("COGNOMS");
            LocalDate dataNaixement = rs.getDate("DATANAIXEMENT").toLocalDate();
            String email = rs.getString("EMAIL");
            String telefon = rs.getString("TELEFON");

            System.out.println("Información actual:");
            System.out.println("1. Nombre: " + nom);
            System.out.println("2. Apellidos: " + cognoms);
            System.out.println("3. Fecha de nacimiento: " + dataNaixement);
            System.out.println("4. Email: " + email);
            System.out.println("5. Telefono: " + telefon);
            int opcion = validarInt(sc, "Selecciona el campo a modificar (1-5) o 0 para salir: ");

            switch (opcion) {
                case 1:
                    nom = validarCampo(sc, "Nuevo nombre: ", "[A-Za-z]+", "El nombre solo puede contener letras");
                    break;
                case 2:
                    cognoms = validarCampo(sc, "Nuevos apellidos: ", "[A-Za-z ]+", "Los apellidos solo pueden contener letras");
                    break;
                case 3:
                    dataNaixement = validarFecha(sc, "Nueva fecha de nacimiento (yyyy-mm-dd): ");
                    break;
                case 4:
                    email = validarCampo(sc, "Nuevo email: ", "^[A-Za-z0-9+_.-]+@(.+)$", "El correo electronico no es valido");
                    break;
                case 5:
                    telefon = validarCampo(sc, "Nuevo telefono: ", "\\d{9}", "El número de telefono debe tener 9 dígitos");
                    break;
                case 0:
                    System.out.println("Error al modificar el cliente");
                    return;
                default:
                    System.out.println("Opcion no valida");
                    return;
            }

            String updateSql = "UPDATE CLIENT SET NOM = ?, COGNOMS = ?, DATANAIXEMENT = ?, EMAIL = ?, TELEFON = ? WHERE IDCLIENT = ?";
            try (PreparedStatement updatePs = con.prepareStatement(updateSql)) {
                updatePs.setString(1, nom);
                updatePs.setString(2, cognoms);
                updatePs.setDate(3, java.sql.Date.valueOf(dataNaixement));
                updatePs.setString(4, email);
                updatePs.setString(5, telefon);
                updatePs.setInt(6, idClient);
                updatePs.executeUpdate();
                System.out.println("Cliente actualizado");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private String validarCampo(Scanner sc, String mensaje, String regex, String mensajeError) {
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

    private LocalDate validarFecha(Scanner sc, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return LocalDate.parse(sc.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Formato incorrecto. Usa el formato yyyy-mm-dd");
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

    public void eliminarClient(int idClient) {
        String sql = "DELETE FROM CLIENT WHERE IDCLIENT = ?";
        try (Connection con = ConnexioBD.obtenirConnexio(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idClient);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cliente eliminado");
            } else {
                System.out.println("Cliente no encontrado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarTotsElsClients() {
        String sql = "SELECT * FROM CLIENT";
        try (Connection con = ConnexioBD.obtenirConnexio();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ResultSet rs = ps.executeQuery();

            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-20s | %-20s | %-15s | %-25s | %-15s |\n",
                              "ID Client", "Nom", "Cognoms", "Naixement", "Email", "Telèfon");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("| %-10d | %-20s | %-20s | %-15s | %-25s | %-15s |\n",
                    rs.getInt("IDCLIENT"),
                    rs.getString("NOM"),
                    rs.getString("COGNOMS"),
                    rs.getDate("DATANAIXEMENT").toLocalDate(),
                    rs.getString("EMAIL"),
                    rs.getString("TELEFON"));
            }

            System.out.println("------------------------------------------------------------------------------------------------------------------------------");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Client obtenirClientPerId(int idClient) {
        String selectSql = "SELECT * FROM CLIENT WHERE IDCLIENT = ?";
        
        try (Connection con = ConnexioBD.obtenirConnexio();
             PreparedStatement ps = con.prepareStatement(selectSql)) {
            
            ps.setInt(1, idClient);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("No se ha encontrado el cliente");
                return null;
            }

            String nom = rs.getString("NOM");
            String cognoms = rs.getString("COGNOMS");
            LocalDate dataNaixement = rs.getDate("DATANAIXEMENT").toLocalDate();
            String email = rs.getString("EMAIL");
            String telefon = rs.getString("TELEFON");

            Client client = new Client(idClient, nom, cognoms, dataNaixement, email, telefon);
            client.setIdClient(idClient);
            client.setNom(nom);
            client.setCognoms(cognoms);
            client.setDataNaixement(dataNaixement);
            client.setEmail(email);
            client.setTelefon(telefon);

            return client;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }


}
