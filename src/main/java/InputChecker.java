import org.jetbrains.annotations.NotNull;

/**
 * Содержит в себе метод для проверки переданной строки на соответствие необходимому формату. При несоовтетствии
 * пробрасывает WrongFormatException
 * @author Andrei Aliaksandrau
 */
public class InputChecker {

    private String[] strings;

    public InputChecker() {
        strings = new String[6];
    }

    /**
     * Проверяет строку на соответствие необходимому формату:
     * фамилия, имя, отчество - строки
     * датарождения - строка формата dd.mm.yyyy
     * номертелефона - целое беззнаковое число без форматирования
     * пол - символ латиницей f или m.
     * @param string строка, которую необходимо проверить
     * @throws WrongFormatException при несоответсвии переданной строки нужному формату.
     * @author Andrei Aliaksandrau
     */
    public void check(String string) throws WrongFormatException {

        strings = string.split(" ");
        for (String s: strings) {
            if (s.equals(" ") || s.isEmpty()) throw new WrongFormatException("Обнаружена пустая строка");
        }

        if (strings.length != 6) {
            throw new WrongFormatException("Введенная строка не соответствует заданному формату");
        }

        String lastName = strings[0];
        String firstName = strings[1];
        String thirdName = strings[2];

        checkForDigits(lastName);
        checkForDigits(firstName);
        checkForDigits(thirdName);

        String birthDate = strings[3];
        checkDate(birthDate);

        String phoneNumber = strings[4];
        checkPhoneNumber(phoneNumber);

        String sex = strings[5];
        checkSex(sex);
    }

    private void checkForDigits(@NotNull String word) throws WrongFormatException {
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isAlphabetic(word.charAt(i))) {
                throw new WrongFormatException("Имя, фамилия и отчество могут состоять только из букв");
            }
        }
    }

    private void checkDate(@NotNull String date) throws WrongFormatException {
        String[] dateArr = date.split("\\.");
        if (dateArr.length != 3) throw new WrongFormatException("Неправильный формат даты");

        for (String s : dateArr) {
            try {
                Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new WrongFormatException("Дата не может содержать иных символов, кроме цифр и точки");
            }
        }
    }

    private void checkPhoneNumber(@NotNull String phoneNumber) throws WrongFormatException {

        try {
            Long.parseLong(phoneNumber);
        } catch (NumberFormatException e) {
            throw new WrongFormatException("Неверный формат номера телефона");
        }

        long phoneNumberLong = Long.parseLong(phoneNumber);
        if (phoneNumberLong < 0) throw new WrongFormatException("Неверный формат номера телефона");
    }

    private void checkSex(@NotNull String sex) throws WrongFormatException {
        if (!sex.equals("m")) {
            if (!sex.equals("f")) {
                throw new WrongFormatException("Неверно указан пол");
            }
        }
    }
}