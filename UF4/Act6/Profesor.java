package M3.UF4.Act6;

import java.util.HashSet;

public class Profesor {
    private HashSet<String> assignatures;

    public Profesor() {
        this.assignatures = new HashSet<>();
    }

    public boolean afegeixAssignatura(String assignatura) {
        return assignatures.add(assignatura);
    }

    public boolean treuAssignatura(String assignatura) {
        return assignatures.remove(assignatura);
    }
}
