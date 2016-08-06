package bg.softuni.models.core.interfaces;

public interface CommandDispatcher {

   String dispatch(String command, String[] args) throws ReflectiveOperationException;
}
