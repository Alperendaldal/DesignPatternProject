package commands;

import event.Event;
import interfaces.Command;

public class UpdateNameCommand implements Command {
    private final Event event;
    private final String oldName;
    private final String newName;

    public UpdateNameCommand(Event event, String newName) {
        this.event = event;
        this.newName = newName;
        this.oldName = event.getName();
    }

    @Override
    public void execute() {
        event.setName(newName);
    }

    @Override
    public void undo() {
        event.setName(oldName);
    }
}
