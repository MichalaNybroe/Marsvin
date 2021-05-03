import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private final File GUINNIEPIGFILE = new File("Guinniepig.txt");
    UI ui = new UI();

    public void saveToFile(ArrayList<Guinniepig> guinniepigs) {
        try {
            FileWriter fileWriter = new FileWriter(GUINNIEPIGFILE);
            for (int i = 0; i < guinniepigs.size(); i++) {
                fileWriter.write(
                        guinniepigs.get(i).getName()
                                + " "
                                + guinniepigs.get(i).getBreed()
                                + " "
                                + guinniepigs.get(i).getFoodInGrams()
                                + "\n"
                );
            }
            fileWriter.close();
        } catch (IOException e) {
            ui.getString("Wait, wait. You are missing a file!");
        }
    }

    public ArrayList<Guinniepig> loadFile() {
        ArrayList<Guinniepig> guinniepigs = new ArrayList<>();

        try {
            Scanner fileReader = new Scanner(GUINNIEPIGFILE);
            while (fileReader.hasNext()) {
                String name = fileReader.next();
                String breed = fileReader.next();
                int foodInGrams = fileReader.nextInt();

                guinniepigs.add(new Guinniepig(name, breed, foodInGrams));
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            ui.getString("Wow, wow. There is no file to load.");
        }
        return guinniepigs;
    }
}
