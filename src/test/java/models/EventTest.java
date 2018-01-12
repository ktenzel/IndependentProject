package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDateTime;
import java.security.PublicKey;

import static org.junit.Assert.*;

public class EventTest {
    public Event setupNewEvent(){
        return new Event("Welcome", "startevent");
    }

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

}