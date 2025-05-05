package event;

import enums.Category;
import enums.Tag;
import interfaces.Observer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Event {
    String name;
    LocalDate date;
    LocalTime time;
    Set<Tag> tags = new HashSet<>();
    Set<Category> categories = new HashSet<>();
    String location;
    String organizer;
    private final HashSet<Observer> observers =  new HashSet<>();

    public Event(){

    }

    public Event(String name, LocalDate date, LocalTime time, Set<Tag> tags, Set<Category> categories, String location, String organizer) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.tags = tags;
        this.categories = categories;
        this.location = location;
        this.organizer = organizer;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public boolean addTag(Tag tag){
        return this.tags.add(tag);
    }

    public boolean removeTag(Tag tag){
        return this.tags.remove(tag);
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public boolean addCategory(Category category){
        return this.categories.add(category);
    }

    public boolean removeCategory(Category category){
        return this.categories.remove(category);
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public String getLocation() {
        return location;
    }


    public void setLocation(String location) {
        this.location = location;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
    public void changeDate(LocalDate newDate) {
        this.date = newDate;
        notifyObservers("The date for event '" + name + "' has been updated to " + newDate);
    }

    public HashSet<Observer> getObservers() {
        return observers;
    }

    public int getRegistrationCount() {
        return observers.size();
    }

    public boolean isMemberEnrolled(Observer o){
        return this.getObservers().contains(o);
    }


}
