package pr1984.models;

import pr1984.models.interfaces.ChangeEvent;
import pr1984.models.interfaces.Entity;
import pr1984.models.interfaces.Observer;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

public class Institution implements Observer {

    private String id;
    private String name;
    private List<String> subjectsToMonitor;
    private StringBuilder changeLog;
    private int changesRegistered;

    public Institution(String id, String name) {
        this.id = id;
        this.name = name;
        this.subjectsToMonitor = new LinkedList<>();
        this.changeLog = new StringBuilder();
        this.changesRegistered = 0;
    }

    private int getChangesRegistered() {
        return this.changesRegistered;
    }

    @Override
    public void update(ChangeEvent event) {

        Entity source = event.getEventSource();
        String sourceClass = source.getClass().getSimpleName();
        String id = source.getId();

        Field field = event.fieldChanged();
        String fieldType = field.getType().getSimpleName();
        String fieldName = field.getName();

        String oldValueAsString = event.getOldValue().toString();
        String newValueAsString = event.getNewValue().toString();

        if (this.subjectsToMonitor.contains(fieldName)) {
            if (fieldType.equals("Integer")) {
                fieldType = "int";
            }
            this.changeLog.append(String.format("--%s(ID:%s) changed %s(%s) from %s to %s\n",
                    sourceClass,
                    id,
                    fieldName,
                    fieldType,
                    oldValueAsString,
                    newValueAsString));
            this.changesRegistered++;
        }
    }

    @Override
    public String getChangeLog() {
        return this.changeLog.toString();
    }

    @Override
    public void addSubject(String subjectToMonitor) {
        this.subjectsToMonitor.add(subjectToMonitor);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return String.format("%s: %d changes registered", this.getName(), this.getChangesRegistered());
    }

}
