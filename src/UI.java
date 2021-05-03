import java.util.Scanner;

public class UI {
    Scanner scanner = new Scanner(System.in);

    public void getString(String message) {
        System.out.println(message);
    }

    public String getScanString(String message) {
        System.out.println(message);
        String anwser = scanner.nextLine();
        return anwser;
    }

    public int getScanInt(String message) {
        System.out.println(message);
        int anwser = scanner.nextInt();
        scanner.nextLine();
        return anwser;
    }
}
