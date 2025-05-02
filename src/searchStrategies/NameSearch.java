package searchStrategies;

import event.Event;
import interfaces.SearchStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class NameSearch implements SearchStrategy {
    @Override
    public List<Event> search(List<Event> events, String keyword){

        List<Event> list = new ArrayList<>();
        for (Event event : events){
            if(event.getName().toLowerCase().contains(keyword.toLowerCase())){list.add(event);}

        }
        return list;
    }
    public List<Event> sortByNameAscending(List<Event> events) {
        events.sort(Comparator.comparing(Event::getName, String.CASE_INSENSITIVE_ORDER));
        return events;
    }

    public List<Event> sortByNameDescending(List<Event> events) {
        events.sort(Comparator.comparing(Event::getName, String.CASE_INSENSITIVE_ORDER).reversed());
        return events;
    }
}

