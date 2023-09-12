import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FileSaver {

    /**
     * Позволяет сохранять строку в файл. Название файла образуется по первому слову в строке (фамилия).
     * @author Andrei Aliaksandrau
     */
    public FileSaver() {
    }

    /**
     * Позволяет сохранять строку в файл. Название файла образуется по первому слову в строке (фамилия). При
     * возникновении ошибок ввода/вывода обрабатывает их.
     * @param userString строка, которая будет записана в файл.
     * @author Andrei Aliaksandrau
     */
    public void save(String userString) {

        String[] strings = userString.split(" ");

        File file = new File(strings[0].toLowerCase());
        try (BufferedWriter bufWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufWriter.write(userString + "\n");
        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
