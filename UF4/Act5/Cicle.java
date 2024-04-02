package M3.UF4.Act5;
import java.util.ArrayList;

public class Cicle {
    String codi;
    String nom;


public Cicle(String codi, String nom) {
        this.codi = codi;
        this.nom = nom;
        }

    public String toString() {
        return nom + " (" + codi + ")";
    }


    public static void main(String[] args) {
        Cicle dam = new Cicle("DAM", "Desenvolupament d'aplicacions multiplataforma");
        Cicle asix = new Cicle("ASIX", "Administració de sistemes informàtics en xarxa");

        Modul m1 = new Modul("M1", "Sistemes informàtics");
        Modul m2 = new Modul("M2", "Base de dades");
        Modul m3 = new Modul("M3", "Programació");
        Modul m6 = new Modul("M6", "Accés a dades");
        Modul m7 = new Modul("M7", "Planificació i administració de xarxes");

        m1.addUF(new Uf("1", "Instal·lació, configuració i explotació del sistema informàtic"));
        m1.addUF(new Uf("2", "Gestió de la informació i de recursos en una xarxa"));
        m2.addUF(new Uf("1", "Introducció a les BBDD"));
        m2.addUF(new Uf("2", "Llenguatges SQL: DML i DDL"));
        m3.addUF(new Uf("1", "Programació estructurada"));
        m3.addUF(new Uf("2", "Disseny modular"));
        m6.addUF(new Uf("1", "Persistència en fitxers"));
        m6.addUF(new Uf("2", "Persistència en BDR-BDOR-BDOO"));
        m7.addUF(new Uf("1", "Introducció a les xarxes"));
        m7.addUF(new Uf("2", "Administració de dispositius de xarxa"));

        ArrayList<Modul> damModuls = new ArrayList<>();
        damModuls.add(m1);
        damModuls.add(m2);
        damModuls.add(m3); 
        damModuls.add(m6);

        ArrayList<Modul> asixModuls = new ArrayList<>();
        asixModuls.add(m1);
        asixModuls.add(m2);
        asixModuls.add(m3);
        asixModuls.add(m7);

        System.out.println(dam);
        System.out.println("-----------------------------------------------------------------------");
        for (Modul modul : damModuls) {
            System.out.println(modul);
        }
        System.out.println("-----------------------------------------------------------------------");

        System.out.println(asix);
        System.out.println("-----------------------------------------------------------------------");
        for (Modul modul : asixModuls) {
            System.out.println(modul);
        }
        System.out.println("-----------------------------------------------------------------------");
    }
}