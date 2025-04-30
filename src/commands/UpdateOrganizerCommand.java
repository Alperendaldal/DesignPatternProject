package commands;

import event.Event;
import interfaces.Command;

public class UpdateOrganizerCommand implements Command {
    private final Event event;
    private final String oldOrganizer;
    private final String newOrganizer;

    public UpdateOrganizerCommand(Event event, String newOrganizer) {
        this.event = event;
        this.newOrganizer = newOrganizer;
        this.oldOrganizer = event.getName();
    }

    @Override
    public void execute() {
        event.setOrganizer(newOrganizer);
    }

    @Override
    public void undo() {
        event.setOrganizer(oldOrganizer);
    }
}

