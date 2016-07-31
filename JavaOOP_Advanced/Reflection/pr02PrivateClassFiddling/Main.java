package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.peshoslav.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws
            IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
        Class<BlackBoxInt> blackBoxIntClass = BlackBoxInt.class;


        try {
            Constructor<BlackBoxInt> ctor = blackBoxIntClass.getDeclaredConstructor();
            ctor.setAccessible(true);
            BlackBoxInt blackBoxInt = ctor.newInstance();
            while (true) {
                String[] params = buffReader.readLine().split("_");
                if(params[0].equalsIgnoreCase("end")){
                    break;
                }
                String command = params[0];
                int value = Integer.valueOf(params[1]);

                Method method = blackBoxIntClass.getDeclaredMethod(command, int.class);
                method.setAccessible(true);
                method.invoke(blackBoxInt, value);

                Field field = blackBoxIntClass.getDeclaredField("innerValue");
                field.setAccessible(true);
                System.out.println(field.get(blackBoxInt));
            }
        } catch (ReflectiveOperationException roe) {
            System.out.println(roe.getMessage());
        }
    }
}
