package clases;

public class UsaInstitut {
    public static void main(String[] args) {
        Institut institut1 = new Institut("Institut A", 3);
        Institut institut2 = new Institut("Institut B");

        Alumne alumne1 = new Alumne("Pau", 18, "123456789A", "pau@gmail.com");
        Alumne alumne2 = new Alumne("Victor", 20, "123456788A", "victor@gmail.com");
        Alumne alumne3 = new Alumne("Alex", 40, "123456787A", "alex@gmail.com");
        Alumne alumne4 = new Alumne("Joan", 30, "123456786A", "joan@gmail.com");
        Alumne alumne5 = new Alumne("Jose", 5, "123456785A", "jose@gmail.com");
        Alumne alumne6 = new Alumne("Angel", 90, "123456784A", "angel@gmail.com");
        institut1.afegirAlumne(alumne1);
        institut1.afegirAlumne(alumne2);
        institut1.afegirAlumne(alumne3);
        institut2.afegirAlumne(alumne4);
        institut2.afegirAlumne(alumne5);
        institut2.afegirAlumne(alumne6);
        
        System.out.println("institut 1: ");
        for (Alumne a: institut1.getLlistaAlumnes()) {
        	System.out.println(a);
        }
        System.out.println("institut 2: "); 
        for (Alumne a: institut2.getLlistaAlumnes()){ 
        	if (a != null){
        		System.out.println(a);
        	}
        }
    }
}