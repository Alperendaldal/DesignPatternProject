package invoke;
import interfaces.Command;
import java.util.Stack;

public class ModificationInvoker {
    private final Stack<Command> history = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    public void undoLastCommand() {
        if (!history.isEmpty()) {
            history.pop().undo();
        }
        else System.out.println("There is no process to undo!");
    }
}
