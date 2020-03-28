package groop.thing.controller;

import groop.thing.entity.Event;
import groop.thing.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/event")
public class EventController {

    private EventRepo eventRepository;

    @Autowired
    public EventController(EventRepo eventRepository) {
        this.eventRepository = eventRepository;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showForm(Model model){
        model.addAttribute("event", new Event()); //html: th:object="${event}" -> controller: "event"
        return "add_event";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute Event event){
        eventRepository.save(event);
        return "redirect:/event/add";
    }

    @RequestMapping(value = "/show")
    public String showData(Model model){
        model.addAttribute("events", eventRepository.findAll());
        return "events";
    }

    @RequestMapping(value = "/events")
    public String returnToEvents(Model model){
        return "redirect:/events";
    }

}
