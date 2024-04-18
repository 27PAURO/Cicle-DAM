package M3.UF5.Act5;
import java.text.ParseException;

public class UsaEmpresa {

    public static void main(String[] args) throws ParseException {

        Company empresa = new Company();

        User ricard = new UserOffer2("987654321Z", "Ricard", 0.50, 10);

        User carla = new UserOffer1("123456789A", "Carla", 0.50);

        User gerard = new UserOffer2("123456789A", "Gerard", 0.54, 10);

        User martina = new UserOffer3("123789456P", "Martina", 0.54);

        User raul = new UserWithoutOffer("987123456H", "Raul", 0.54);

        empresa.add(ricard);
        empresa.add(carla);
        empresa.add(gerard);
        empresa.add(martina);
        empresa.add(raul);

      //DD/MM/AAAA-hh:mm
        
        Connection c1 = new Connection("01/01/2021-00:01", "01/01/2021-00:09");
        Connection c2 = new Connection("01/01/2021-00:11", "01/01/2021-00:20");

        ricard.add(c1);
        ricard.add(c2);

        carla.add(c1);
        carla.add(c2);

        martina.add(c1);
        martina.add(c2);

        raul.add(c1);
        raul.add(c2);

        System.out.println("CLIENTS:");
        empresa.listUsers();

        ricard.reset();

        System.out.println("\nCLIENTS despues del reset:");
        empresa.listUsers();
    }
}
