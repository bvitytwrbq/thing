package groop.thing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
//@RestController
@Controller
public class IndexControlller {

    @RequestMapping("/")
    public String index(Principal principal){
        return "index";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String viewPage(){
        return "view";
    }

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public String eventsPage(){
        return "events";
    }

    @RequestMapping(value = "/add_event", method = RequestMethod.GET)
    public String addEvent(){return "add_event";}
}
