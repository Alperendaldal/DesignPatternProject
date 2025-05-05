package searchStrategies;

import event.Event;
import interfaces.SearchStrategy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DateSearch implements SearchStrategy {

    @Override
    public List<Event> search(List<Event> events, String keyword) {
        LocalDate date = LocalDate.parse(keyword);
        List<Event> result = new ArrayList<>();
        for (Event event : events) {
            if (event.getDate().equals(date)) {
                result.add(event);
            }
        }
        if (result.isEmpty())
            System.out.println("Event not found");
        return result;
    }
}
