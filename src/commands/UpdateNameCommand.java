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
        System.out.printf("Event's (with name %s) name has been changed from %s to %s.", event.getName(), oldName, newName);
        System.out.println();
        event.setName(newName);
    }

    @Override
    public void undo() {
        System.out.printf("UNDID! Event's (with name %s) name has been changed from %s to %s.", event.getName(), newName, oldName);
        System.out.println();

        event.setName(oldName);
    }
}
