package M3.UF5.Act1;

public class Rectangle implements Figura {
	private float base;
    private float altura;

    public Rectangle(float base, float altura) {
        this.base = base;
        this.altura = altura;
    }

    public float area() {
        return base * altura;
    }

    public float perimetre() {
        return 2 * (base + altura);
    }

    public String toString() {
        return "Rectangle: area = " + area() + " i permetre = " + perimetre();
    }
}

