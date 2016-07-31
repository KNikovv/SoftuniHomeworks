package eventimplementation;

import eventimplementation.interfaces.Dispatcher;
import eventimplementation.interfaces.NameChangeListener;
import eventimplementation.models.DispatcherImpl;
import eventimplementation.models.HandlerImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Dispatcher dispatcher = new DispatcherImpl(null);
        NameChangeListener listener = new HandlerImpl();
        dispatcher.addNameChangeListener(listener);
        while (true) {
            String line = bufferedReader.readLine();

            if(line.toLowerCase().equals("end")){
                break;
            }
            dispatcher.setName(line);
        }
    }
}
