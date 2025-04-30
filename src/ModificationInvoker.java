import java.util.Stack;

public class ModificationInvoker {
    private Stack<Command> history = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    public void undoLastCommand() {
        if (!history.isEmpty()) {
            history.pop().undo();
        }
    }
}
