package wasteDisposal.core.contracts;

public interface CommandInterpreter {

    String interpretCommand(String command, String... args) throws ReflectiveOperationException;
}
