import java.util.ArrayList;
import java.util.Collections;

public class Controller {
    UI ui = new UI();
    FileHandler fileHandler = new FileHandler();
    ArrayList<GuineaPig> guineaPigs = new ArrayList<>();

    public void run() {
        Menu menu = new Menu();
        menu.showMenu();
        //loadFile();

        int choice;
        boolean keepRunning;

        do {
            keepRunning = true;
            choice = ui.getScanInt();
            switch (choice) {
                case 1:
                    ui.printString("Adding Guinea Pig to list");
                    addGuineaPig();
                    break;
                case 2:
                    ui.printString("Removing Guinea Pig from list");
                    removeGuineaPig();
                    break;
                case 3:
                    ui.printString("Showing total grams of food needed for current Guinea Pigs.");
                    ui.printInt(getTotalFood());
                    break;
                case 4:
                    ui.printString("Showing Guinea Pigs");
                    sortGineaPig();
                    break;
                case 9:
                    ui.printString("Saving to file....");
                    saveToFile();
                    ui.printString("Quitting.. See you again!");
                    keepRunning = false;
            }
        } while (keepRunning);

    }

    public void addGuineaPig() {
        ui.printString("Please enter name: ");
        String name = ui.getScanString();
        ui.printString("Please enter breed: ");
        String breed = ui.getScanString();
        ui.printString("Please enter grams of food: ");
        int foodInGrams = ui.getScanInt();

        guineaPigs.add(new GuineaPig(name, breed, foodInGrams));
    }

    public void removeGuineaPig() {
        ui.printString("Which Guinea Pig do you wish to remove?");
        ui.printString("Please enter their name here: ");
        String name = ui.getScanString();
        for (int i = 0; i < guineaPigs.size(); i++) {
            if (guineaPigs.get(i).getName().equals(name)) {
                guineaPigs.remove(guineaPigs.get(i));
                return;
            }
        }
        ui.printString("No Guinea Pig goes by this name.");
    }

    public void saveToFile() {
        fileHandler.saveToFile(guineaPigs);
    }

    public void loadFile() {
        guineaPigs = fileHandler.loadFile();
    }

    public void sortGineaPig() {
        Collections.sort(guineaPigs);
        ui.printString(guineaPigs.toString());
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