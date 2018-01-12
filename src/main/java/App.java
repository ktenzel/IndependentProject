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
    }
}