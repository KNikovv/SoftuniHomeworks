package pr1984.core;

import pr1984.core.interfaces.Repository;
import pr1984.core.interfaces.Executor;
import pr1984.core.interfaces.Runnable;
import pr1984.io.interfaces.Reader;
import pr1984.io.interfaces.Writer;

import java.io.IOException;
import java.lang.reflect.Method;

public class Engine implements Runnable {

    private Reader reader;
    private Writer writer;
    private Executor executor;
    private Repository repository;

    public Engine(Writer writer, Reader reader, Executor executor, Repository repository) {
        this.writer = writer;
        this.reader = reader;
        this.executor = executor;
        this.repository = repository;
    }

    @Override
    public void run() throws IOException, ReflectiveOperationException {
        String[] initialLineParams = this.reader.readLine().split("\\s+");
        int entitiesCount = Integer.parseInt(initialLineParams[0]);
        int institutionsCount = Integer.parseInt(initialLineParams[1]);
        int changesToMake = Integer.parseInt(initialLineParams[2]);

        Method addEntities = this.executor.getClass().getDeclaredMethod("executeAddEntities",String[].class);
        Method addInstitutions = this.executor.getClass().getDeclaredMethod("executeAddObservers",String[].class);
        Method makeChanges = this.executor.getClass().getDeclaredMethod("executeChange",String[].class);

        this.invokeMethod(entitiesCount, addEntities);
        this.invokeMethod(institutionsCount, addInstitutions);
        this.invokeMethod(changesToMake, makeChanges);

        String changeLog = this.repository.getAllChangeLogs();
        this.writer.writeLine(changeLog);
    }

    private void invokeMethod(int count, Method method) throws IOException, ReflectiveOperationException {
        for (int i = 0; i < count; i++) {
            String[] args = this.reader.readLine().split("\\s+");
            method.invoke(this.executor, new Object[] {args});
        }
    }
}
