public class EventCreator {
    private Event event = new Event();

    public EventCreator setName(String name) {
        event.setName(name);
        return this;
    }

    public EventCreator setLocation(String location) {
        event.setLocation(location);
        return this;
    }

    public EventCreator setDateTime(LocalDateTime dateTime) {
        event.setDateTime(dateTime);
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

    public Event build() {
        return event;
    }
}
