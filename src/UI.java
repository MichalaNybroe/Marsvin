import java.util.Scanner;

public class UI {
    Scanner scanner = new Scanner(System.in);

    public void display(String message) {
        System.out.println(message);
    }

    public void display(int number) {
        System.out.println(number);
    }

    public String getString() {
        String anwser = scanner.nextLine();
        return anwser;
    }

    public int getInt() {
        int anwser = scanner.nextInt();
        scanner.nextLine();
        return anwser;
    }

    public Breed getBreed() {
        Breed breed = null;
        String input;
        while (breed == null) {
            input = scanner.nextLine();
            breed = validateBreed(input);
        }
        return breed;
    }

    // Fejlhåndtering af indtastning af Breed. Således det skal være af typen Breed.
    private Breed validateBreed(String breed) {
        for (int i = 0; i < Breed.values().length; i++) {
            if (Breed.values()[i].name().equalsIgnoreCase(breed)) {
                return Breed.values()[i];
            }
        }
        return null;
    }
}