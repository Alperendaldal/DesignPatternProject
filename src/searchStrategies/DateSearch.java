package searchStrategies;

import event.Event;
import interfaces.SearchStrategy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DateSearch implements SearchStrategy {

    @Override
    public List<Event> search(List<Event> events, Object keyword) {
        List<Event> result = new ArrayList<>();
        for (Event event : events) {
            if (event.getDate().equals(keyword)) {
                result.add(event);
            }
        }
        return result;
    }
}
