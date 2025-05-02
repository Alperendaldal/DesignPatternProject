package enums;

public enum Category {
    CONCERT, SEMINAR, WORKSHOP, MEETUP, NETWORKING, EXHIBITION;

    @Override
    public String toString() {
        String name = name().toLowerCase();
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public boolean isEqual(String input){
        return this.toString().equalsIgnoreCase(input);
    }

    public static void printAllCategories() {
        System.out.println("Available Categories:");
        for (Category category : Category.values())
            System.out.println("- " + category.toString());

    }
    public static Category getCategoryIfExist(String input) {
        if (input == null) return null;

        for (Category category : Category.values())
            if (category.name().equalsIgnoreCase(input.trim()))
                return category;


        return null;
    }



}
