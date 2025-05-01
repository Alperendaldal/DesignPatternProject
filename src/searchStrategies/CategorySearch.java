package searchStrategies;

import enums.Category;
import event.Event;
import interfaces.SearchStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class CategorySearch implements SearchStrategy {

    public List<Event> search(List<Event> events, Object keyword){
        List<Event> result = new ArrayList<>();
        for (Event event : events) {
            Set<Category> categories = event.getCategories();
            for (Category category : categories) {
                if (keyword == category) {
                    result.add(event);
                    break;
                }
            }
        }
        return result;
}
}
