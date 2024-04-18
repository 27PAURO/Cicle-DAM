package M3.UF5.Act5;

import java.util.HashSet;

public class Company {
    private HashSet<User> users;

    public Company() {
        this.users = new HashSet<User>();
    }

    public boolean add(User us) {
        if (users.isEmpty()) {
            users.add(us);
            System.out.println("Hem afegit l'usuari: " + us.getName());
            return true;
        } else {
            for (User u : users) {
                if (u.getDni().equals(us.getDni())) {
                    System.out.println("Dni duplicat!! No hem afegit: " + us.getName());
                    return false;
                } else {
                    users.add(us);
                    System.out.println("Hem afegit l'usuari: " + us.getName());
                    return true;
                }
            }
        }
        return false;
    }

    public void listUsers() {
        for (User u : users) {
            System.out.println("Dni: " + u.getDni() + " Nom: " + u.getName() +
                    " Connexions: " + u.getConnections().size() +
                    " Minuts: " + u.totalMinutes() +
                    " Oferta: " + (u instanceof UserWithOffer ? "Si" : "No") +
                    " Factura: " + String.format("%.2f", u.billAmount()) + "€");
        }
    }
}
