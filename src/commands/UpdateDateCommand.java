package commands;

import event.Event;
import interfaces.Command;

import java.time.LocalDate;

public class UpdateDateCommand implements Command {
    private final Event event;
    private final LocalDate oldDate;
    private final LocalDate newDate;

    public UpdateDateCommand(Event event, LocalDate newDate) {
        this.event = event;
        this.newDate = newDate;
        this.oldDate = event.getDate();
    }

    @Override
    public void execute() {
        System.out.printf("Event's (with name %s) date has changed from %s to %s.", event.getName(), oldDate.toString(), newDate.toString());
        System.out.println();
        event.setDate(newDate);
    }

    @Override
    public void undo() {
        System.out.printf("UNDID! Event's (with name %s) date has changed from %s to %s.", event.getName(), newDate.toString(), oldDate.toString());
        System.out.println();
        event.setDate(oldDate);
    }
}