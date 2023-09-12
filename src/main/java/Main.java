public class Main {
    public static void main(String[] args) {

        InputReader inputReader = new InputReader("Фамилия Имя Отчество датарождения номертелефона пол");
        InputChecker inputChecker = new InputChecker();
        StringToFileSaver stringToFileSaver = new StringToFileSaver(inputReader, inputChecker);

        stringToFileSaver.init();


    }
}