public abstract class AbstractProduct {
    public AbstractProduct(int id, 
                           int category, 
                           int type, 
                           String nameProduct,
                           float price, 
                           int discount){
        this.id = id;
        this.category = category;
        this.type = type;
        this.nameProduct = nameProduct;
        this.price = price;
        this.discount = discount;
    }
    private int id; 
    public int idProduct(){
        return this.id;
    };
    private int category;
    public int category() {
        return this.category;
    }
    private int type; 
    public int type() {
        return this.type;
    }
    private String nameProduct;
    public String nameProduct() {
        return this.nameProduct;
    }
    private float price;
    public float price() {
        return this.price;
    }
    private int discount;
    public int discount() {
        return this.discount;
    }
}
