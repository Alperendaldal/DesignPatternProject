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
    private boolean hasNameFieldSet = false;
    private boolean hasDateFieldSet = false;
    private boolean hasTimeFieldSet = false;
    private boolean hasLocationFieldSet = false;
    private boolean hasOrganizerSet = false;

    public boolean isHasNameFieldSet() {
        return hasNameFieldSet;
    }

    public boolean isHasDateFieldSet() {
        return hasDateFieldSet;
    }

    public boolean isHasTimeFieldSet() {
        return hasTimeFieldSet;
    }

    public boolean isHasLocationFieldSet() {
        return hasLocationFieldSet;
    }

    public boolean isHasOrganizerSet() {
        return hasOrganizerSet;
    }

    public boolean isEventBelongToCategory(Category category) {
        return this.event.getCategories().contains(category);
    }

    public boolean isEventBelongToTag(Tag tag) {
        return this.event.getTags().contains(tag);
    }

    public Set<Tag> getTags() {
        return this.event.getTags();
    }

    public Set<Category> getCategories() {
        return this.event.getCategories();
    }


    public EventCreator setName(String name) {


        if (name != null && name.isEmpty()) {
            hasNameFieldSet = false;
            System.out.println("Name of the event cannot be null or invalid");
            return this;
        }
        event.setName(name);
        hasNameFieldSet = true;

        return this;
    }

    public EventCreator setLocation(String location) {
        if (location == null || location.isEmpty()) {
            System.out.println("Location of the event cannot be null or invalid!");
            hasLocationFieldSet = false;
            return this;
        }

        event.setLocation(location);
        hasLocationFieldSet = true;
        return this;
    }

    public EventCreator setDate(LocalDate date) {

        if (date == null) {
            System.out.println("Date of the event cannot be null");
            hasDateFieldSet = false;
            return this;
        }

        event.setDate(date);
        hasDateFieldSet = true;
        return this;
    }

    public EventCreator setTime(LocalTime time) {
        if (time == null) {
            System.out.println("Time of the event cannot be null");
            hasTimeFieldSet = false;
            return this;
        }
        event.setTime(time);
        hasTimeFieldSet = true;
        return this;
    }

    public EventCreator setCategories(Set<Category> categories) {
        event.setCategories(categories);
        return this;
    }

    public EventCreator addCategory(Category category) {
        final int categoryCount = event.getCategories().size();

        if (categoryCount == 3) {
            System.out.println("Max categories reached.(3)");
            return this;
        }

        event.addCategory(category);
        return this;
    }

    public EventCreator removeCategory(Category category) {
        event.removeCategory(category);
        return this;
    }

    public EventCreator setTags(Set<Tag> tags) {
        event.setTags(tags);
        return this;
    }

    public EventCreator addTag(Tag tag) {
        final int tagCount = event.getTags().size();


        if (tagCount == 3) {
            System.out.println("Max tags reached.(3)");
            return this;
        }

        event.addTag(tag);
        return this;
    }

    public EventCreator removeTag(Tag tag) {
        event.removeTag(tag);
        System.out.println("Tags the event currently has".concat(" ").concat(event.getTags().stream().map(Tag::toString).collect(Collectors.joining(", "))));
        return this;
    }


    public EventCreator setOrganizer(String organizer) {
        if (organizer == null || organizer.isEmpty()) {
            System.out.println("Organizer of the event cannot be null or invalid");
            hasOrganizerSet = false;
            return this;
        }

        event.setOrganizer(organizer);
        hasOrganizerSet = true;
        return this;
    }

    public boolean isReadyToBuild() {
        return hasOrganizerSet && hasTimeFieldSet && hasDateFieldSet && hasLocationFieldSet && hasNameFieldSet && this.event.getCategories().size() > 0 && this.event.getTags().size() > 0;
    }

    public Event build() {


        return this.isReadyToBuild() ? event : null;
    }
}
