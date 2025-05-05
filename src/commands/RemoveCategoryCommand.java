package commands;

import enums.Category;
import event.Event;
import interfaces.Command;

public class RemoveCategoryCommand implements Command {
    private final Event event;
    private final Category categoryToRemove;

    public RemoveCategoryCommand(Event event, Category categoryToRemove) {
        this.event = event;
        this.categoryToRemove = categoryToRemove;
    }

    @Override
    public void execute() {
        boolean isSucceed = event.removeCategory(categoryToRemove);

        if (isSucceed)
            System.out.printf("Category (with name %s) has removed to Event (with name %s)", categoryToRemove.toString(), event.getName());
        else
            System.out.printf("Category (with name %s) is ALREADY NOT belongs to Event (with name %s)", categoryToRemove.toString(), event.getName());

        System.out.println();
    }

    @Override
    public void undo() {
        boolean isSucceed = event.addCategory(categoryToRemove);

        if (isSucceed)
            System.out.printf("UNDID! Category (with name %s) has added to Event (with name %s)", categoryToRemove.toString(), event.getName());
        else
            System.out.printf("Category (with name %s) is ALREADY belongs to Event (with name %s)", categoryToRemove.toString(), event.getName());

        System.out.println();
    }
}
