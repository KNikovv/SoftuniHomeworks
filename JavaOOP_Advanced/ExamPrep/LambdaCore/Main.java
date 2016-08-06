package bg.softuni.models;

import bg.softuni.models.core.CommandDispatcherImpl;
import bg.softuni.models.core.Engine;
import bg.softuni.models.core.interfaces.CommandDispatcher;
import bg.softuni.models.core.interfaces.Runnable;
import bg.softuni.models.data.PowerPlantImpl;
import bg.softuni.models.data.interfaces.PowerPlant;
import bg.softuni.models.factories.CoreFactoryImpl;
import bg.softuni.models.factories.FragmentFactoryImpl;
import bg.softuni.models.factories.interfaces.CoreFactory;
import bg.softuni.models.factories.interfaces.FragmentFactory;
import bg.softuni.models.io.ConsoleReader;
import bg.softuni.models.io.ConsoleWriter;
import bg.softuni.models.io.interfaces.Reader;
import bg.softuni.models.io.interfaces.Writer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();

        CoreFactory coreFactory = new CoreFactoryImpl();
        FragmentFactory fragmentFactory = new FragmentFactoryImpl();
        PowerPlant powerPlant = new PowerPlantImpl();

        CommandDispatcher commandDispatcher = new CommandDispatcherImpl(powerPlant, coreFactory, fragmentFactory);
        Runnable runnable = new Engine(reader, writer, commandDispatcher);
        try {
            runnable.run();
        } catch (IOException | ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }
}
