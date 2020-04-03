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

import javax.persistence.Id;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/event")
public class EventController {

    private EventRepo eventRepo;

    @Autowired
    public EventController(EventRepo eventRepository) {
        this.eventRepo = eventRepository;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showForm(Model model){
        model.addAttribute("event", new Event());
        return "add_event";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String submitAddForm(@ModelAttribute Event event){
        eventRepo.save(event);
        return "redirect:/event/add";
    }

    @RequestMapping(value = "/show")
    public String showData(Model model){
        model.addAttribute("events", eventRepo.findAll());
        return "events";
    }

    @RequestMapping(value = "/editingPage")
    public String showDataForEditing(Model model){
        model.addAttribute("edit_event",eventRepo.findAll());
        return "edit_event";
    }

/*    @RequestMapping(value = "/editingPage")
    public String editData(Model model){
        model.addAttribute("edit_event", eventRepo.findAll());
        return "edit_event";
    }*/

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteEvent(Model model){
        //eventRepo.deleteById(event.getId());

        System.out.println(eventRepo.count());
        return "redirect:/";
    }
}
