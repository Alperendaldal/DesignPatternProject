package commands;

import event.Event;
import interfaces.Command;

public class UpdateTagsCommand implements Command {
    private final Event event;
    private final String newTag;

    public UpdateTagsCommand(Event event, String newTag) {
        this.event = event;
        this.newTag = newTag;
    }

    @Override
    public void execute() {
        event.getTags().add(newTag);
    }

    @Override
    public void undo() {
        event.getTags().remove(newTag);
    }
}
