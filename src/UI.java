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

    public Breed validateBreed() {
        // Fejlhåndtering af indtastning af Breed. Således det skal være af typen Breed.
        Breed validBreed;
        do {
            validBreed = null;
            String breed = scanner.nextLine();
            for (int i = 0; i < Breed.values().length; i++) {
                if (Breed.values()[i].name().equalsIgnoreCase(breed)) {
                    validBreed = Breed.values()[i];
                }
            }
        } while (validBreed == null);
        return validBreed;
    }

    public int getScanInt() {
        int anwser = scanner.nextInt();
        scanner.nextLine();
        return anwser;
    }
}
