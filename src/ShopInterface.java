import java.io.IOException;
import java.util.ArrayList;


public interface ShopInterface {
    //public void setWorkDay(Map<Integer, Boolean> workDay);
    //public Map<Integer, Boolean> workDay();
    public Boolean isOpen();
    public void addProduct(AbstractProduct product);
    public ArrayList<String> toStringList();
    public ArrayList<AbstractProduct> getProductList();
    public ArrayList<AbstractProduct> quiz (int roulette);
    public void setWeight(int idProduct, double weight);
    public AbstractProduct getProduct(int idProduct);
    public void winnerTakeAll(int idProduct);
    public void saveToFile(String filename) throws IOException;
    public ArrayList<AbstractProduct> loadFromFile(String filename) throws IOException;
    public void appendToFile(String filename, AbstractProduct product) throws IOException;
}
