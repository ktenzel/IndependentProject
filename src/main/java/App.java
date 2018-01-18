import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import models.Event;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");


        get("/events/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Event.clearAllEvents();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/events/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "newevent-form.hbs");
                }, new HandlebarsTemplateEngine());


        post("/events/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String content = request.queryParams("content");
            String description = request.queryParams("description");

            Event newEvent = new Event(content, description);
            model.put("events", newEvent);
            model.put("description", newEvent);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Event> events = Event.getAll();
            model.put("events", events);

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/events/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfEventToFind = Integer.parseInt(req.params("id"));
            Event foundEvent = Event.findById(idOfEventToFind);
            model.put("event", foundEvent);
            return new ModelAndView(model, "event-details.hbs");
        }, new HandlebarsTemplateEngine());


        get("/events/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfPostToEdit = Integer.parseInt(req.params("id"));
            Event editEvent = Event.findById(idOfPostToEdit);
            model.put("editEvent", editEvent);
            return new ModelAndView(model, "newevent-form.hbs");
        }, new HandlebarsTemplateEngine());


        post("/events/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String newContent = req.queryParams("content");
            String newDescription = req.queryParams("description");
            int idOfEventToEdit = Integer.parseInt(req.params("id"));
            Event editEvent = Event.findById(idOfEventToEdit);
            editEvent.update(newContent, newDescription);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        get("/events/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfEventToDelete = Integer.parseInt(req.params("id"));
            Event deleteEvent = Event.findById(idOfEventToDelete);
            deleteEvent.deleteEvent();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        get("/events/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfEventToFind = Integer.parseInt(req.params("id"));
            Event foundEvent = Event.findById(idOfEventToFind);
            model.put("event", foundEvent);
            return new ModelAndView(model, "event-details.hbs");
        }, new HandlebarsTemplateEngine());



    }
}