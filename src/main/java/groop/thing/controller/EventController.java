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
import java.lang.ref.ReferenceQueue;
import java.time.LocalDate;
import java.util.Arrays;

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

    @RequestMapping(value = "/addSome", method = RequestMethod.GET)
    public String addSome(Model model){
        model.addAttribute("event", new Event("e123","l123", LocalDate.now()));
        return "redirect:/event/editingPage";
    }

    @RequestMapping(value = "/addSome", method = RequestMethod.POST)
    public String addSomeSubmit(@ModelAttribute Event event){
        eventRepo.save(event);
        return "redirect:/event/editingPage";
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

/*    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteEvent(Model model) throws NoSuchFieldException {

        return "edit_event";
    }*/

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteEventSubmit(@ModelAttribute Event event){
        eventRepo.deleteById(event.getId());
        return "redirect:/event/editingPage";
    }
    @RequestMapping(value = "/deleteAll", method = RequestMethod.POST)
    public String deleteAll(){
        eventRepo.deleteAll();
        return "redirect:/event/editingPage";
    }
}
