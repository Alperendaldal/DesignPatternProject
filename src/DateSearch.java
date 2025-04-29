import java.util.List;
import java.util.stream.Collectors;

public class DateSearch implements SearchStrategy{

    @Override
    public List<Event> search(List<Event> events, String keyword) {
        return events.stream()
                .filter(e -> e.getDate().toString().equals(keyword))
                .collect(Collectors.toList());
    }
}
