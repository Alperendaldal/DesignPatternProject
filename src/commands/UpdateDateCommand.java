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
        event.setDate(newDate);
    }

    @Override
    public void undo() {
        event.setDate(oldDate);
    }
}