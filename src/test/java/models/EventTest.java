package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    }
    @Test
    public void NewEventCorrectlyCreates_true() throws Exception {
        Event event = new Event("Welcome");
        assertEquals(true, event instanceof Event);
    }

}