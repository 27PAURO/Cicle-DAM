package M3.UF5.Act3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class NotesAlumne {
    public static void main(String[] args) {
        HashMap<String, Double> notesAlumnes = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Nom de l'estudiant o '0' para acabar: ");
            String nom = scanner.nextLine();
            if (nom.equals("0")) {
                break;
            }
            
            System.out.print("Nota de l'estudiant" + ": ");
            double nota = scanner.nextDouble();
            scanner.nextLine();
            
            notesAlumnes.put(nom, nota);
        }
        
        ArrayList<String> nOrdenats = new ArrayList<>(notesAlumnes.keySet());
        Collections.sort(nOrdenats); //https://gist.github.com/javerosanonimos/741feeb10452b675f4a371ddd2cd5f13
        
        System.out.println("\nLista de estudiantes:");
        for (String nom : nOrdenats) {
            double nota = notesAlumnes.get(nom);
            System.out.println(nom+": "+nota);
        }
        
        scanner.close();
    }
}
