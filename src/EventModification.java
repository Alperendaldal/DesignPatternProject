public class EventModification {
    private ModificationInvoker invoker = new ModificationInvoker();

    public void modifyEventName(Event event, String newName) {
        Command command = new UpdateNameCommand(event, newName);
        invoker.executeCommand(command);
    }

    public void undoLastModification() {
        invoker.undoLastCommand();
    }
}
