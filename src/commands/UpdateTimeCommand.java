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
        System.out.printf("Event %s's time has been changed from %s to %s.", event.getName(), oldTime.toString(), newTime.toString());
        System.out.println();

        event.setTime(newTime);
    }

    @Override
    public void undo() {
        System.out.printf("UNDID! Event %s's time has been changed from %s to %s.", event.getName(), newTime.toString(), oldTime.toString());
        System.out.println();

        event.setTime(oldTime);
    }
}
