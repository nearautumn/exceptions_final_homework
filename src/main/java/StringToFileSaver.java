public class StringToFileSaver {

    private InputReader inputReader;
    private InputChecker inputChecker;
    private FileSaver fileSaver;

    public StringToFileSaver(InputReader inputReader, InputChecker inputChecker, FileSaver fileSaver) {
        this.inputReader = inputReader;
        this.inputChecker = inputChecker;
        this.fileSaver = fileSaver;
    }

    public void init() {

        String userString = inputReader.readData();
        if (userString.equals(InputReader.ERROR)) {
            System.out.println("Что-то сломалось при чтении данных...");
        } else {
            try {
                inputChecker.check(userString);
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
                return;
            }
            fileSaver.save(userString);
            System.out.println("Выполнено!");
        }
    }
}
