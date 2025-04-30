package commands;

import enums.Category;
import event.Event;
import interfaces.Command;

import java.util.Set;

public class UpdateCategoriesCommand implements Command {
    private final Event event;

    private final Set<Category> oldCategory;
    private final Set<Category> newCategory;

    public UpdateCategoriesCommand(Event event, Set<Category> categorySet) {
        this.event = event;
        this.oldCategory = event.getCategories();
        this.newCategory = categorySet;
    }

    @Override
    public void execute() {
        event.setCategories(newCategory);
    }

    @Override
    public void undo() {
        event.setCategories(oldCategory);
    }
}
