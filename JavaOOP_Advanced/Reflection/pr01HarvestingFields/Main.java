package pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class Main {

    public static void main(String[] args) throws IOException, NoSuchMethodException, InvocationTargetException,
            IllegalAccessException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = buffReader.readLine();
            if (line.equalsIgnoreCase("harvest")) {
                break;
            }
            Class<RichSoilLand> rslClass = RichSoilLand.class;
            Field[] fields = rslClass.getDeclaredFields();

            for (Field field : fields) {

                int mod = field.getModifiers();
                String modAsString = Modifier.toString(mod);
                if (!modAsString.equals(line) && !line.equals("all")) {
                    continue;
                }
                String fieldType = field.getType().getSimpleName();
                String fieldName = field.getName();
                System.out.println(String.format("%s %s %s",
                        modAsString,
                        fieldType,
                        fieldName));
            }


        }
    }
}
