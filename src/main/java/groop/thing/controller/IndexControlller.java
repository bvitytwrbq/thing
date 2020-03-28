package groop.thing.controller;

import groop.thing.entity.Event;
import groop.thing.entity.Location;
import groop.thing.repo.EventRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
//@RestController
@Controller
public class IndexControlller {

    @RequestMapping("/")
    public String index(Principal principal) {
        return "index";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String viewingPage() {
        return "viewing";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addingPage() {
        return "adding";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editingPage() {
        return "editing";
    }

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public String eventsPage() {
        return "events";
    }

    @RequestMapping(value = "/locations", method = RequestMethod.GET)
    public String locationsPage(){
        return "locations";
    }

    @RequestMapping(value = "/add_location", method = RequestMethod.GET)
    public String addLocation(Model model) {
        model.addAttribute("location", new Location());
        return "add_location";
    }

    @RequestMapping(value = "/add_event", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("event", new Event()); //html: th:object="${event}" -> controller: "event"
        return "add_event";
    }
}
