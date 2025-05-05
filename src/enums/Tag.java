package enums;

public enum Tag {
    FREE_ENTRY,
    ONLINE,
    FAMILY_FRIENDLY,
    PAID,
    INDOOR;

    @Override
    public String toString() {
        String name = name().toLowerCase().replace('_', ' ');
        String[] words = name.split(" ");
        StringBuilder formatted = new StringBuilder();

        for (String word : words)
            formatted.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1))
                    .append(" ");


        return formatted.toString().trim();
    }

    public boolean isEqual(String input){
        return this.toString().equalsIgnoreCase(input);
    }


    public static Tag getTagIfExists(String input) {
        if (input == null) return null;

        String normalizedInput = input.trim().toUpperCase().replace(' ', '_');

        for (Tag tag : Tag.values())
            if (tag.name().equalsIgnoreCase(normalizedInput))
                return tag;

        return null;
    }

    public static void printAllTags() {
        System.out.println("Available Tags:");
        for (Tag tag : Tag.values())
            System.out.println("- " + tag.toString());

    }
}
