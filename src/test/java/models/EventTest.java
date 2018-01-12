package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.security.PublicKey;

import static org.junit.Assert.*;

/**
 * Created by Guest on 1/12/18.
 */
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
        Event event = new Event("Welcome");
        assertEquals(true, event instanceof Event);
    }
    @Test
    public void NewEventGetsContent() throws Exception {
        Event event = new Event("Welcome");
        assertEquals("Welcome", event.getContent());
    }


    @Test
    public void GetsEachNewEvent_true() {
        Event event = new Event("Welcome");
        Event otherEvent = new Event("Lunch");
        assertEquals(2, Event.getAll().size());
    }
    @Test
    public void EventArrayContainsAllEvents_true() {
        Event event = new Event("Welcome");
        Event otherEvent = new Event("Lunch");
        assertTrue(Event.getAll().contains(event));
        assertTrue(Event.getAll().contains(otherEvent));
    }

}