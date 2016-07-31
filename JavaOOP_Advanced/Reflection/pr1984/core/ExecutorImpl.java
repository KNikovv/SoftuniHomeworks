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
    public void executeChange(String... args) {
        String idToInspect = args[0];
        String subjectToInspect = args[1];
        String valueToChange = args[2];

        Entity toInspect = this.repository.getEntityById(idToInspect);
        Method[] entityMethods = toInspect.getClass().getDeclaredMethods();
        Method[] entityParentMethods = toInspect.getClass().getSuperclass().getDeclaredMethods();
        Method[] allMethods = combineMethods(entityMethods, entityParentMethods);
        for (Method method : allMethods) {
            if (!method.isAnnotationPresent(Monitored.class)) {
                continue;
            }
            method.setAccessible(true);
            Monitored annotation = method.getAnnotation(Monitored.class);
            if (annotation.value().equals(subjectToInspect)) {
                try {
                    if (subjectToInspect.equals("name")) {
                        method.invoke(toInspect, valueToChange);
                        break;
                    }
                    method.invoke(toInspect, Integer.valueOf(valueToChange));
                } catch (ReflectiveOperationException ex) {
                    ex.printStackTrace();
                }
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

    private Method[] combineMethods(Method[] fromClass, Method[] fromParent) {
        int totalLength = fromClass.length + fromParent.length;
        Method[] result = new Method[totalLength];
        System.arraycopy(fromClass, 0, result, 0, fromClass.length);
        System.arraycopy(fromParent, 0, result, fromClass.length, fromParent.length);
        return result;
    }
}
