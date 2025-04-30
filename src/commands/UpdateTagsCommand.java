package commands;

import event.Event;
import interfaces.Command;
import enums.Tag;
import java.util.Set;

public class UpdateTagsCommand implements Command {
    private final Event event;
    private final Set<Tag>  newTagSet;
    private final Set<Tag>  oldTagSet;

    public UpdateTagsCommand(Event event, Set<Tag> newTagSet) {
        this.event = event;
        this.oldTagSet = event.getTags();
        this.newTagSet = newTagSet;
    }

    @Override
    public void execute() {
        event.setTags(newTagSet);
    }

    @Override
    public void undo() {
        event.setTags(oldTagSet);
    }
}
