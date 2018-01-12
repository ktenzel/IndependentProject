package models;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Event {
    private String content;
    private String description;
    private static ArrayList<Event> instances = new ArrayList<>();
    private boolean published;
    private LocalDateTime createdAt;

    public Event (String content, String description){
    this.content = content;
    this.description = description;
    this.createdAt = LocalDateTime.now();
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
    public boolean getPublished(){
        return this.published;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
