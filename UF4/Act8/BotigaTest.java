package M3.UF4.Act8;

public class BotigaTest {

	public static void main(String[] args) {

		Botiga botiga = new Botiga();

		botiga.afegirArticle(new DiscDur("dd1","Disc Dur 1",40,1.5f,100));

		botiga.afegirArticle(new Cpu("cpu1","Processador 1",35,0.05f,2500));

		botiga.afegirArticle(new DiscDur("dd2","Disc Dur 2",22,1f,150));

		botiga.afegirArticle(new DiscDur("dd3","Disc Dur 3",11,2f,100));

		botiga.afegirArticle(new Cpu("cpu2","Processador 2",10,0.07f,2800));

		botiga.llistarEstoc();
		botiga.mostrarValor();
	}

}