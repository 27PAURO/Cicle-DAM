package M3.UF4.Act2;

public class Concessionari {

	private Cotxe [] lista;
	private int num;
	
	public Concessionari() {
		this.num = 0;
		this.lista = new Cotxe[3];
	}
	
	public void nouCotxe(Cotxe c) {
        if (num < lista.length) {
            lista[num] = c;
            num++;
        }
        else {
        	System.out.println("Error");
        }
	}
    

    public Cotxe buscaCotxe(String bastidor) {
        for (Cotxe c : lista) {
        	if (c.getBastidor().equals(bastidor)) {
        		return c;
        	}
        }
        return null;
    }
    public String toString() {
    	String resultat = "Cotxes en concessionari: \n";
    	for (Cotxe c: lista) {
    		if (c != null) {
    			resultat += c.toString() + "\n";
    		}
    	}
    	return resultat;
    }
}