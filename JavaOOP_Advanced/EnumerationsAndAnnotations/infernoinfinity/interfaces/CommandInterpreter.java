package infernoinfinity.interfaces;

public interface CommandInterpreter {

    void seedCommands();

    String dispatch(String command, String[] params);

}
