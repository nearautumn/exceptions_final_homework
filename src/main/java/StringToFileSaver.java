import javax.swing.*;

public class StringToFileSaver {

    private InputReader inputReader;
    private InputChecker inputChecker;

    public StringToFileSaver(InputReader inputReader, InputChecker inputChecker) {
        this.inputReader = inputReader;
        this.inputChecker = inputChecker;
    }

    public void init() {

        String userString = inputReader.readData();
        if (userString.equals(InputReader.ERROR)) {
            System.out.println("Something wrong happened...");
        } else {
            try {
                inputChecker.check(userString);
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
                return;
            }

            System.out.println("done");
        }
    }

}
