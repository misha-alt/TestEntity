package misha.controller;


import jakarta.validation.Valid;
import misha.model.Person;
import misha.service.PersonService;
import misha.service.PersonServiceImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;

@Controller
@Transactional
@RequestMapping("/people")
public class PipleController {


private PersonService personService;

    @Autowired
    public PipleController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String index (Model model){
        model.addAttribute("people", personService.allPerson());

        return "people/index";
    }
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String addd(Model model){
        model.addAttribute("person", new Person());
        return "people/new";
    }
    @RequestMapping()
    public ModelAndView create (@ModelAttribute("person") Person person){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/people");
        personService.add(person);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public String edit (@PathVariable("id") int id, Model model){
        Person person  = personService.grtById(id);
        model.addAttribute("person",person);
        return "people/edit";

    }

   /* @GetMapping("/{id}")
    public String edit (@PathVariable("id") int id, Model model){
        Person person  = personService.grtById(id);
        model.addAttribute("person",person);
        return "people/edit";

    }
    @RequestMapping(value = "/people/{id}")
    public String udate(@ModelAttribute("person") Person person){
        personService.edit(person);
        return "redirect:/people";


    }

    @RequestMapping()
    public ModelAndView create (@ModelAttribute("person") Person person){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/people");
        personService.add(person);
        return modelAndView;
    }*/
}
