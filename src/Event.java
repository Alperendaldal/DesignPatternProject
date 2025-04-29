public class Event {
    String name;
    String date;
    String tag;
    String category;

    public Event(String name, String category, String tag, String date) {
        this.name = name;
        this.category = category;
        this.tag = tag;
        this.date = date;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName(){
        return name;
    }
    public String getDate(/* String or date ?*/){
        return date;
    };
    public String getTag(){
        return tag;
    };
    public String getCategory(){
        return category;
    };
    //fill class


}
