package interfaces;

import event.Event;

import java.util.List;
import java.util.Objects;

public interface SearchStrategy {
    List<Event> search(List<Event> events, Object keyword);
}
