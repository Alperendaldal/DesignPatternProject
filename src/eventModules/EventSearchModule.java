package eventModules;

import java.util.List;

public class EventSearchModule {
    private SearchStrategy searchMethod;

    public void setSearchMethod(SearchStrategy searchMethod){
        this.searchMethod = searchMethod;
    }

    public List<Event> search(List<Event> events, String keyword) {
        if (searchMethod == null) throw new IllegalStateException("Search strategy not set.");
        return searchMethod.search(events, keyword);
    }

}
