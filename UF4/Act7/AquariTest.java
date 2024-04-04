package M3.UF4.Act7;

import java.util.ArrayList;

public class AquariTest {
	
	static String dadesOrganisme(Organisme o) {
		return o.dadesMostrar();
	}
	static ArrayList<Organisme> aquari = new ArrayList<>();
	
    public static void main(String[] args) {
        Peix peix1 = new Peix("Nemo", "peixos", 'A', 12, 14, 6, 7, "Mediterrani", 'A', 34);
        Peix peix2 = new Peix("Dory", "peixos", 'B', 11, 13, 4, 6, "Mediterrani", 'O', 34);
        Peix peix3 = new Peix("Oscar", "peixos", 'M', 2, 10, 3, 5, "Mediterrani", 'F', 34);
        Planta planta1 = new Planta("planta1", "plantes", 'B', 18, 19, 6, 9, 'T');
        Planta planta2 = new Planta("planta2", "plantes", 'M', 15, 17, 7, 8, 'B');
        Planta planta3 = new Planta("planta3", "plantes", 'A', 20, 23, 3, 5, 'A');

        
        aquari.add(peix1);
        aquari.add(peix2);
        aquari.add(peix3);
        aquari.add(planta1);
        aquari.add(planta2);
        aquari.add(planta3);
        
        for (Organisme o : aquari) {
            System.out.println(dadesOrganisme(o));
            System.out.println("********");
        }
    }
}
