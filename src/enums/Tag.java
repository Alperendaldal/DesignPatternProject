package enums;

public enum Tag {
    FREE_ENTRY,
    ONLINE,
    FAMILY_FRIENDLY,
    PAID,
    INDOOR,
    OUTDOOR,
    FOOD_AVAILABLE,
    LIVE_MUSIC,
    NETWORKING_OPPORTUNITIES,
    TECH_FOCUSED,
    ARTS_AND_CULTURE,
    BEGINNER_FRIENDLY,
    ADVANCED,
    WORKSHOP_INCLUDED,
    CERTIFICATE_PROVIDED,
    COVID_SAFE,
    ACCESSIBLE,
    KIDS_FRIENDLY,
    PET_FRIENDLY,
    REGISTRATION_REQUIRED;

    @Override
    public String toString() {
        String name = name().toLowerCase().replace('_', ' ');
        String[] words = name.split(" ");
        StringBuilder formatted = new StringBuilder();

        for (String word : words) {
            formatted.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1))
                    .append(" ");
        }

        return formatted.toString().trim();
    }
}
