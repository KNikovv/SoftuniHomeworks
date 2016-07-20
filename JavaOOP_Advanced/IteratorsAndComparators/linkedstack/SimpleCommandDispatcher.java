package lineardatastructures.linkedstack;

import lineardatastructures.linkedstack.interfaces.MyStack;
import lineardatastructures.linkedstack.models.LinkedStack;

import java.util.List;

public class SimpleCommandDispatcher {

    private MyStack<Integer> linkedStack;

    public SimpleCommandDispatcher() {
        this.linkedStack = new LinkedStack<>();
    }

    public void dispatch(String command, List<Integer> toPush) {
        switch (command) {
            case "Push":
                toPush.forEach(e -> this.linkedStack.push(e));
                break;
            case "Pop":
                try {
                    this.linkedStack.pop();
                } catch (MyStackEmptyException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            case "END":
                for (Integer number : this.linkedStack) {
                    System.out.println(number);
                }

                while (!this.linkedStack.isEmpty()) {
                    System.out.println(this.linkedStack.peek());
                    this.linkedStack.pop();
                }
                break;
        }
    }
}
