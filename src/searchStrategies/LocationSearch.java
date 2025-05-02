package searchStrategies;

import event.Event;
import interfaces.SearchStrategy;

import java.util.ArrayList;
import java.util.List;

public class LocationSearch implements SearchStrategy {
    public List<Event> search(List<Event> events, String keyword) {

        List<Event> list = new ArrayList<>();
        for (Event event : events)
            if (event.getLocation().contains(keyword))
                list.add(event);

        return list;
    }
}
