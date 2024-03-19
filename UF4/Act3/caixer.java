package M3.UF4.Act3;

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
        // Cuentas sin tocar
        System.out.println(bbva.toString());

        compte1.ingressarDiners(2000);
        try {
        	compte4.treureDiners(1000);
        
        }catch (Exception e) {
        	System.out.println(e.getMessage() + "\n");
        }
        
        
        //Cuentas manipuladas
        System.out.println("\nDades del banc després de les operacions:");
        System.out.println(bbva.toString());
    }
}