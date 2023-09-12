import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Возвращает строку из консоли. Использует Scanner. При возникновении исключений NoSuchElementException и
 * IllegalStateException возвращает код ошибки.
 * @author Andrei Aliaksandrau
 */
public class InputReader {

    private Scanner scanner;
    private String lineFormat;
    public static final String ERROR = "error";

    public InputReader(String lineFormat) {
        scanner = new Scanner(System.in);
        this.lineFormat = lineFormat;
    }

    public String readData() {

        System.out.println("Введите строку следующего формата: " + lineFormat);

        try {
            return scanner.nextLine();
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println(e.getMessage());
            return ERROR;
        }
    }
}
