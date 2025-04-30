package eventModules;

import event.Event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class EventCreator {
    private final Event event = new Event();

    public EventCreator setName(String name) {
        event.setName(name);
        return this;
    }

    public EventCreator setLocation(String location) {
        event.setLocation(location);
        return this;
    }

    public EventCreator setDate(LocalDate date) {
        event.setDate(date);
        return this;
    }

    public EventCreator setTime(LocalTime time){
        event.setTime(time);
        return this;
    }

    public EventCreator setCategories(List<String> categories) {
        event.setCategories(categories);
        return this;
    }

    public EventCreator setTags(List<String> tags) {
        event.setTags(tags);
        return this;
    }

    public EventCreator setOrganizer(String organizer){
        event.setOrganizer(organizer);
        return this;
    }

    public Event build() {
        return event;
    }
}
