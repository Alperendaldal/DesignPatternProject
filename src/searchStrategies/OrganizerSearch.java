package searchStrategies;

import event.Event;
import interfaces.SearchStrategy;

import java.util.ArrayList;
import java.util.List;

public class OrganizerSearch implements SearchStrategy {
    public List<Event> search(List<Event> events, String keyword) {

        List<Event> list = new ArrayList<>();

        for (Event event : events) {

            if (event.getOrganizer().toLowerCase().contains(keyword.toLowerCase()))
                list.add(event);

        }
        if (list.isEmpty())
            System.out.println("Event not found");
        return list;
    }
}
