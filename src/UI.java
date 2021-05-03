import java.util.Scanner;

public class UI {
    Scanner scanner = new Scanner(System.in);

    public void printString(String message) {
        System.out.println(message);
    }

    public void printInt(int number) {
        System.out.println(number);
    }

    public String getScanString() {
        String anwser = scanner.nextLine();
        return anwser;
    }

    public Breed getBreed() {
        Breed keepRunning;
        do {
            keepRunning = null;
            String breed = scanner.nextLine();
            for (int i = 0; i < Breed.values().length; i++) {
                if (Breed.values()[i].name().equalsIgnoreCase(breed)) {
                    keepRunning = Breed.values()[i];
                }
            }
        } while (keepRunning == null);
        return keepRunning;
    }

    public int getScanInt() {
        int anwser = scanner.nextInt();
        scanner.nextLine();
        return anwser;
    }
}
