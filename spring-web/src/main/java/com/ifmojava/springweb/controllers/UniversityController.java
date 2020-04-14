package com.ifmojava.springweb.controllers;

import com.ifmojava.springweb.entity.University;
import com.ifmojava.springweb.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/university")
public class UniversityController {
//    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    public UniversityController(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showForm(Model model){
        model.addAttribute("university", new University());
        return "add_university";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute University university){
        universityRepository.save(university);
        return "redirect:/university/add";
    }

    @RequestMapping(value = "/show")
    public String showData(Model model){
        model.addAttribute("universities", universityRepository.findAll());
        return "universities";
    }

}
