package M3.UF4.Act5;

public class UsaCicle {

    public static void main(String[] args) {
        Cicle dam = new Cicle("DAM", "Desenvolupament d'aplicacions multiplataforma");
        Cicle asix = new Cicle("ASIX", "Administració de sistemes informàtics en xarxa");

        Modul m1 = new Modul("M1", "Sistemes informàtics");
        Modul m2 = new Modul("M2", "Base de dades");
        Modul m3 = new Modul("M3", "Programació");
        Modul m6 = new Modul("M6", "Accés a dades");
        Modul m7 = new Modul("M7", "Planificació i administració de xarxes");

        m1.afegirUF(new Uf("1", "Instal·lació, configuració i explotació del sistema informàtic"));
        m1.afegirUF(new Uf("2", "Gestió de la informació i de recursos en una xarxa"));
        m2.afegirUF(new Uf("1", "Introducció a les BBDD"));
        m2.afegirUF(new Uf("2", "Llenguatges SQL: DML i DDL"));
        m3.afegirUF(new Uf("1", "Programació estructurada"));
        m3.afegirUF(new Uf("2", "Disseny modular"));
        m6.afegirUF(new Uf("1", "Persistència en fitxers"));
        m6.afegirUF(new Uf("2", "Persistència en BDR-BDOR-BDOO"));
        m7.afegirUF(new Uf("1", "Introducció a les xarxes"));
        m7.afegirUF(new Uf("2", "Administració de dispositius de xarxa"));

        dam.afegirModul(m1);
        dam.afegirModul(m2);
        dam.afegirModul(m3);
        dam.afegirModul(m6);

        asix.afegirModul(m1);
        asix.afegirModul(m2);
        asix.afegirModul(m3);
        asix.afegirModul(m7);

        System.out.println(dam);
        System.out.println(asix);
    }
}
