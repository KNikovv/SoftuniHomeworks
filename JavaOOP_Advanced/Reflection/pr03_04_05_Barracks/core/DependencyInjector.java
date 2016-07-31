package pr0304Barracks.core;

import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Injector;
import pr0304Barracks.core.annotations.Inject;

import java.lang.reflect.Field;

public class DependencyInjector implements Injector {


    @Override
    public void injectDependencies(Executable executable, Class exeClass, CommandInterpreterImpl dispatcherClass) throws
            ReflectiveOperationException {
        Field[] exeFields = exeClass.getDeclaredFields();
        Field[] dispatcherFields = CommandInterpreterImpl.class.getDeclaredFields();
        this.loopExeFields(executable, dispatcherClass, exeFields, dispatcherFields);
    }

    private void loopExeFields(Executable executable,
                               CommandInterpreterImpl from,
                               Field[] exeFields,
                               Field[] dispatcherFields) throws IllegalAccessException {
        for (Field exeField : exeFields) {
            if (!exeField.isAnnotationPresent(Inject.class)) {
                continue;
            }
            exeField.setAccessible(true);
            this.loopDispatcherFields(executable, from, dispatcherFields, exeField);
        }
    }

    private void loopDispatcherFields(Executable executable,
                                      CommandInterpreterImpl from,
                                      Field[] dispatcherFields,
                                      Field exeField) throws IllegalAccessException {
        for (Field dispatcherField : dispatcherFields) {
            if (!dispatcherField.getType().equals(exeField.getType())) {
                continue;
            }
            dispatcherField.setAccessible(true);
            exeField.set(executable, dispatcherField.get(from));
        }
    }
}
