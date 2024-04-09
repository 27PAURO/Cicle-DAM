package M3.UF5.Act1;

import java.util.ArrayList;

public class UsaFigura {

    public static void main(String[] args) {
        ArrayList<Figura> llistaFigures = new ArrayList<>();

        Figura quad = new Quadrat(3.5f);
        Figura circ = new Cercle(3.5f);
        Figura rect = new Rectangle(2.25f, 2.55f);

        llistaFigures.add(quad);
        llistaFigures.add(circ);
        llistaFigures.add(rect);

        for (Figura figura : llistaFigures) {
            System.out.println(figura);
        }
    }
}

