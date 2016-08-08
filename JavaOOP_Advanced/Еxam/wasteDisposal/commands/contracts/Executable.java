package wasteDisposal.commands.contracts;

public interface Executable {

    String execute(String...args) throws ReflectiveOperationException;
}
