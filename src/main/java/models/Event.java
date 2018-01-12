package models;
import java.util.ArrayList;

public class Event {
    private String content;
    private static ArrayList<Event> instances = new ArrayList<>();

    public Event (String content){
    this.content = content;
    instances.add(this);
    }

    public String getContent() {
        return content;
    }

    public static ArrayList<Event> getAll(){
        return instances;
    }

    public static void clearAllPosts(){
        instances.clear();
    }
}
