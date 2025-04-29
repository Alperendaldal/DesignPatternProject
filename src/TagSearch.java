import java.util.List;
import java.util.stream.Collectors;

public class TagSearch implements SearchStrategy {
    @Override
    public List<Event> search(List<Event> events, String keyword){
        return events.stream().
                filter(e -> e.getTag().toLowerCase()
                        .contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}
