package searchStrategies;

import interfaces.SearchStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class CategorySearch implements SearchStrategy {
    public List<Event> search(List<Event> events, String keyword){
        return events.stream().
                filter(e -> e.getCategory().toLowerCase()
                        .contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}
