package searchStrategies;

import enums.Category;
import enums.Tag;
import event.Event;
import interfaces.SearchStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TagSearch implements SearchStrategy {
    @Override
    public List<Event> search(List<Event> events, Object keyword){
        List<Event> result = new ArrayList<>();
        for (Event event : events) {
            Set<Tag> tags = event.getTags();
            for (Tag tag : tags) {
                if (keyword == tag) {
                    result.add(event);
                    break;
                }
            }
        }
        return result;
}
}
