import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private final File GUINNIEPIGFILE = new File("Guinniepig.txt");
    UI ui = new UI();

    public void saveToFile(ArrayList<GuineaPig> guineaPigs) {
        try {
            FileWriter fileWriter = new FileWriter(GUINNIEPIGFILE);
            for (int i = 0; i < guineaPigs.size(); i++) {
                fileWriter.write(
                        guineaPigs.get(i).getName()
                                + " "
                                + guineaPigs.get(i).getBreed()
                                + " "
                                + guineaPigs.get(i).getFoodInGrams()
                                + "\n"
                );
            }
            fileWriter.close();
        } catch (IOException e) {
            ui.printString("Wait, wait. You are missing a file!");
        }
    }

    public ArrayList<GuineaPig> loadFile() {
        ArrayList<GuineaPig> guineaPigs = new ArrayList<>();

        try {
            Scanner fileReader = new Scanner(GUINNIEPIGFILE);
            while (fileReader.hasNext()) {
                String name = fileReader.next();
                String breed = fileReader.next();
                int foodInGrams = fileReader.nextInt();

                guineaPigs.add(new GuineaPig(name, breed, foodInGrams));
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            ui.printString("Wow, wow. There is no file to load.");
        }
        return guineaPigs;
    }
}
