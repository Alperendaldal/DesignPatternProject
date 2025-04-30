package interfaces;

import java.util.List;

public interface SearchStrategy {
    List<Event> search(List<Event> events, String keyword);
}
