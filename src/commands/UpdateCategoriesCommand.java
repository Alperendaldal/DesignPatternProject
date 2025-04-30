package commands;

import event.Event;
import interfaces.Command;

public class UpdateCategoriesCommand implements Command {
    private final Event event;
    private final String newCategory;

    public UpdateCategoriesCommand(Event event, String newCategory) {
        this.event = event;
        this.newCategory = newCategory;
    }

    @Override
    public void execute() {
        event.getTags().add(newCategory);
    }

    @Override
    public void undo() {
        event.getTags().remove(newCategory);
    }
}
