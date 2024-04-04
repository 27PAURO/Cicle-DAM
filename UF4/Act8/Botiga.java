package M3.UF4.Act8;

import java.util.ArrayList;

public class Botiga {
    private ArrayList<Article> estoc;

    public Botiga() {
        estoc = new ArrayList<>();
    }

    public boolean afegirArticle(Article a) {
        return estoc.add(a);
    }

    public boolean esborrarArticle(Article a) {
        return estoc.remove(a);
    }

    public void llistarEstoc() {
        System.out.println("CODI   DESCRIPCIO    UNITAT    CAP/VEL    PREU");
        System.out.println("*************************************************");

        int nDisc = 0;
        int nCpu = 0;
        for (Article a : estoc) {
            if (a instanceof DiscDur) {
                nDisc++;
            } else if (a instanceof Cpu) {
                nCpu++;
            }
            System.out.printf("%-6s %-14s %-9s %-9s %s%n",
                              a.getCodi(), a.getDescripcio(), a.getUnitats(), a.prueba(), a.calcularPreuFinal());
        }
        
        System.out.println("\nNombre total de disc: " + nDisc);
        System.out.println("Nombre total de CPUs: " + nCpu);
    }

    public void mostrarValor() {
        System.out.println("\nValor total de l'estoc: " + valorEstoc());
    }

    public float valorEstoc() {
        float valorTotal = 0;
        for (Article a : estoc) {
            valorTotal += a.calcularPreuFinal();
        }
        return valorTotal;
    }
}
