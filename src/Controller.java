import java.util.ArrayList;

public class Controller {
    UI ui = new UI();
    FileHandler fileHandler = new FileHandler();

    ArrayList<Guinniepig> guinniepigs = new ArrayList();

    public void run() {
        addGuinniepig();
        addGuinniepig();
        addGuinniepig();
        saveToFile();
        loadFile();
    }

    public void addGuinniepig() {
        String name = ui.getScanString("Please enter name: ");
        String breed = ui.getScanString("Please enter breed: ");
        int foodInGrams = ui.getScanInt("Please enter grams of food: ");


        guinniepigs.add(new Guinniepig(name, breed, foodInGrams));
    }

    public void saveToFile() {
        fileHandler.saveToFile(guinniepigs);
    }

    public void loadFile() {
        guinniepigs = fileHandler.loadFile();
    }
}