package pr1984.models.interfaces;

public interface Observer extends Identifiable,Nameable{

    <T> void update(ChangeEvent event);

    String getChangeLog();

    void addSubject(String subjectToMonitor);

}
