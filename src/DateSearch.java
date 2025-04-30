import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DateSearch implements SearchStrategy{

    @Override
    public List<Event> search(List<Event> events, String keyword){
        List<Event> list = new ArrayList<>();
        for (Event event : events){
            if(keyword.toLowerCase().equals(event.getDate().toString().toLowerCase())){list.add(event);};
        }
        return list;  /* events.stream().
                filter(e -> e.getName().toLowerCase()
                        .contains(keyword.toLowerCase()))
                .collect(Collectors.toList()); */
    }
}
