package searchStrategies;

import event.Event;
import interfaces.SearchStrategy;

import java.util.ArrayList;
import java.util.List;

public class LocationSearch implements SearchStrategy {
    public List<Event> search(List<Event> events, Object keyword){

        List<Event> list = new ArrayList<>();
        String keywordd = keyword.toString();
        for (Event event : events){


            if(keywordd.toLowerCase().equals(event.getLocation().toLowerCase())){list.add(event);};
        }
        return list;
    }
}
