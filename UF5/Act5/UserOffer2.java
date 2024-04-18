package M3.UF5.Act5;

public class UserOffer2 extends UserWithOffer {
    private double discount;

    public UserOffer2(String name, String dni, double priceMinute, double discount) {
        super(name, dni, priceMinute);
        this.discount = discount;
    }

    @Override
    public double billAmount() {
        return (totalMinutes() * priceMinute) * (1 - discount / 100);
    }

}