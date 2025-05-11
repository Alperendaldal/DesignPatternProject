package searchStrategies;
import enums.Tag;
import event.Event;
import interfaces.SearchStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class TagSearch implements SearchStrategy {
    @Override
    public List<Event> search(List<Event> events, String keyword){
        Tag.printAllTags();
        List<Event> result = new ArrayList<>();
        for (Event event : events) {
            Set<Tag> tags = event.getTags();
            for (Tag tag : tags) {
                if (tag.isEqual(keyword)) {
                    result.add(event);
                    break;
                }
            }
        }
        if (result.isEmpty())
            System.out.println("Event not found");
        return result;
}
}
