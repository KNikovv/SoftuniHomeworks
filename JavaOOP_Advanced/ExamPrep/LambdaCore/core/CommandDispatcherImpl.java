package bg.softuni.models.core;

import bg.softuni.models.annotations.Inject;
import bg.softuni.models.commands.Executable;
import bg.softuni.models.core.interfaces.CommandDispatcher;
import bg.softuni.models.data.interfaces.PowerPlant;
import bg.softuni.models.factories.interfaces.CoreFactory;
import bg.softuni.models.factories.interfaces.FragmentFactory;

import java.lang.reflect.Field;

public class CommandDispatcherImpl implements CommandDispatcher {

    private static final String COMMANDS_PACKAGE = "bg.softuni.models.commands.";
    private static final String COMMAND_SUFFIX = "Command";
    private static final String POWER_PLANT_NAME = "powerPlant";

    private PowerPlant powerPlant;
    private CoreFactory coreFactory;
    private FragmentFactory fragmentFactory;

    public CommandDispatcherImpl(PowerPlant powerplant, CoreFactory coreFactory, FragmentFactory fragmentFactory) {
        this.powerPlant = powerplant;
        this.coreFactory = coreFactory;
        this.fragmentFactory = fragmentFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public String dispatch(String command, String[] args) throws ReflectiveOperationException {
        String result;

        Class<Executable> commandClass = (Class<Executable>)
                Class.forName(COMMANDS_PACKAGE + command + COMMAND_SUFFIX);
        Executable commandToExecute = commandClass
                .getDeclaredConstructor()
                .newInstance();
        this.resolveDependencies(commandToExecute, commandClass);

        result = commandToExecute.execute(args);
        return result;
    }

    private void resolveDependencies(Executable commandToExecute, Class<Executable> commandClass) throws
            ReflectiveOperationException {
        Field[] thisClassFields = this.getClass().getDeclaredFields();
        Field[] exeClassFields = commandClass.getDeclaredFields();
        Field thisPowerField = this.getClass().getDeclaredField(POWER_PLANT_NAME);
        this.injectPowerPlant(commandToExecute, commandClass, thisPowerField);

        if (exeClassFields.length > 0) {
            this.injectDependencies(commandToExecute, thisClassFields, exeClassFields);
        }

    }

    private void injectPowerPlant(Executable commandToExecute, Class<Executable> commandClass, Field thisClassField)
            throws NoSuchFieldException, IllegalAccessException {
        Field powerPlantField = commandClass.getSuperclass().getDeclaredField(POWER_PLANT_NAME);
        thisClassField.setAccessible(true);
        powerPlantField.setAccessible(true);
        powerPlantField.set(commandToExecute, thisClassField.get(this));
    }

    private void injectDependencies(Executable commandToExecute, Field[] thisClassFields, Field[] exeClassFields)
            throws ReflectiveOperationException {
        for (Field exeField : exeClassFields) {
            if (!exeField.isAnnotationPresent(Inject.class)) {
                continue;
            }
            exeField.setAccessible(true);
            for (Field thisField : thisClassFields) {
                if (thisField.getType().equals(exeField.getType())) {
                    thisField.setAccessible(true);
                    exeField.set(commandToExecute, thisField.get(this));
                }
            }
        }
    }

}