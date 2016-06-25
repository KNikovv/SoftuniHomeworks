package pizzaTime;

import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] line = bf.readLine().split("\\s+");
        Pizza pizza = new Pizza();
        HashMap<Integer,ArrayList<String>> pizzas = pizza.getPizzaInstances(line);
        for (Map.Entry<Integer, ArrayList<String>> pizzaEntry : pizzas.entrySet()) {
            System.out.printf("%d - %s\n",pizzaEntry.getKey(),String.join(", ",pizzaEntry.getValue()));
        }
        Class<?> pizzaClass = Pizza.class;
        Method[] methods = pizzaClass.getDeclaredMethods();
        List<Method> checkedMethods = Arrays.stream(methods)
                .filter(m -> m.getReturnType().getName().contains("Map"))
                .collect(Collectors.toList());

        if (checkedMethods.size() < 1) {
            throw new ClassFormatException();
        }

    }
}

class Pizza {

    public HashMap<Integer, ArrayList<String>> getPizzaInstances(String...input) {

        HashMap<Integer, ArrayList<String>> pizzaMap = new HashMap<>();
        for(String line : input){
            Matcher matcher = Pattern.compile("(\\d+)(\\S+)").matcher(line);
            if (matcher.find()) {
                int group = Integer.parseInt(matcher.group(1));
                String name = matcher.group(2);
                if (!pizzaMap.containsKey(group)) {
                    pizzaMap.put(group, new ArrayList<String>());
                }
                pizzaMap.get(group).add(name);
            }
        }
        return pizzaMap;
    }
}
