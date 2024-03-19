package M3.UF4.Act3;
import java.util.Scanner;

public class caixer {
    public static void main(String[] args) {
        titular juan = new titular("44556677K", "Juan", "Garcia Martínez");
        titular pedro = new titular("44556678L", "Pedro", "Lorca Benítez");
        titular ana = new titular("44556679J", "Ana", "Torres Garriga");

        compte compte1 = new compte("435-0-2367800", juan);
        compte compte2 = new compte("435-0-2367805", juan, 3000);
        compte compte3 = new compte("207-1-0004572", pedro, 8200);
        compte compte4 = new compte("207-1-0004573", ana, 100);

        banc bbva = new banc("BBVA");
        bbva.afegirCompte(compte1);
        bbva.afegirCompte(compte2);
        bbva.afegirCompte(compte3);
        bbva.afegirCompte(compte4);

        MenuCajero(bbva);
    }

    public static void MenuCajero(banc bbva) {
        Scanner scanner = new Scanner(System.in);
        int numCuentas = bbva.getNumComptes();
        String[] dnis = new String[numCuentas];
        double[] saldos = new double[numCuentas];
        compte[] cuentas = new compte[numCuentas];

        for (int i = 0; i < numCuentas; i++) {
            compte cuenta = bbva.getCompte(i);
            dnis[i] = cuenta.getTitular().getDni();
            saldos[i] = cuenta.getSaldo();
            cuentas[i] = cuenta;
        }

        while (true) {
            System.out.println("MENU CAIXER");
            System.out.println("1. Buscar DNI");
            System.out.println("0. Sortir");
            System.out.print("Elige una opcion: ");
            int opcio = scanner.nextInt();
            scanner.nextLine(); // Limpiar scanner

            switch (opcio) {
	            case 1:
	                System.out.print("Introduce DNI: ");
	                String dni = scanner.nextLine();
	                
	                int index = buscarDNI(dni, dnis);
	                
	                if (index != -1) {
	                    System.out.println("DNI encontrado");
	                    mostrarCuentas(cuentas, dni);
	                    System.out.print("Elige una cuenta para hacer operaciones (escribe el numero 1-2-3...): ");
	                    int cuentaSeleccionada = scanner.nextInt();
	                    scanner.nextLine(); // Limpiar scanner
	                    if (cuentaSeleccionada >= 0 && cuentaSeleccionada < cuentas.length) {
	                        double saldo = cuentas[cuentaSeleccionada].getSaldo();
	                        menuOperacions(saldo, scanner);
	                    } else {
	                        System.out.println("Número de cuenta no válido.");
	                    }
	                } else {
	                    System.out.println("DNI no encontrado");
	                }
	                break;

                case 0:
                    System.out.println("Adios");
                    scanner.close(); 
                    return;
                    
                default:
                    System.out.println("Error de opcion, elige");
            }
        }
    }

    public static int buscarDNI(String dni, String[] dnis) {
        for (int i = 0; i < dnis.length; i++) {
            if (dnis[i].equals(dni)) {
                return i;
            }
        }
        return -1;
    }
    
    public static void mostrarCuentas(compte[] cuentas, String dni) {
        System.out.println("Cuentas asociadas:");
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i].getTitular().getDni().equals(dni)) {
                System.out.println(i + ". " + cuentas[i]);
            }
        }
    }
    
    public static void menuOperacions(double saldo, Scanner scanner) {
        while (true) {
            System.out.println("\nOPERACIONS");
            System.out.println("1. Ver saldo");
            System.out.println("2. Ingresar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");

            System.out.print("Escoge una opcion: ");
            int opcio = scanner.nextInt();
            scanner.nextLine(); // Limpiar scanner

            switch (opcio) {
                case 1:
                    System.out.println("Saldo actual es: " + saldo + "€");
                    break;
                case 2:
                    System.out.print("Introduce la cantidad a ingresar: ");
                    double ingreso = scanner.nextDouble();
                    saldo += ingreso;
                    break;
                case 3:
                    System.out.print("Introduce la cantidad a retirar: ");
                    double retirada = scanner.nextDouble();
                    if (retirada <= saldo) {
                        saldo -= retirada;
                    } else {
                        System.out.println("No hay suficiente dinero para retirar");
                    }
                    break;
                case 4:
                    System.out.println("Salir del menu de operaciones");
                    return;
                default:
                    System.out.println("Error opcin no valida.");
            }
        }
    }
}
