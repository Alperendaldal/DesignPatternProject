package commands;

import event.Event;
import interfaces.Command;
import enums.Tag;

import java.util.Set;

public class AddTagCommand implements Command {
    private final Event event;
    private final Tag tagToAdd;


    public AddTagCommand(Event event, Tag tagToAdd) {
        this.event = event;
        this.tagToAdd = tagToAdd;
    }

    @Override
    public void execute() {

        boolean isSucceed = event.addTag(tagToAdd);

        if (isSucceed)
            System.out.printf("Tag (with name %s) has added to Event (with name %s)", tagToAdd.toString(), event.getName());
        else
            System.out.printf("Tag (with name %s) is ALREADY belongs to Event (with name %s)", tagToAdd.toString(), event.getName());

    }

    @Override
    public void undo() {
        boolean isSucceed = event.removeTag(tagToAdd);

        if (isSucceed)
            System.out.printf("UNDID! Tag (with name %s) has removed to Event (with name %s)", tagToAdd.toString(), event.getName());
        else
            System.out.printf("Tag (with name %s) is ALREADY NOT belongs to Event (with name %s)", tagToAdd.toString(), event.getName());

    }
}
