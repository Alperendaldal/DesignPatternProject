import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TagSearch implements SearchStrategy {
    @Override
    public List<Event> search(List<Event> events, String keyword){
        List<Event> list = new ArrayList<>();
        for (Event event : events){
            List<String> tags = new ArrayList<>();
            tags = event.getTags();

            for (String tag : tags){
                if(keyword.toLowerCase().equals(tag.toLowerCase())){list.add(event);};
        }
    }

        return list;


        /* events.stream().
                filter(e -> e.getTag().toLowerCase()
                        .contains(keyword.toLowerCase()))
                .collect(Collectors.toList());  */
    }
}
