public class Main {
    public static void main(String[] args) {

        InputReader inputReader = new InputReader("Фамилия Имя Отчество датарождения номертелефона пол");
        InputChecker inputChecker = new InputChecker();
        FileSaver fileSaver = new FileSaver();
        StringToFileSaver stringToFileSaver = new StringToFileSaver(inputReader, inputChecker, fileSaver);

        stringToFileSaver.init();
    }
}