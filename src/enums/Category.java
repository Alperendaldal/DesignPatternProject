package enums;

public enum Category {
    CONCERT, SEMINAR, WORKSHOP, MEETUP, NETWORKING, EXHIBITION;

    @Override
    public String toString() {
        String name = name().toLowerCase();
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}
