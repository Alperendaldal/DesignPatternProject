import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class NameSearch implements SearchStrategy{
    @Override
    public List<Event> search(List<Event> events, String keyword){
        List<Event> list = new ArrayList<>();
        for (Event event : events){

            if(keyword.toLowerCase().equals(event.getName().toLowerCase())){list.add(event);};
        }
        return list;  /* events.stream().
                filter(e -> e.getName().toLowerCase()
                        .contains(keyword.toLowerCase()))
                .collect(Collectors.toList()); */
    }
    public List<Event> orderDesceding(List<Event> events){
        List<Event> list = new ArrayList<>();
        events.sort(Comparator.comparing(Event::getName, String.CASE_INSENSITIVE_ORDER));
        return events;
        //not working
    }

}
