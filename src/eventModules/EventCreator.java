package eventModules;
import enums.Category;
import enums.Tag;
import event.Event;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import java.util.stream.Collectors;

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

    public EventCreator setCategories(Set<Category> categories) {
        event.setCategories(categories);
        return this;
    }

    public EventCreator addCategory(Category category){
        event.addCategory(category);
        System.out.println("Categories the event currently has".concat(" ").concat(event.getCategories().stream().map(Category::toString).collect(Collectors.joining(", "))));
        return this;
    }

    public EventCreator removeCategory(Category category){
        event.removeCategory(category);
        System.out.println("Categories the event currently has".concat(" ").concat(event.getCategories().stream().map(Category::toString).collect(Collectors.joining(", "))));
        return this;
    }

    public EventCreator setTags(Set<Tag> tags) {
        event.setTags(tags);
        return this;
    }

    public EventCreator addTag(Tag tag){
        event.addTag(tag);
        System.out.println("Tags the event currently has".concat(" ").concat(event.getTags().stream().map(Tag::toString).collect(Collectors.joining(", "))));
        return this;
    }

    public EventCreator removeTag(Tag tag){
        event.removeTag(tag);
        System.out.println("Tags the event currently has".concat(" ").concat(event.getTags().stream().map(Tag::toString).collect(Collectors.joining(", "))));
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
