import EventRegistrationModule.EventRegistration;
import EventRegistrationModule.Member;
import event.Event;
import eventModules.EventSearchModule;
import searchStrategies.NameSearch;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        /* Scanner scanner = new Scanner(System.in);
        String keyword = scanner.next().toLowerCase(); */
        Event event1 = new Event();
        Event event2 = new Event();

        LocalDate now = LocalDate.now();
        event1.setName("now3");
        event2.setName("now2");


        List<Event> list = new ArrayList<>();
        list.add(event1);
        list.add(event2);

        Member alice = new Member("Alice");
        Member bob = new Member("Bob");

        EventRegistration reg = new EventRegistration();
        reg.register(event1, alice);
        reg.register(event1, bob);
        reg.cancel(event1,bob);

        event1.changeDate(LocalDate.of(2025, 5, 1));


        EventSearchModule searchModule = new EventSearchModule();

        searchModule.setSearchMethod(new NameSearch());
        List<Event> results = searchModule.search(list, "now");

        System.out.println(results);


    }


}