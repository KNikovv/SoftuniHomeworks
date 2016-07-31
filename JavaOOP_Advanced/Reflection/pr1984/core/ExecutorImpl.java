package pr1984.core;

import pr1984.annotations.Monitored;
import pr1984.core.interfaces.Executor;
import pr1984.core.interfaces.Repository;
import pr1984.factories.interfaces.EntityFactory;
import pr1984.factories.interfaces.ObserverFactory;
import pr1984.models.interfaces.Entity;
import pr1984.models.interfaces.Observer;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExecutorImpl implements Executor {

    private ObserverFactory observerFactory;
    private EntityFactory entityFactory;
    private Repository repository;

    public ExecutorImpl(ObserverFactory observerFactory,
                        EntityFactory entityFactory,
                        Repository repository) {
        this.observerFactory = observerFactory;
        this.entityFactory = entityFactory;
        this.repository = repository;
    }

    @Override
    public void executeChange(String... args) throws ReflectiveOperationException {
        String idToInspect = args[0];
        String subjectToInspect = args[1];
        String valueToChange = args[2];

        Entity toInspect = this.repository.getEntityById(idToInspect);

        Method[] entityMethods = toInspect.getClass().getDeclaredMethods();
        Method[] entityParentMethods = toInspect.getClass().getSuperclass().getDeclaredMethods();

        Method[] allMethods = combineMethods(entityParentMethods, entityMethods);

        for (Method method : allMethods) {
            Monitored annotation = method.getAnnotation(Monitored.class);
            if (annotation != null && annotation.value().equals(subjectToInspect)) {
                method.setAccessible(true);
                if (method.getParameterTypes()[0].equals(String.class)) {
                    method.invoke(toInspect, valueToChange);
                    break;
                }
                method.invoke(toInspect, Integer.valueOf(valueToChange));
            }
        }
    }

    @Override
    public void executeAddEntities(String... args) throws ReflectiveOperationException {
        Entity observable = this.entityFactory.createEntity(args);
        this.repository.addEntity(observable);
    }

    @Override
    public void executeAddObservers(String... args) {
        String id = args[1];
        String name = args[2];
        List<String> subjectsToMonitor = Arrays.stream(args).skip(3).collect(Collectors.toList());
        Observer observer = this.observerFactory.createObserver(id, name);
        subjectsToMonitor.forEach(observer::addSubject);
        this.repository.addObserver(observer);
        this.repository.subscribeEntities(observer);
    }

    private Method[] combineMethods(Method[] fromParent, Method[] fromClass) {
        int totalLength = fromParent.length + fromClass.length;
        Method[] result = new Method[totalLength];
        System.arraycopy(fromParent, 0, result, 0, fromParent.length);
        System.arraycopy(fromClass, 0, result, fromParent.length, fromClass.length);
        return result;
    }
}
