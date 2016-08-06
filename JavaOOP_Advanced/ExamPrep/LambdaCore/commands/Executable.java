package bg.softuni.models.commands;

public interface Executable {

    String execute(String... args) throws ReflectiveOperationException;

}
