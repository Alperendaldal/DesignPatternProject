package commands;

import event.Event;
import interfaces.Command;

import java.time.LocalTime;

public class UpdateTimeCommand implements Command {
    private final Event event;
    private final LocalTime oldTime;
    private final LocalTime newTime;

    public UpdateTimeCommand(Event event, LocalTime newTime) {
        this.event = event;
        this.oldTime = event.getTime();
        this.newTime = newTime;
    }

    @Override
    public void execute() {
        event.setTime(newTime);
    }

    @Override
    public void undo() {
        event.setTime(oldTime);
    }
}
