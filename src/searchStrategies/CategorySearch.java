import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategorySearch implements SearchStrategy{
    public List<Event> search(List<Event> events, String keyword){
    List<Event> list = new ArrayList<>();
    for (Event event : events){
        List<String> categories = new ArrayList<>();
        categories = event.getCategories();

        for (String category : categories){
            if(keyword.toLowerCase().equals(category.toLowerCase())){list.add(event);};
        }
    }

    return list;
    }
}
