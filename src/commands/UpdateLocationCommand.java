package commands;

import event.Event;
import interfaces.Command;

public class UpdateLocationCommand implements Command {
    private final Event event;
    private final String oldLocation;
    private final String newLocation;

    public UpdateLocationCommand(Event event, String newLocation) {
        this.event = event;
        this.newLocation = newLocation;
        this.oldLocation = event.getLocation();
    }

    @Override
    public void execute() {
        System.out.printf("Event's (with name %s) location has been changed from %s to %s.", event.getName(), oldLocation, newLocation);
        System.out.println();
        event.setLocation(newLocation);
    }

    @Override
    public void undo() {
        System.out.printf("UNDID! Event's (with name %s) location has been changed from %s to %s.", event.getName(), newLocation, oldLocation);
        System.out.println();
        event.setLocation(oldLocation);
    }
}
