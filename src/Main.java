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

        manager.addEvent(new Event("Example Event", LocalDate.of(2000, 10, 10), LocalTime.now(), new HashSet<>(), new HashSet<>(), "Example Location", "Organizer"));
        manager.addEvent(new Event("Example Event 2", LocalDate.of(2010, 12, 12), LocalTime.now(), new HashSet<>(), new HashSet<>(), "Example Location 2", "Organizer 2"));


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
            System.out.println("3. Sort by name ");
            System.out.println("4. Search Event");
            System.out.println("5. Enroll for an Event");
            System.out.println("6. Exit");


            try {
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        EventCreator creator = manager.getCreator();
                        boolean creating = true;

                        while (creating) {
                            System.out.println("Choose a field and assign its value:");
                            System.out.println();
                            System.out.println("Necessary: ");
                            System.out.println("1. Name " + (creator.isHasNameFieldSet() ? "✔" : "❌"));
                            System.out.println("2. Organizer " + (creator.isHasOrganizerSet() ? "✔" : "❌"));
                            System.out.println("3. Location " + (creator.isHasLocationFieldSet() ? "✔" : "❌"));
                            System.out.println("4. Date " + (creator.isHasDateFieldSet() ? "✔" : "❌"));
                            System.out.println("5. Time " + (creator.isHasTimeFieldSet() ? "✔" : "❌"));
                            System.out.println("6. Categories: " + "(" + creator.getCategories().size() + ") " + (!creator.getCategories().isEmpty() ? "✔" : "❌"));
                            System.out.println("7. Tags: " + "(" + creator.getTags().size() + ") " + ((!creator.getTags().isEmpty() ? "✔" : "❌")));

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
                                    while (true) {
                                        System.out.println("Enter date (YYYY-MM-DD):");
                                        String dateInput = scanner.nextLine();
                                        try {
                                            creator.setDate(LocalDate.parse(dateInput));
                                            break;
                                        } catch (Exception e) {
                                            System.out.println("Invalid date format. Please try again!");
                                        }
                                    }
                                    break;

                                case 5:
                                    while (true) {
                                        System.out.println("Enter time (HH:MM):");
                                        String timeInput = scanner.nextLine();
                                        try {
                                            creator.setTime(LocalTime.parse(timeInput));
                                            break;
                                        } catch (Exception e) {
                                            System.out.println("Invalid time format. Please try again!");
                                        }
                                    }
                                    break;

                                case 6:
                                    System.out.println("Categories:");
                                    boolean isCategorySelection = true;

                                    while (isCategorySelection) {
                                        System.out.println();
                                        System.out.println("1: Add a Category");
                                        System.out.println("2: Remove a Category");
                                        System.out.println("3: View the categories event has");
                                        System.out.println("0: Exit from category process.");

                                        option = scanner.nextInt();
                                        scanner.nextLine();
                                        switch (option) {
                                            case 1:
                                                System.out.println("Enter a category to add.");
                                                System.out.println();
                                                System.out.println("Valid categories:");
                                                Category.printAllCategories();
                                                System.out.println();
                                                String categoryString = scanner.nextLine();
                                                Category category = Category.getCategoryIfExist(categoryString);

                                                if (category == null) {
                                                    System.out.println("Category ".concat(categoryString).concat(" not found. Try again!"));
                                                    continue;
                                                }

                                                boolean isEventBelongToCategoryAlready = creator.isEventBelongToCategory(category);

                                                if (isEventBelongToCategoryAlready) {
                                                    System.out.println("Category ".concat(category.toString()) + " has already belongs to event. Try again");
                                                    continue;
                                                }

                                                creator.addCategory(category);

                                                System.out.println("Category ".concat(category.toString()).concat(" added successfully"));
                                                break;
                                            case 2:
                                                System.out.println("Categories to remove (the event currently has):");
                                                System.out.println(creator.getCategories().stream().map(Category::toString).collect(Collectors.joining(", ")));
                                                System.out.println();

                                                System.out.println("Enter category to remove: ");
                                                String categoryToRemoveString = scanner.nextLine();


                                                Category categoryToRemove = Category.getCategoryIfExist(categoryToRemoveString);

                                                if (categoryToRemove == null) {
                                                    System.out.println("Category ".concat(categoryToRemoveString).concat(" not found. Try again!"));
                                                    continue;
                                                }

                                                if (!creator.isEventBelongToCategory(categoryToRemove))
                                                    System.out.println("Category '" + categoryToRemoveString + "' is not belongs to that event.");
                                                else {
                                                    creator.removeCategory(categoryToRemove);
                                                    System.out.println("Tag '" + categoryToRemoveString + "' removed successfully.");
                                                }
                                                break;

                                            case 3:
                                                System.out.println("Categories:");
                                                String categoriesToBePrinted = creator.getCategories().stream().map(Category::toString).collect(Collectors.joining(", "));
                                                System.out.println(categoriesToBePrinted.isEmpty() ? "No categories" : categoriesToBePrinted);
                                                break;
                                            case 0:
                                                isCategorySelection = false;
                                                break;
                                        }


                                    }

                                    break;
                                case 7:
                                    boolean isTagging = true;

                                    while (isTagging) {
                                        System.out.println();
                                        System.out.println("1: Add a Tag");
                                        System.out.println("2: Remove a Tag");
                                        System.out.println("3: View All Tags");
                                        System.out.println("0: Exit from tag process.");

                                        option = scanner.nextInt();
                                        scanner.nextLine();

                                        switch (option) {
                                            case 1:
                                                System.out.println();
                                                System.out.println("Valid tags:");
                                                Tag.printAllTags();
                                                System.out.println();
                                                System.out.print("Enter tag to add: ");
                                                String tagToAddString = scanner.nextLine();

                                                Tag tagToAdd = Tag.getTagIfExists(tagToAddString);

                                                if (tagToAdd == null) {
                                                    System.out.println("Tag ".concat(tagToAddString).concat(" not found. Try again!"));
                                                    continue;
                                                }

                                                if (creator.isEventBelongToTag(tagToAdd))
                                                    System.out.println("Tag '" + tagToAddString + "' already exists.");
                                                else {
                                                    creator.addTag(tagToAdd);
                                                    System.out.println("Tag '" + tagToAddString + "' added successfully.");
                                                }
                                                break;

                                            case 2:

                                                System.out.println("Tags to remove (the event currently has):");
                                                System.out.println(creator.getTags().stream().map(Tag::toString).collect(Collectors.joining(", ")));
                                                System.out.println();

                                                System.out.print("Enter tag to remove: ");
                                                String tagToRemoveString = scanner.nextLine();

                                                Tag tagToRemove = Tag.getTagIfExists(tagToRemoveString);

                                                if (tagToRemove == null) {
                                                    System.out.println("Tag ".concat(tagToRemoveString).concat(" not found. Try again!"));
                                                    continue;
                                                }

                                                if (!creator.isEventBelongToTag(tagToRemove))
                                                    System.out.println("Tag '" + tagToRemoveString + "' not belongs to that event.");
                                                else {
                                                    creator.removeTag(tagToRemove);
                                                    System.out.println("Tag '" + tagToRemoveString + "' removed successfully.");
                                                }
                                                break;

                                            case 3:
                                                System.out.println("Tags:");
                                                System.out.println(creator.getTags().stream().map(Tag::toString).collect(Collectors.joining(", ")));
                                                break;

                                            case 0:
                                                isTagging = false;
                                                break;

                                            default:
                                                System.out.println("Invalid option. Try again.");
                                        }
                                    }

                                    break;


                                case 0:
                                    if (creator.isReadyToBuild()) {
                                        Event newEvent = creator.build();
                                        boolean isCreated = manager.addEvent(newEvent);
                                        if (isCreated) {
                                            System.out.println("Event created successfully!");
                                            creating = false;
                                            break;
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

                        System.out.println("Enter the name of the event to modify:");
                        String eventToModifyName = scanner.nextLine();

                        Event eventToModify = manager.getEventIfExists(eventToModifyName);

                        if (eventToModify == null) {
                            System.out.println("Event not found. Returning to main menu...");
                            continue;
                        }


                        System.out.println("Event found!");

                        boolean isModifyingModeActive = true;

                        while (isModifyingModeActive) {
                            System.out.println("1. Modify the Name of Event");
                            System.out.println("2. Modify the Organizer of Event");
                            System.out.println("3. Modify the Location of Event");
                            System.out.println("4. Modify the Date of Event");
                            System.out.println("5. Modify the Time of Event");
                            System.out.println("6. Add category to the Event");
                            System.out.println("7. Remove category from the Event");
                            System.out.println("8. Add tag to the Event");
                            System.out.println("9. Remove tag from the Event");
                            System.out.println("10. Undo the previous process");
                            System.out.println("0. Exit");


                            int modifyOption = scanner.nextInt();
                            scanner.nextLine();

                            switch (modifyOption) {
                                case 1:
                                    System.out.println("Enter new name:");
                                    modifier.modifyEventName(eventToModify, scanner.nextLine());
                                    break;
                                case 2:
                                    System.out.println("Enter new organizer:");
                                    modifier.modifyEventOrganizer(eventToModify, scanner.nextLine());
                                    break;
                                case 3:
                                    System.out.println("Enter new location:");
                                    modifier.modifyEventLocation(eventToModify, scanner.nextLine());
                                    break;
                                case 4:
                                    System.out.println("Enter new date (YYYY-MM-DD):");
                                    modifier.modifyEventDate(eventToModify, LocalDate.parse(scanner.nextLine()));
                                    break;
                                case 5:
                                    System.out.println("Enter new time (HH:MM):");
                                    modifier.modifyEventTime(eventToModify, LocalTime.parse(scanner.nextLine()));
                                    break;
                                case 6:
                                    Category.printAllCategories();
                                    System.out.println("Enter category to add:");
                                    Category catToAdd = Category.getCategoryIfExist(scanner.nextLine());
                                    if (catToAdd != null)
                                        modifier.addCategoryToEvent(eventToModify, catToAdd);
                                    else
                                        System.out.println("Invalid category.");
                                    continue;
                                case 7:
                                    System.out.println("Categories assigned to event: " +
                                            eventToModify.getCategories().stream().map(Category::toString).collect(Collectors.joining(", ")));
                                    System.out.println("Enter category to remove:");
                                    Category catToRemove = Category.getCategoryIfExist(scanner.nextLine());
                                    if (catToRemove != null)
                                        modifier.removeCategoryFromEvent(eventToModify, catToRemove);
                                    else
                                        System.out.println("Invalid category.");
                                    continue;
                                case 8:
                                    System.out.println("Available tags:");
                                    Tag.printAllTags();
                                    System.out.println("Enter tag to add:");
                                    Tag tagToAdd = Tag.getTagIfExists(scanner.nextLine());
                                    if (tagToAdd != null)
                                        modifier.addTagToEvent(eventToModify, tagToAdd);
                                    else
                                        System.out.println("Invalid tag. Try again");
                                    continue;
                                case 9:
                                    System.out.println("Tags assigned to event: " +
                                            eventToModify.getTags().stream().map(Tag::toString).collect(Collectors.joining(", ")));

                                    System.out.println("Enter tag to remove:");

                                    Tag tagToRemove = Tag.getTagIfExists(scanner.nextLine());

                                    if (tagToRemove != null)
                                        modifier.removeTagFromEvent(eventToModify, tagToRemove);
                                    else
                                        System.out.println("Invalid tag. Try again.");
                                    continue;

                                case 10:
                                    modifier.undoLastModification();
                                    break;
                                case 0:
                                    isModifyingModeActive = false;
                                    break;
                                default:
                                    System.out.println("Invalid selection.");
                                    break;
                            }

                        }
                        break;

                    case 3:
                        System.out.println("Choose ascending or descending order:");
                        System.out.println("Ascending order: 1");
                        System.out.println("Descending order: 2");
                        List<Event> result = new ArrayList<>();
                        NameSearch nameSearch = new NameSearch();
                        option = scanner.nextInt();
                        switch (option){
                            case 1:
                                result = nameSearch.sortByNameAscending(manager.getEvents());
                                break;
                            case 2:
                                result = nameSearch.sortByNameDescending(manager.getEvents());
                                break;
                            default:
                                System.out.println("Invalid operation");
                                break;
                        }
                        printEvents(result);
                        break;

                    case 4:
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

                        printEvents(results);
                        break;

                    case 5:
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

                                    } else {
                                        System.out.println("Member already registered");
                                    }
                                    System.out.println("Press enter...");
                                    scanner.nextLine();
                                    break;
                                case 2:
                                    registrar.cancel(event, member);
                                    System.out.println("Press enter...");
                                    scanner.nextLine();
                                    break;
                            }
                            break;
                        }


                        break;

                    case 6:

                        System.out.println("Closing...");
                        return;

                    default:

                        System.out.println("Invalid option, try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be a number. Try again!");
                scanner.nextLine();


            } catch (NoSuchElementException e) {
                System.out.println("Input cannot be empty. Trey again!");

                scanner.nextLine();

            } catch (Exception e) {
                System.out.println("Something went wrong. Try again.");

                scanner.nextLine();
            } finally {
                System.out.println("Press Enter to continue...");
                scanner.nextLine();

            }
        }
    }


}