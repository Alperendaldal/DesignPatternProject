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
        System.out.printf("Event's (with name %s) organizer's name has been changed from %s to %s.", event.getName(), oldOrganizer, newOrganizer);
        System.out.println();
        event.setOrganizer(newOrganizer);
    }

    @Override
    public void undo() {
        System.out.printf("UNDID! Event's (with name %s) organizer's name has been changed from %s to %s.", event.getName(), newOrganizer, oldOrganizer);
        System.out.println();
        event.setOrganizer(oldOrganizer);
    }
}

