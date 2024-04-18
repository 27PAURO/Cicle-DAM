package M3.UF5.Act5;

public class UserWithoutOffer extends User {

    public UserWithoutOffer(String dni, String name, double priceMinute) {
        super(dni, name, priceMinute);
    }

    @Override
    public double billAmount() {
        return totalMinutes() * priceMinute;
    }
}

