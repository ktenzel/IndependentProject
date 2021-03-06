package models;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Event {
    private String content;
    private String description;
    private static ArrayList<Event> instances = new ArrayList<>();

    private LocalDateTime createdAt;
    private int id;

    public Event (String content, String description){
    this.content = content;
    this.description = description;
    this.createdAt = LocalDateTime.now();
    instances.add(this);
    this.id = instances.size();
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

    public static void clearAllEvents(){
        instances.clear();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public int getId() {
        return id;
    }

    public static Event findById(int id) {
        return instances.get(id-1);
    }
    public void update(String content, String description) {
        this.content = content;
        this.description = description;
    }
    public void deleteEvent() {
        instances.remove(id-1);
    }
}
