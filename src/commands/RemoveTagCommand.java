package commands;

import enums.Tag;
import event.Event;
import interfaces.Command;

public class RemoveTagCommand implements Command {
    private final Event event;
    private final Tag  tagToRemove;


    public RemoveTagCommand(Event event, Tag tagToRemove) {
        this.event = event;
    this.tagToRemove = tagToRemove;
    }

    @Override
    public void execute() {

      boolean isSucceed =   event.removeTag(tagToRemove);

        if(isSucceed)
            System.out.printf("Tag (with name %s) has removed to Event (with name %s)", tagToRemove.toString(), event.getName());
        else
            System.out.printf("Tag (with name %s) has ALREADY NOT belongs to Event (with name %s)", tagToRemove.toString(), event.getName());

        System.out.println();
    }

    @Override
    public void undo() {
        boolean isSucceed =   event.addTag(tagToRemove);

        if(isSucceed)
            System.out.printf("UNDID! Tag (with name %s) has added to Event (with name %s)", tagToRemove.toString(), event.getName());
        else
            System.out.printf("Tag (with name %s) has ALREADY belongs to Event (with name %s)", tagToRemove.toString(), event.getName());

        System.out.println();
    }
}
