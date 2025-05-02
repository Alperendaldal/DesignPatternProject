package eventModules;

import event.Event;

import java.util.*;


public class EventManager {
    private static EventManager instance;
    private final List<Event> events = new ArrayList<>();
    private final EventCreator creator = new EventCreator();
    private final EventModification eventModifier = new EventModification();
    private final EventRegistration eventRegistrar = new EventRegistration();
    private final EventSearchModule eventSearcher = new EventSearchModule();
    private final HashSet<Member> members = new HashSet<>();


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

    public Set<Member> getMembers() {
        return members;
    }
    public boolean addMember(Member m){
        return members.add(m);
    }

    public Member getOrCreateMember(String name){
        Member existingMember = this.getMembers().stream().filter(t -> Objects.equals(t.getName(), name)).findFirst().orElse(null);

        if(existingMember != null)
            return existingMember;

        Member newMember = new Member(name);
        this.getMembers().add(newMember);
        return newMember;
    }


    public List<Event> getEvents() {
        return events;
    }

    public EventCreator getCreator() {
        return creator;
    }

    public boolean addEvent(Event e){
        return this.getEvents().add(e);
    }

    public Event getEventIfExists(String name) {
        return this.getEvents().stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
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
