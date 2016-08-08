package wasteDisposal.core;

import wasteDisposal.annotations.Inject;
import wasteDisposal.commands.contracts.Executable;
import wasteDisposal.contracts.GarbageProcessor;
import wasteDisposal.core.contracts.CommandInterpreter;
import wasteDisposal.data.RecyclingStation;
import wasteDisposal.factories.WasteFactory;

import java.lang.reflect.Field;

public class CommandInterpreterImpl implements CommandInterpreter {

    private static final String COMMANDS_PATH = "wasteDisposal.commands.";
    private static final String COMMANDS_SUFFIX = "Command";
    private static final String RECYCLE_STATION_NAME_FIELD = "recyclingStation";

    private RecyclingStation recyclingStation;
    private WasteFactory wasteFactory;
    private GarbageProcessor garbageProcessor;

    public CommandInterpreterImpl(RecyclingStation recyclingStation,
                                  WasteFactory wasteFactory,
                                  GarbageProcessor garbageProcessor) {
        this.recyclingStation = recyclingStation;
        this.wasteFactory = wasteFactory;
        this.garbageProcessor = garbageProcessor;
    }

    @Override
    @SuppressWarnings("unchecked")
    public String interpretCommand(String command, String... args) throws ReflectiveOperationException {
        Executable executable;
        Class<Executable> executableClass =
                (Class<Executable>) Class.forName(COMMANDS_PATH + command + COMMANDS_SUFFIX);
        executable = executableClass.getDeclaredConstructor().newInstance();
        this.resolveDependencies(executable, executableClass);
        String result = executable.execute(args);

        return result;
    }

    private void resolveDependencies(Executable executable, Class<Executable> executableClass) throws
            IllegalAccessException, NoSuchFieldException {
        Field[] thisClassFields = this.getClass().getDeclaredFields();
        Field[] exeClassFields = executableClass.getDeclaredFields();

        this.setRecyclingStationField(executable, executableClass, thisClassFields);
        if (exeClassFields.length > 0) {
            this.resolveRestOfTheFields(executable, thisClassFields, exeClassFields);
        }
    }

    private void resolveRestOfTheFields(Executable executable, Field[] thisClassField, Field[] exeClassFields) throws
            IllegalAccessException {
        for (Field exeField : exeClassFields) {
            if (!exeField.isAnnotationPresent(Inject.class)) {
                continue;
            }

            exeField.setAccessible(true);
            for (Field fieldInThisClass : thisClassField) {
                if (exeField.getType().equals(fieldInThisClass.getType())) {
                    fieldInThisClass.setAccessible(true);
                    exeField.set(executable, fieldInThisClass.get(this));
                }
            }
        }
    }

    private void setRecyclingStationField(Executable executable,
                                          Class<Executable> executableClass,
                                          Field[] thisClassFIelds) throws
            NoSuchFieldException, IllegalAccessException {
        Field thisRecycleField = null;
        for (Field field : thisClassFIelds) {
            if (field.getName().equals(RECYCLE_STATION_NAME_FIELD)) {
                thisRecycleField = field;
                break;
            }
        }
        Field recycleStationField = executableClass.getSuperclass().getDeclaredField(RECYCLE_STATION_NAME_FIELD);
        recycleStationField.setAccessible(true);
        recycleStationField.set(executable, thisRecycleField.get(this));
    }
}
