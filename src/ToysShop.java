import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ToysShop extends AbstractShop implements ShopInterface {

    public ToysShop(String nameShop) throws IOException {
        super(nameShop);
        ArrayList<AbstractProduct> products = loadFromFile(this.patch);
        for (AbstractProduct t : products) {
            toysList.add((Toy) t);
        }
    }

    ArrayList<Toy> toysList = new ArrayList<>();
    ArrayList<AbstractProduct> winners = new ArrayList<>();
    String patch = "toysList.txt";
    String winnerList = "winnerToys.txt";

    @Override
    public Boolean isOpen() {
        return this.open;
    }

    @Override
    public void addProduct(AbstractProduct product) {
        toysList.add((Toy) product);
    }

    @Override
    public ArrayList<String> toStringList() {
        ArrayList<String> productList = new ArrayList<>();
        return productList;
    }

    @Override
    public ArrayList<AbstractProduct> getProductList() {
        return new ArrayList<>(toysList);
    }

    @Override
    public ArrayList<AbstractProduct> quiz(int roulette) {

        double weightSum = 0;
        for (Toy t : toysList) {
            weightSum += t.weight();
        }
        Random random = new Random();
        for (int i = 0; i < roulette; i++) {
            double randomNumber = random.nextDouble() * weightSum;
            double currentSum = 0;
            for (Toy t : toysList) {
                currentSum += t.weight();
                if (currentSum >= randomNumber) {
                    if (t.quantity() > 0) {
                        this.winners.add(t);
                        t.setQuantity(t.quantity() - 1);
                        weightSum -= t.weight();
                    }
                    break;
                }
            }
        }
        return this.winners;
    }

    @Override
    public void saveToFile(String filename) throws IOException {
        try (FileWriter writer = new FileWriter(new File(filename))) {
            for (Toy t : toysList) {
                writer.write(t.idProduct() + ", "
                        + t.category() + ", "
                        + t.type() + ", "
                        + t.nameProduct() + ", "
                        + t.price() + ", "
                        + t.discount() + ", "
                        + t.quantity() + ", "
                        + t.weight() + ", "
                        + "\n");
            }
        }
    }

    @Override
    public ArrayList<AbstractProduct> loadFromFile(String filename) throws IOException {
        ArrayList<AbstractProduct> toys = new ArrayList<AbstractProduct>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filename)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] toyData = line.split(", ");
                Toy toy = new Toy(Integer.parseInt(toyData[0]), // id
                        Integer.parseInt(toyData[1]), // category
                        Integer.parseInt(toyData[2]), // type
                        toyData[3], // name toy
                        Float.parseFloat(toyData[4]), // price
                        Integer.parseInt(toyData[5]), // discount
                        Integer.parseInt(toyData[6]), // quality
                        Double.parseDouble(toyData[7])); // weight
                toys.add(toy);
            }
        }
        return toys;
    }

    @Override
    public void setWeight(int idProduct, double weight) {
        if (idProduct < this.toysList.size()) {
            this.toysList.get(idProduct).setWeight(weight);
        }
    }

    @Override
    public AbstractProduct getProduct(int idProduct) {
        if (idProduct < this.toysList.size())
            return this.toysList.get(idProduct);
        return null;
    }

    @Override
    public void winnerTakeAll(int idProduct) {
        if (idProduct < this.toysList.size() && this.toysList.get(idProduct).quantity() > 0) {
            this.toysList.get(idProduct).setQuantity(this.toysList.get(idProduct).quantity() - 1);
            Toy prize = this.toysList.get(idProduct);
            try {
                appendToFile(this.winnerList, prize);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (this.toysList.get(idProduct).quantity() == 0) {
                this.toysList.remove(idProduct);
            }
        }

    }

    @Override
    public void appendToFile(String filename, AbstractProduct product) throws IOException {
        try (FileWriter writer = new FileWriter(new File(filename))) {
            Toy t = (Toy) product;
            writer.append(t.idProduct() + ", "
                    + t.category() + ", "
                    + t.type() + ", "
                    + t.nameProduct()
                    + "\n");
        }
    }
}
