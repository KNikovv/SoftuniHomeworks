package infernoinfinity.interfaces;

public interface CommandInterpreter {

    void seedCommands();

    void dispatch(String command, String[] params);

}
