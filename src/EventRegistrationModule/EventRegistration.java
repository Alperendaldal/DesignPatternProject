package EventRegistrationModule;
import event.Event;

public class EventRegistration {
    public void register(Event event, Member member) {
        event.registerObserver(member);
        System.out.println(member.getName() + " registered to " + event.getName());
    }

    public void cancel(Event event, Member member) {
        event.removeObserver(member);
        System.out.println(member.getName() + " canceled registration from " + event.getName());
    }
}
