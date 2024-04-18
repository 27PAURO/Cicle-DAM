package M3.UF5.Act5;

public class UserOffer1 extends UserWithOffer{
	
    public UserOffer1(String name, String dni, double priceMinute) {
        super(name, dni, priceMinute);
    }

    @Override

    public double billAmount() {
        double totalMinutes = totalMinutes();
        if (totalMinutes > 3) {
            totalMinutes -= 3; 
        } else {
            totalMinutes = 0; 
        }
        return totalMinutes * priceMinute;
    }


}