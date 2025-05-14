package app;

import dao.HabitacioDAO;
import dao.ReservaDAO;
import dao.ClientDAO;
import model.Client;
import model.Habitacio;
import java.time.LocalDate;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HabitacioDAO habitacioDAO = new HabitacioDAO();
        ClientDAO clientDAO = new ClientDAO();
        ReservaDAO reservaDAO = new ReservaDAO();

        int opcioPrincipal;
        do {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Gestió Habitacions");
            System.out.println("2. Gestió Clients");
            System.out.println("3. Gestió Reserves");
            System.out.println("0. Exit");
            System.out.print("Selecciona una opcion: ");
            opcioPrincipal = sc.nextInt();
            sc.nextLine();

            switch (opcioPrincipal) {
                case 1:
                    gestioHabitacions(sc, habitacioDAO);
                    break;
                case 2:
                    gestioClients(sc, clientDAO);
                    break;
                case 3:
                	gestioReserves(sc, reservaDAO);
                    break;
                case 0:
                    System.out.println("Adios!");
                    break;
                default:
                    System.out.println("Error: Opcion no valida");
            }
        } while (opcioPrincipal != 0);

        sc.close();
    }

    private static void gestioHabitacions(Scanner sc, HabitacioDAO habitacioDAO) {
        int opcio;
        do {
            System.out.println("\n--- Gestió Habitacions ---");
            System.out.println("1. Añadir habitación");
            System.out.println("2. Eliminar habitación");
            System.out.println("3. Actualizar/Modificar habitación");
            System.out.println("4. Consultar todas las habitaciones");
            System.out.println("0. Volver al menú principal");
            System.out.print("Selecciona una opcion: ");
            opcio = sc.nextInt();
            sc.nextLine();

            switch (opcio) {
                case 1:
                    habitacioDAO.afegirHabitacio(sc);
                    break;
                case 2:
                    System.out.print("Número de habitación a eliminar: ");
                    int numEliminar = sc.nextInt();
                    habitacioDAO.eliminarHabitacio(numEliminar);
                    break;
                case 3:
                    System.out.print("Número de habitación a actualizar: ");
                    int numActualitzar = sc.nextInt();
                    habitacioDAO.actualitzarHabitacio(sc, numActualitzar);
                    break;
                case 4:
                    habitacioDAO.mostrarTotesLesHabitacions();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Error: Opcion no valida");
            }
        } while (opcio != 0);
    }

    private static void gestioClients(Scanner sc, ClientDAO clientDAO) {
        int opcio;
        do {
            System.out.println("\n--- Gestió de Clients ---");
            System.out.println("1. Añadir cliente");
            System.out.println("2. Eliminar cliente");
            System.out.println("3. Actualizar/Modificar cliente");
            System.out.println("4. Consultar todos los clientes");
            System.out.println("0. Volver al menú principal");
            System.out.print("Selecciona una opcion: ");
            opcio = sc.nextInt();
            sc.nextLine();

            switch (opcio) {
                case 1:
                	clientDAO.afegirClient(sc);
                    break;
                case 2:
                    System.out.print("ID del cliente a eliminar: ");
                    int idEliminar = sc.nextInt();
                    clientDAO.eliminarClient(idEliminar);
                    break;
                case 3:
                    System.out.print("ID del cliente a actualizar: ");
                    int idActualitzar = sc.nextInt();
                    sc.nextLine();
                    clientDAO.actualitzarClient(sc, idActualitzar);
                    break;
                case 4:
                    clientDAO.mostrarTotsElsClients();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Error: Opcion no valida");
            }
        } while (opcio != 0);
    }
    
    private static void gestioReserves(Scanner sc, ReservaDAO reservaDAO) {
        int opcio;
        do {
            System.out.println("\n--- Gestió de Reserves ---");
            System.out.println("1. Realizar nueva reserva");
            System.out.println("2. Consultar todas las reservas activas");
            System.out.println("3. Consultar reservas de un cliente específico");
            System.out.println("4. Cancelar una reserva");
            System.out.println("0. Volver al menú principal");
            System.out.print("Selecciona una opcion: ");
            opcio = sc.nextInt();
            sc.nextLine();

            switch (opcio) {
                case 1:
                    reservaDAO.afegirReserva(sc);
                    break;
                case 2:
                    reservaDAO.mostrarReservesActivesEnTaula();
                    break;
                case 3:
                    System.out.print("Introduce el ID del cliente: ");
                    int idClient = sc.nextInt();
                    sc.nextLine();
                    reservaDAO.mostrarReservesPerClientEnTaula(idClient);
                    break;
                case 4:
                    System.out.print("Introduce el ID de la reserva a cancelar: ");
                    int idReserva = sc.nextInt();
                    sc.nextLine();
                    reservaDAO.cancelarReserva(idReserva);
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Error: Opción no válida");
            }
        } while (opcio != 0);
    }


}
