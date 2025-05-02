import enums.Category;
import enums.Tag;
import eventModules.EventRegistration;
import eventModules.Member;
import event.Event;
import eventModules.EventCreator;
import eventModules.EventManager;
import eventModules.EventModification;
import eventModules.EventSearchModule;
import searchStrategies.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

import java.util.Set;
import java.util.List;


public class Main {


    public static void printEvents(List<Event> events) {
        if (events == null || events.isEmpty()) {
            System.out.println("No events found.");
            return;
        }

        for (Event event : events) {
            System.out.println("---------------");
            System.out.println("Name: " + event.getName());
            System.out.println("Organizer: " + event.getOrganizer());
            System.out.println("Location: " + event.getLocation());
            System.out.println("Date: " + event.getDate());
            System.out.println("Time: " + event.getTime());
            System.out.println("Registration count: " + event.getRegistrationCount());

            Set<Category> categories = event.getCategories();
            if (categories != null && !categories.isEmpty()) {
                System.out.println("Categories: " + categories.stream()
                        .map(Category::toString)
                        .collect(Collectors.joining(", ")));
            }

            Set<Tag> tags = event.getTags();
            if (tags != null && !tags.isEmpty()) {
                System.out.println("Tags: " + tags.stream()
                        .map(Tag::toString)
                        .collect(Collectors.joining(", ")));
            }

            System.out.println("---------------");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EventManager manager = EventManager.getInstance();

        manager.addEvent(new Event("event", LocalDate.of(2000, 10,10), LocalTime.now(), null, null, "location", "organizer"));


        int option;

        while (true) {

            System.out.println("Welcome to ÖzDal Event Management System!");

            System.out.println();
            System.out.println();
            System.out.println();

            printEvents(manager.getEvents());

            System.out.println();
            System.out.println();
            System.out.println("1. Create Event");
            System.out.println("2. Modify Event");
            System.out.println("3. Search Event");
            System.out.println("4. Enroll for an Event");
            System.out.println("5. Exit");


            try {
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        EventCreator creator = manager.getCreator();
                        boolean creating = true;

                        while (creating) {
                            System.out.println("Event creation process has been started. Choose a field and assign its value:");
                            System.out.println("Necessary: ");
                            System.out.println("1. Name " + (creator.isHasNameFieldSet() ? "✔" : "❌"));
                            System.out.println("2. Organizer " + (creator.isHasOrganizerSet() ? "✔" : "❌"));
                            System.out.println("3. Location " + (creator.isHasLocationFieldSet() ? "✔" : "❌"));
                            System.out.println("4. Date " + (creator.isHasDateFieldSet() ? "✔" : "❌"));
                            System.out.println("5. Time " + (creator.isHasTimeFieldSet() ? "✔" : "❌"));

                            System.out.println("\nOptional:");
                            System.out.println("6. Categories");
                            System.out.println("7. Tag");

                            System.out.println("0. Complete");

                            int fieldOption = scanner.nextInt();
                            scanner.nextLine();

                            switch (fieldOption) {
                                case 1:
                                    System.out.println("Enter event name:");
                                    creator.setName(scanner.nextLine());
                                    break;
                                case 2:
                                    System.out.println("Enter organizer:");
                                    creator.setOrganizer(scanner.nextLine());
                                    break;
                                case 3:
                                    System.out.println("Enter location:");
                                    creator.setLocation(scanner.nextLine());
                                    break;
                                case 4:
                                    System.out.println("Enter date (YYYY-MM-DD):");
                                    creator.setDate(LocalDate.parse(scanner.nextLine()));
                                    break;
                                case 5:
                                    System.out.println("Enter time (HH:MM):");
                                    creator.setTime(LocalTime.parse(scanner.nextLine()));
                                    break;
                                case 6:
                                    System.out.println("Categories:");
                                    Category.printAllCategories();
                                    boolean isCategorySelection = true;

                                    while(isCategorySelection){
                                        System.out.println();
                                        System.out.println("1: Add a Category ");
                                        System.out.println("2: Remove a Category ");
                                        System.out.println("0: Exit from category process.");

                                        option = scanner.nextInt();
                                        scanner.nextLine();
                                        switch (option){
                                            case 1:
                                                String categoryString = scanner.nextLine();
                                                Category category = Category.getCategoryIfExist(categoryString);

                                                if(category == null) {
                                                    System.out.println("Category ".concat(categoryString).concat(" not found. Try again!"));
                                                    continue;
                                                }

                                                boolean isEventBelongToCategoryAlready = creator.isEventBelongToCategory(category);

                                                if(isEventBelongToCategoryAlready)
                                                {
                                                    System.out.println("Category ".concat(category.toString()) + " has already belongs to event. Try again");
                                                    continue;
                                                }

                                                creator.addCategory(category);

                                                System.out.println("Category ".concat(category.toString()).concat(" added successfully"));
                                            break;
                                            case 0:
                                                isCategorySelection = false;
                                                break;
                                        }


                                    }



                                    //TODO: Handle. creator.setCategories(categories);
                                    break;
                                case 7:
                                    System.out.println("Enter tag:");
                                    //TODO: Handle creator.setTag(scanner.nextLine());
                                    break;

                                case 0:
                                    if (creator.isReadyToBuild()) {
                                        Event newEvent = creator.build();
                                        boolean isCreated = manager.addEvent(newEvent);
                                        if (isCreated) {
                                            System.out.println("Event created successfully!");
                                            creating = false;
                                        } else
                                            System.out.println("Failed to create event. Try again.");

                                    } else
                                        System.out.println("Please fill all necessary fields before completing.");

                                    break;
                                default:
                                    System.out.println("Invalid field selection.");
                                    break;
                            }
                        }
                        break;

                    case 2:
                        EventModification modifier = manager.getEventModifier();
                        //Modification operation
                        break;

                    case 3:
                        EventSearchModule searcher = manager.getEventSearcher();
                        System.out.println("choose search options:");
                        System.out.println("Search according to name: 1");
                        System.out.println("Search according to category: 2");
                        System.out.println("Search according to date: 3");
                        System.out.println("Search according to tag: 4");
                        System.out.println("Search according to organizer: 5");
                        System.out.println("Search according to location: 6");
                        option = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter keyword");
                        String keyword = scanner.nextLine();
                        List<Event> results = new ArrayList<>();
                        switch (option) {
                            case 1:
                                searcher.setSearchMethod(new NameSearch());
                                results = searcher.search(manager.getEvents(), keyword);
                                break;
                            case 2:
                                searcher.setSearchMethod(new CategorySearch());
                                results = searcher.search(manager.getEvents(), keyword);
                                break;
                            case 3:
                                searcher.setSearchMethod(new DateSearch());
                                results = searcher.search(manager.getEvents(), keyword);

                                break;
                            case 4:
                                searcher.setSearchMethod(new TagSearch());
                                results = searcher.search(manager.getEvents(), keyword);

                                break;
                            case 5:
                                searcher.setSearchMethod(new OrganizerSearch());
                                results = searcher.search(manager.getEvents(), keyword);

                                break;
                            case 6:
                                searcher.setSearchMethod(new LocationSearch());
                                results = searcher.search(manager.getEvents(), keyword);

                                break;
                            default:
                                System.out.println("Invalid operation");
                                break;
                        }
                        for(Event result : results) System.out.println(result.getName());
                        break;

                    case 4:
                        EventRegistration registrar = manager.getEventRegistrar();

                        System.out.println("Enter your name:");
                        String name = scanner.nextLine();
                        Member member = manager.getOrCreateMember(name);

                        System.out.println("Enter your event name:");
                        while (true) {
                            String eventName = scanner.nextLine();
                            Event event = manager.getEventIfExists(eventName);
                            if (event == null) {
                                System.out.println("Invalid name try again.");
                                continue;
                            }
                            System.out.println("Registration: 1");
                            System.out.println("Cancel register: 2");
                            option = scanner.nextInt();
                            switch (option) {
                                case 1:
                                    if (!event.isMemberEnrolled(member)) {
                                        registrar.register(event, member);
                                    }else System.out.println("Member already registered");
                                    break;
                                case 2:
                                    registrar.cancel(event, member);
                                    break;
                            }
                            break;
                        }


                        break;

                    case 5:
                        scanner.close();
                        System.out.println("Closing...");
                        return;

                    default:
                        System.out.println("Invalid option, try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be a number. Try again!");
            } catch (NoSuchElementException e) {
                System.out.println("Input cannot be empty. Trey again!");
            }

        }
    }


}