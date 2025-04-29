import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String keyword = scanner.next().toLowerCase();
        Event event1 = new Event("concert","concert","rock","10,10,2010");
        Event event2 = new Event("concert2","concert2","rock2","10,10,2012");
        Event event3 = new Event("concert3","concert3","rock3","10,10,2013");
        List<Event> list = new ArrayList<>();
        list.add(event1);
        list.add(event2);
        list.add(event3);
        EventSearchModule searchModule = new EventSearchModule();

        //if statment
        searchModule.setSearchMethod(new NameSearch());
        List<Event> results = searchModule.search(list, keyword);
        System.out.println(results);
    }
}