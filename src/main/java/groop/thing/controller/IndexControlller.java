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

}
