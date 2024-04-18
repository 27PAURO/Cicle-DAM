package M3.UF5.Act5;

public class UserOffer3 extends UserWithOffer {
    public UserOffer3(String name, String dni, double priceMinute) {
        super(name, dni, priceMinute);
    }

    @Override
    public double billAmount() {
    	
    	return priceMinute;
    }

}