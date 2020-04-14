package com.ifmojava.springweb.controllers;

import com.ifmojava.springweb.entity.Event;
import com.ifmojava.springweb.entity.Student;
import com.ifmojava.springweb.entity.University;
import com.ifmojava.springweb.repository.EventRepository;
import com.ifmojava.springweb.repository.StudentRepository;
import com.ifmojava.springweb.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
    private EventRepository eventRepository;
    private UniversityRepository universityRepository;
    private StudentRepository studentRepository;

    @Autowired
    public StudentController(EventRepository eventRepository, UniversityRepository universityRepository, StudentRepository studentRepository) {
        this.eventRepository = eventRepository;
        this.universityRepository = universityRepository;
        this.studentRepository = studentRepository;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showForm(Model model){
        model.addAttribute("universities", universityRepository.findAll());
        model.addAttribute("events", eventRepository.findAll());
        model.addAttribute("student", new Student());
        return "add_student";
    }

/*    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String submitForm(
            @ModelAttribute Student student,
            @RequestParam(name = "universityId") int universityId,
            @RequestParam(name = "eventId") int eventId
        )
    {
        University university =
                universityRepository.findById(universityId).get();
        Event event = eventRepository.findById(eventId).get();

        student.getEvents().add(event);
        student.setUniversity(university);

        university.getStudents().add(student);
        event.getStudents().add(student);
        studentRepository.save(student);
        return "redirect:/student/add";
    }*/

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String submitForm(
            @ModelAttribute Student student,
            @RequestParam(name = "universityId") int universityId
    )
    {
        universityRepository.deleteById(universityId);
        return "redirect:/student/add";
    }




}
