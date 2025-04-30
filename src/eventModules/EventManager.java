package eventModules;

import event.Event;

import java.util.ArrayList;
import java.util.List;


public class EventManager {
    private static EventManager instance;
    private final List<Event> events = new ArrayList<>();
    private final EventCreator creator = new EventCreator();
    private final EventModification eventModifier = new EventModification();
    private final EventRegistration eventRegistrar = new EventRegistration();

    private final EventSearchModule eventSearcher = new EventSearchModule();


    private EventManager() {}

    public static EventManager getInstance() {
        if (instance == null) {
            synchronized (EventManager.class) {
                if (instance == null) {
                    instance = new EventManager();
                }
            }
        }
        return instance;
    }


    public List<Event> getEvents() {
        return events;
    }

    public EventCreator getCreator() {
        return creator;
    }

    public EventModification getEventModifier() {
        return eventModifier;
    }

    public EventRegistration getEventRegistrar() {
        return eventRegistrar;
    }

    public EventSearchModule getEventSearcher() {
        return eventSearcher;
    }
}
