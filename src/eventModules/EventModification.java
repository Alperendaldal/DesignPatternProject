package eventModules;

import commands.*;
import enums.Category;
import enums.Tag;
import event.Event;
import interfaces.Command;
import invoke.ModificationInvoker;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public class EventModification {
    private final ModificationInvoker invoker = new ModificationInvoker();

    public void modifyEventName(Event event, String newName) {
        Command command = new UpdateNameCommand(event, newName);
        invoker.executeCommand(command);
    }

    public void modifyEventLocation(Event event, String location){
        Command command = new UpdateLocationCommand(event, location);
        invoker.executeCommand(command);
    }
    public void addCategoryToEvent(Event event, Category categoryToAdd){
        Command command = new AddCategoryCommand(event, categoryToAdd);
        invoker.executeCommand(command);
    }
    public void removeCategoryFromEvent(Event event, Category categoryToRemove){
        Command command = new RemoveCategoryCommand(event, categoryToRemove);
        invoker.executeCommand(command);
    }

    public void modifyEventDate(Event event, LocalDate date){
        Command command = new UpdateDateCommand(event, date);
        invoker.executeCommand(command);
    }

    public void modifyEventOrganizer(Event event, String organizer){
        Command command= new UpdateOrganizerCommand(event, organizer);
        invoker.executeCommand(command);
    }


    public void addTagToEvent(Event event, Tag tagToAdded){
        Command command = new AddTagCommand(event, tagToAdded);
        invoker.executeCommand(command);
    }

    public void removeTagFromEvent(Event event, Tag tagToRemoved){
        Command command = new RemoveTagCommand(event, tagToRemoved);
        invoker.executeCommand(command);
    }

    public void modifyEventTime(Event event, LocalTime time){
        Command command = new UpdateTimeCommand(event, time);
        invoker.executeCommand(command);
    }

    public void undoLastModification() {
        invoker.undoLastCommand();
    }
}
