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

    public int getScanInt() {
        int anwser = scanner.nextInt();
        scanner.nextLine();
        return anwser;
    }
}
