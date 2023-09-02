//import java.lang.annotation.Retention;

public class Toy extends AbstractProduct implements ProductInterface{

    public Toy(int id, int category, int type, String nameProduct, float price, int discount, int quantity, double weight) {
        super(id, category, type, nameProduct, price, discount);
        this.weight = weight;
        this.quantity = quantity;
    }
    private double weight;
    private String descriptionToy;
    private String characteristicsToy;
    private int quantity;
    
    public int quantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double weight() {
        return this.weight;
    }

    @Override
    public void setDescription(String description) {
        this.descriptionToy = description;
    }

    @Override
    public String description() {
        return this.descriptionToy;
    }

    @Override
    public void setCharacteristics(String characteristics) {
        this.characteristicsToy = characteristics;
    }

    @Override
    public String characteristics() {
        return this.characteristicsToy;
    }
}
