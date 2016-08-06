package bg.softuni.models.constants;

public class NameProvider {

    private static char currentLetter = 'A';

    public static String getNextName() {
        String nextName = String.valueOf(currentLetter++);
        return nextName;
    }
}
