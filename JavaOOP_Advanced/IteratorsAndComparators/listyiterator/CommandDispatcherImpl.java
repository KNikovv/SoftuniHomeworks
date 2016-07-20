package listyiterator;

import java.util.ArrayList;
import java.util.List;

public class CommandDispatcherImpl<E> {

    private Core core;

    public CommandDispatcherImpl() {

    }

    public void setCore(Core core) {
        this.core = core;
    }

    public void dispatch(String command, List<? extends String> params) {

        switch (command) {
            case "Create":
                this.executeCreate(params);
                break;
            case "Move":
                this.executeMove();
                break;
            case "HasNext":
                this.executeHasNext();
                break;
            case "Print":
                try {
                    this.executePrint();
                } catch (IllegalStateException ise) {
                    System.out.println(ise.getMessage());
                }
                break;
            case "PrintAll":
                this.executePrintAll();
                break;
            case "END":
                this.executeEnd();
                break;
        }

    }

    private void executeCreate(List<? extends String> params) {
        List<String> elements = new ArrayList<>(params);
        this.core.setIterator(elements);
    }

    private void executeMove() {
        System.out.println(this.core.getIterator().move());
    }

    private void executePrint() {
        if (this.core.getIterator().getSize() == 0) {
            throw new IllegalStateException("Invalid Operation!");
        }
        this.core.getIterator().print();
    }
    private void executePrintAll(){
        this.core.getIterator().printAll();
    }
    private void executeHasNext() {
        System.out.println(this.core.getIterator().listyHasNext());
    }

    private void executeEnd() {
        this.core.endInput();
    }
}
