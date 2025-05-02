package searchStrategies;

import event.Event;

import java.util.ArrayList;
import java.util.List;

public class OrganizerSearch {
    public List<Event> search(List<Event> events, Object keyword){

        List<Event> list = new ArrayList<>();
        String keywordd = keyword.toString();
        for (Event event : events){

            if(keywordd.toLowerCase().equals(event.getOrganizer().toLowerCase())){list.add(event);};
        }
        return list;
    }
}
