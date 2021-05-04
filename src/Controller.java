import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;

public class Controller {
    UI ui = new UI();
    FileHandler fileHandler = new FileHandler();
    ArrayList<GuineaPig> guineaPigs = new ArrayList<>();

    public void run() {
        Menu menu = new Menu();
        loadFile();

        int choice;
        boolean keepRunning;

        do {
            keepRunning = true;
            menu.showMenu();
            choice = ui.getInt();
            switch (choice) {
                case 1:
                    ui.display("Adding Guinea Pig to list");
                    addGuineaPig();
                    break;
                case 2:
                    ui.display("Removing Guinea Pig from list");
                    removeGuineaPig();
                    break;
                case 3:
                    ui.display("Showing total grams of food needed for current Guinea Pigs.");
                    ui.display(getTotalFood());
                    break;
                case 4:
                    ui.display("Showing Guinea Pigs");
                    sortGineaPig();
                    break;
                case 9:
                    ui.display("Saving to file....");
                    saveToFile();
                    ui.display("Quitting.. See you again!");
                    keepRunning = false;
            }
        } while (keepRunning);

    }

    public void addGuineaPig() {
        ui.display("Please enter name: ");
        String name = ui.getString();
        ui.display("Please enter breed: ");
        Breed breed = ui.getBreed();
        ui.display("Please enter grams of food: ");
        int foodInGrams = ui.getInt();

        guineaPigs.add(new GuineaPig(name, breed, foodInGrams));
    }

    public void removeGuineaPig() {
        ui.display("Which Guinea Pig do you wish to remove?");
        ui.display("Please enter their name here: ");
        String name = ui.getString();
        for (int i = 0; i < guineaPigs.size(); i++) {
            if (guineaPigs.get(i).getName().equals(name)) {
                guineaPigs.remove(guineaPigs.get(i));
                return;
            }
        }
        ui.display("No Guinea Pig goes by this name.");
    }

    public void saveToFile() {
        fileHandler.saveToFile(guineaPigs);
    }

    public void loadFile() {
        guineaPigs = fileHandler.loadFile();
    }

    public void sortGineaPig() {
        //Collections.sort(guineaPigs, new GuineaPigComparator());
        Collections.sort(guineaPigs);
        ui.display(guineaPigs.toString());
        /*
        Collections.sort(guineaPigs);
        ui.printString(guineaPigs.toString());
         */
    }

    public int getTotalFood() {
        int totalGrams = 0;
        for (int i = 0; i < guineaPigs.size(); i++) {
            totalGrams += guineaPigs.get(i).getFoodInGrams();
        }
        return totalGrams;
    }
}