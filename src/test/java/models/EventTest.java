package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class EventTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Event.clearAllPosts();
    }

    @Test
    public void NewEventCorrectlyCreates_true() throws Exception {
        Event event = new Event("Welcome", "");
        assertEquals(true, event instanceof Event);
    }

    @Test
    public void NewEventGetsContent() throws Exception {
        Event event = new Event("Welcome", "");
        assertEquals("Welcome", event.getContent());
    }

    @Test
    public void NewEventGetDEscription() throws Exception {
        Event event = new Event("Welcome", "");
        assertEquals("", event.getDescription());
    }

    @Test
    public void GetsEachNewEvent_true() {
        Event event = new Event("Welcome", "");
        Event otherEvent = new Event("Lunch", "time for lunch");
        assertEquals(2, Event.getAll().size());
    }

    @Test
    public void EventArrayContainsAllEvents_true() {
        Event event = new Event("Welcome", "");
        Event otherEvent = new Event("Lunch", "time for lunch");
        assertTrue(Event.getAll().contains(event));
        assertTrue(Event.getAll().contains(otherEvent));
    }

    @Test
    public void getPublished_inFalseByDefault_false() throws Exception {
        Event myEvent = new Event("Welcome", "");
        assertEquals(false, myEvent.getPublished());
    }
    @Test
    public void getCreatedAt_stampsCurrentTime() throws Exception {
        Event myEvent = setupNewEvent();
        assertEquals(LocalDateTime.now().getDayOfWeek(), myEvent.getCreatedAt().getDayOfWeek());
    }

    @Test
    public void getId_numberEachPostStartingWith_1() throws Exception{
        Event.clearAllPosts();
        Event myEvent = setupNewEvent();
        assertEquals(1, myEvent.getId());
    }

    @Test
    public void testForSecondEventOccurance() throws Exception{
        Event event = setupNewEvent();
        Event secondEvent = new Event("Lunch", "time for lunch");
        assertEquals(2, Event.findById(secondEvent.getId()).getId());
    }

    public Event setupNewEvent(){
        return new Event("Welcome", "start event");
    }

    @Test
    public void updateChangesPostContent() throws Exception {
        Event post = setupNewEvent();
        String formerContent = post.getContent();
        LocalDateTime formerDate = post.getCreatedAt();
        int formerId = post.getId();

        post.update("Second Event", "second description");

        assertEquals(formerId, post.getId());
        assertEquals(formerDate, post.getCreatedAt());
        assertNotEquals(formerContent, post.getContent());
    }


    @Test
    public void deleteDeletesASpecificEvents() throws Exception {
        Event event = setupNewEvent();
        Event otherEvent = new Event("How to pair successfully", "");
        event.deleteEvent();
        assertEquals(1, Event.getAll().size()); //one is left
        assertEquals(Event.getAll().get(0).getId(), 2); //the one that was deleted has the id of 2. Why do we care?
    }

    @Test
    public void deleteAllEvents() throws Exception {
        Event event = setupNewEvent();
        Event otherEvent = setupNewEvent();

        Event.clearAllPosts();
        assertEquals(0, Event.getAll().size());
    }

}