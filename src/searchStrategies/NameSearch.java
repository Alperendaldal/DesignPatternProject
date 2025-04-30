package searchStrategies;

import interfaces.SearchStrategy;

import java.util.ArrayList;
import java.util.List;

public class NameSearch implements SearchStrategy {
    @Override
    public List<Event> search(List<Event> events, String keyword){
        List<Event> list = new ArrayList<>();
        System.out.println(events);
        for (Event event : events){

            if(keyword.toLowerCase().equals(event.getName().toLowerCase())){list.add(event);};
        }
        return list;  /* events.stream().
                filter(e -> e.getName().toLowerCase()
                        .contains(keyword.toLowerCase()))
                .collect(Collectors.toList()); */
    }
}
