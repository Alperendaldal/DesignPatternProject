package commands;

import enums.Category;
import event.Event;
import interfaces.Command;

public class AddCategoryCommand implements Command {
    private final Event event;

    private final Category categoryToAdd;


    public AddCategoryCommand(Event event, Category categoryToAdd) {
        this.event = event;
        this.categoryToAdd = categoryToAdd;
    }

    @Override
    public void execute() {
        boolean isSucceed = event.addCategory(categoryToAdd);
        if (isSucceed)
            System.out.printf("Category (with name %s) has added to Event (with name %s)", categoryToAdd.toString(), event.getName());
        else
            System.out.printf("Category (with name %s) is ALREADY belongs to Event (with name %s)", categoryToAdd.toString(), event.getName());

        System.out.println();
    }

    @Override
    public void undo() {
        boolean isSucceed = event.removeCategory(categoryToAdd);

        if (isSucceed)
            System.out.printf("UNDID! Category (with name %s) has removed to Event (with name %s)", categoryToAdd.toString(), event.getName());
        else
            System.out.printf("Category (with name %s) is NOT belongs to Event (with name %s)", categoryToAdd.toString(), event.getName());

        System.out.println();
    }
}
