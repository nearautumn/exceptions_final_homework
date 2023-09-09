import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputReader {

    private String userInput;
    private Scanner scanner;

    public InputReader() {
        scanner = new Scanner(System.in);
    }

    public String readData() {

        try {
            return scanner.nextLine();
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println(e.getMessage());
            return "-1";
        }
    }
}
