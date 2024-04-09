package M3.UF5.Act1;

public class Quadrat implements Figura{
	private float costat;

    public Quadrat(float costat) {
        this.costat = costat;
    }

    public float area() {
        return costat * costat;
    }

    public float perimetre() {
        return 4 * costat;
    }

    public String toString() {
        return "Quadrat: area = " + area() + " i permetre = " + perimetre();
    }
}