import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        ToysShop shop = new ToysShop("Children world");
        String patch = "toysList.txt";
        //ArrayList<AbstractProduct> waitingList = new ArrayList<>();
        if (shop.isOpen()) {
            ArrayList<AbstractProduct> waitingList = shop.quiz(10);
            shop.setWeight(1, 22); // изменение веса по индексу
            Toy tempToy = (Toy)shop.getProduct(waitingList.size() - 1); // получение призовой игрушки из спика по индексу
            shop.addProduct(new Toy(shop.toysList.size(), EnumirateToys.Category.Constructor.ordinal(),
            EnumirateToys.Type.Interactive.ordinal(),
            "New toys", 
            700, 
            0, 
            2, 
            10.0)); //добавление новой игрушки
            System.out.println("weight = " + tempToy.weight() + '\n' + "Name toy = " + tempToy.nameProduct() + '\n' + "Price toy = " + tempToy.price());
            shop.winnerTakeAll(waitingList.size() - 1); // сохранение в отдельный файл полученой игрушки
            shop.saveToFile(patch);
        }
    }
}