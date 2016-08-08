import wasteDisposal.contracts.GarbageProcessor;
import wasteDisposal.core.CommandInterpreterImpl;
import wasteDisposal.core.DefaultGarbageProcessor;
import wasteDisposal.core.Engine;
import wasteDisposal.core.contracts.CommandInterpreter;
import wasteDisposal.core.contracts.Runnable;
import wasteDisposal.data.RecyclingStation;
import wasteDisposal.data.RecyclingStationImpl;
import wasteDisposal.factories.WasteFactory;
import wasteDisposal.factories.WasteFactoryImpl;
import wasteDisposal.io.ConsoleReader;
import wasteDisposal.io.ConsoleWriter;
import wasteDisposal.io.contracts.Reader;
import wasteDisposal.io.contracts.Writer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        WasteFactory wasteFactory = new WasteFactoryImpl();
        GarbageProcessor garbageProcessor = new DefaultGarbageProcessor();
        RecyclingStation recyclingStation = new RecyclingStationImpl();
        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(
                recyclingStation,
                wasteFactory,
                garbageProcessor);
        Runnable runnable = new Engine(reader, writer, commandInterpreter);
        try {
            runnable.run();
        } catch (IOException | ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }
}
