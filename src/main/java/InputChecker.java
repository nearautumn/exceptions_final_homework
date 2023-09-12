import org.jetbrains.annotations.NotNull;

public class InputChecker {

    private String[] strings;

    public InputChecker() {
        strings = new String[6];
    }

    public void check(String string) throws WrongFormatException {

        strings = string.split(" ");
        for (String s: strings) {
            if (s.equals(" ") || s.isEmpty()) throw new WrongFormatException("Empty string detected");
        }

        if (strings.length != 6) {
            throw new WrongFormatException("Wrong line format");
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
                throw new WrongFormatException("Name should not contain numbers!");
            }
        }
    }

    private void checkDate(@NotNull String date) throws WrongFormatException {
        String[] dateArr = date.split("\\.");
        if (dateArr.length != 3) throw new WrongFormatException("Wrong date format");

        for (String s : dateArr) {
            try {
                Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new WrongFormatException("Date should be only in digital format");
            }
        }
    }

    private void checkPhoneNumber(@NotNull String phoneNumber) throws WrongFormatException {

        try {
            Integer.parseInt(phoneNumber);
        } catch (NumberFormatException e) {
            throw new WrongFormatException("Wrong phone number format");
        }

        int phoneNumberInt = Integer.parseInt(phoneNumber);
        if (phoneNumberInt < 0) throw new WrongFormatException("Wrong phone number format");
    }

    private void checkSex(@NotNull String sex) throws WrongFormatException {
        if (!sex.equals("m")) {
            if (!sex.equals("f")) {
                throw new WrongFormatException("Wrong sex format (should be m or f)");
            }
        }
    }
}