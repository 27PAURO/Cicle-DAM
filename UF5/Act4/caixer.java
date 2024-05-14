package M3.UF5.Act4;

import java.util.Scanner;

public class caixer {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        banc bbva = crearBancDeMostra();

        System.out.println("¡Bienvenido al Cajero Automático del " + bbva.getNom() + "!");
        while (true) {
            mostrarMenuPrincipal();
            int opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1:
                    mostrarComptes(bbva);
                    break;
                case 2:
                    ingresarDinero(bbva);
                    break;
                case 3:
                    retirarDinero(bbva);
                    break;
                case 4:
                    consultarSaldo(bbva);
                    break;
                case 5:
                    cambiarTitular(bbva);
                    break;
                case 6:
                    revisarComptes(bbva);
                    break;
                case 7:
                    System.out.println("¡Gracias por utilizar nuestro servicio!");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- Menú Principal ---");
        System.out.println("1. Mostrar cuentas");
        System.out.println("2. Ingresar dinero");
        System.out.println("3. Retirar dinero");
        System.out.println("4. Consultar saldo");
        System.out.println("5. Cambiar titular");
        System.out.println("6. Revisar cuentas");
        System.out.println("7. Salir");
    }

    private static void mostrarComptes(banc banc) {
        System.out.println("\n--- Listado de Cuentas ---");
        for (int i = 0; i < banc.getNumComptes(); i++) {
            System.out.println((i + 1) + ". " + banc.getCompte(i));
        }
    }

    private static void ingresarDinero(banc banc) {
        mostrarComptes(banc);
        int numCuenta = leerEntero("Seleccione el número de cuenta: ") - 1;
        double cantidad = leerDouble("Ingrese la cantidad a depositar: ");
        try {
            banc.getCompte(numCuenta).ingressarDiners(cantidad);
            System.out.println("¡Depósito realizado con éxito!");
        } catch (Exception e) {
            System.out.println("Error al realizar el depósito: " + e.getMessage());
        }
    }

    private static void retirarDinero(banc banc) {
        mostrarComptes(banc);
        int numCuenta = leerEntero("Seleccione el número de cuenta: ") - 1;
        double cantidad = leerDouble("Ingrese la cantidad a retirar: ");
        try {
            banc.getCompte(numCuenta).treureDiners(cantidad);
            System.out.println("¡Retiro realizado con éxito!");
        } catch (Exception e) {
            System.out.println("Error al realizar el retiro: " + e.getMessage());
        }
    }

    private static void consultarSaldo(banc banc) {
        mostrarComptes(banc);
        int numCuenta = leerEntero("Seleccione el número de cuenta: ") - 1;
        double saldo = banc.getCompte(numCuenta).consultarSaldo();
        System.out.println("El saldo actual de la cuenta es: " + saldo + "€");
    }

    private static void cambiarTitular(banc banc) {
        mostrarComptes(banc);
        int numCuenta = leerEntero("Seleccione el número de cuenta: ") - 1;
        String nuevoTitular = leerString("Ingrese el nombre del nuevo titular: ");
        banc.getCompte(numCuenta).canviarTitular(nuevoTitular);
        System.out.println("¡Titular cambiado con éxito!");
    }

    private static void revisarComptes(banc banc) {
        System.out.println("\n--- Revisión Mensual ---");
        banc.revisioMensual();
        System.out.println("¡La revisión mensual se ha realizado con éxito!");
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número entero válido.");
            }
        }
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    }

    private static String leerString(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    private static banc crearBancDeMostra() {
        titular juan = new titular("44556677K", "Juan", "García Martínez", "Carrer Mas de Larrard, 27", "12231221");
        titular pedro = new titular("44556678L", "Pedro", "Lorca Benítez", "Plaça de la Font, 23.2", "121221");
        titular ana = new titular("44556679J", "Ana", "Torres Garriga", "Carrer Masdeu 2", "1212222");

        CompteCorrent compte1 = new CompteCorrent("435-0-2367800", juan);
        CompteCorrent compte2 = new CompteCorrent("435-0-2367805", juan, 3000);
        CompteCorrent compte3 = new CompteCorrent("207-1-0004572", pedro, 8200);
        CompteCorrent compte4 = new CompteCorrent("207-1-0004573", ana, 100);

        banc bbva = new banc("BBVA");
        bbva.afegirCompte(compte1);
        bbva.afegirCompte(compte2);
        bbva.afegirCompte(compte3);
        bbva.afegirCompte(compte4);

        return bbva;
    }
}
