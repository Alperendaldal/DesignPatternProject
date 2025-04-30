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
        event.setLocation(newLocation);
    }

    @Override
    public void undo() {
        event.setLocation(oldLocation);
    }
}
