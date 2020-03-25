package groop.thing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
//@RestController
@Controller
public class IndexControlller {

    @RequestMapping("/")
    public String index(Principal principal){
        return "index";
    }
}
