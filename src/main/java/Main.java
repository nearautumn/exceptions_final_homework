public class Main {
    public static void main(String[] args) {

        System.out.println("фамилия, имя, отчество - строки\n" +
                "датарождения - строка формата dd.mm.yyyy\n" +
                "номертелефона - целое беззнаковое число без форматирования\n" +
                "пол - символ латиницей f или m.");

        InputReader inputReader = new InputReader("Фамилия Имя Отчество датарождения номертелефона пол");
        InputChecker inputChecker = new InputChecker();
        FileSaver fileSaver = new FileSaver();
        StringToFileSaver stringToFileSaver = new StringToFileSaver(inputReader, inputChecker, fileSaver);

        stringToFileSaver.init();
    }
}