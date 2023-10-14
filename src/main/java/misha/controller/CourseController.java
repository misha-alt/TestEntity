package misha.controller;


import misha.model.Course;
import misha.model.Person;
import misha.service.CourseService;
import misha.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;

@Controller
@Transactional
@RequestMapping("/course")
public class CourseController {


    private CourseService courseService;
    private PersonService personService;

    @Autowired
    public CourseController(CourseService courseService, PersonService personService) {
        this.courseService = courseService;
        this.personService = personService;
    }

    @GetMapping("/stades/{id}")
    public String courseIndex(@PathVariable("id")Long id, Model model) {

        model.addAttribute("coursess", new Course());

        Person person = personService.grtById(id);
        model.addAttribute("person", person);
        return "people/stades";
    }


    /*@PostMapping("/{id}")
    public String Create(@ModelAttribute("coursess") Course course, @PathVariable Long id) {
        courseService.add(course, id);
        return "redirect:/course";
    }*/

   /* @PatchMapping("/{id}")
    public String udate(@ModelAttribute("coursess") Course course, @PathVariable Long id) {
        courseService.add(course, id);
        return "redirect:/course";


    }*/
}
