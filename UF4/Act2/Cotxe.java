package M3.UF4.Act2;

public class Cotxe {

    private String bastidor;
    private String marca;
    private String model;

    public Cotxe(String bastidor) {
        this.bastidor = bastidor;
    }
    
    //Marca
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    //Model
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    //Bastidor
    public String getBastidor() {
        return bastidor;
    }


    //stringtostring
    public String toString() {
        return "Cotxe: " + marca + " Model: " + model + " Bastidor: " + bastidor;
    }
}
