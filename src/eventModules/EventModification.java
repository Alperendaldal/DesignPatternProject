package eventModules;

import commands.UpdateLocationCommand;
import commands.UpdateNameCommand;
import event.Event;
import interfaces.Command;
import invoke.ModificationInvoker;

public class EventModification {
    private final ModificationInvoker invoker = new ModificationInvoker();

    public void modifyEventName(Event event, String newName) {
        Command command = new UpdateNameCommand(event, newName);
        invoker.executeCommand(command);
    }

    public void modifyEventLocation(Event event, String location){
        Command command = new UpdateLocationCommand(event, location);
        invoker.executeCommand(command);
    }

    public void undoLastModification() {
        invoker.undoLastCommand();
    }
}
