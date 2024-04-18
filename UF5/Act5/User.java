package M3.UF5.Act5;

import java.util.HashSet;
import java.util.Objects;

public abstract class User {
    private String dni;
    private String name;
    protected double priceMinute;
    protected HashSet<Connection> connections;

    public User(String dni, String name, double priceMinute) {
        this.name = name;
        this.dni = dni;
        this.priceMinute = priceMinute;
        this.connections = new HashSet<>();
    }

    public boolean add(Connection c) {
        return connections.add(c);
    }

    public double totalMinutes() {
        double total = 0;
        for (Connection c : connections) {
            total += c.nMinutes();
        }
        return total;
    }

    public abstract double billAmount();

    public void reset() {
        connections.clear();
    }

    public String getName() {
        return name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
		this.dni = dni;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashSet<Connection> getConnections() {
        return connections;
    }


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(connections, other.connections) && Objects.equals(dni, other.dni)
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(priceMinute) == Double.doubleToLongBits(other.priceMinute);
	}
    

    @Override
    public int hashCode() {
        return Objects.hash(dni); //si no poso aixo, no funciona lo de mira repetit el dni
    }
}