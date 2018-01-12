package models;
import java.util.ArrayList;

public class Event {
    private String content;
    private String description;
    private static ArrayList<Event> instances = new ArrayList<>();

    public Event (String content, String description){
    this.content = content;
    this.description = description;
    instances.add(this);
    }

    public String getContent() {
        return content;
    }
    public String getDescription() {
        return description;
    }

    public static ArrayList<Event> getAll(){
        return instances;
    }

    public static void clearAllPosts(){
        instances.clear();
    }
}
