package M3.UF5.Act1;

public class Cercle implements Figura {
    private float radi;

    public Cercle(float radi) {
        this.radi = radi;
    }

    public float area() {
        return (float) (Math.PI * radi * radi);
    }

    public float perimetre() {
        return (float) (2 * Math.PI * radi);
    }

    public String toString() {
        return "Cercle: area = " + area() + " i perimetre = " + perimetre();
    }
}
