package groop.thing.controller;

import groop.thing.entity.Event;
import groop.thing.entity.Location;
import groop.thing.repo.EventRepo;
import groop.thing.repo.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/location")
public class LocationController {

    private EventRepo eventRepo;
    private LocationRepo locationRepo;

    @Autowired
    public LocationController(LocationRepo locationRepo) {
        this.locationRepo = locationRepo;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showForm(Model model){
        model.addAttribute("location", new Location()); //html: th:object="${event}" -> controller: "event"
        return "add_location";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute Location location, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("confirmError","passwords don't match");
            return "add_location";
        }
        locationRepo.save(location);
        return "redirect:/location/add";
    }

    @RequestMapping(value = "/show")
    public String showData(Model model){
        model.addAttribute("locations", locationRepo.findAll());
        return "locations";
    }

    @RequestMapping(value = "/location")
    public String returnToLocations(Model model){
        return "redirect:/locations";
    }
}
