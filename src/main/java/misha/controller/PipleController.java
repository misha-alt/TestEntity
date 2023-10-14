package misha.controller;


import jakarta.validation.Valid;
import misha.dao.CourseDAO;
import misha.dao.PersonDAO;
import misha.model.Course;
import misha.model.Person;
import misha.service.CourseService;
import misha.service.PersonService;
import misha.service.PersonServiceImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@Transactional
@RequestMapping("/people")
public class PipleController {

    private PersonService personService;
    private CourseService courseService;
    private CourseDAO courseDAO;
    private PersonDAO personDAO;

    @Autowired
    public PipleController(PersonService personService, CourseDAO courseDAO,PersonDAO personDAO, CourseService courseService) {
        this.personService = personService;
        this.courseService = courseService;
        this.courseDAO = courseDAO;
        this.personDAO = personDAO;

    }

    @GetMapping
    public String index (Model model){
        List <Person> personList = personService.allPerson();

        model.addAttribute("people", personList);




        return "people/index";
    }

    @GetMapping( "/new")
    public String addd(Model model){
        model.addAttribute("person", new Person() );
        return "people/new";
    }

    @PostMapping()
    public ModelAndView create (@ModelAttribute("person") Person person){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/people");
        personService.add(person);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public String edit (@PathVariable("id") Long id, Model model,HttpSession session){
        Person person  = personService.grtById(id);
        List<Course> courseList = courseDAO.allCourse();

        Set<Course> personCourseSet = person.getCourseSet();
        session.setAttribute("testObject", personCourseSet);



        model.addAttribute("person",person);
        model.addAttribute("courseList", courseList);


        return "people/edit";
    }


    @PatchMapping("/update/{id}")
    public String udate(@ModelAttribute("person") Person person, @PathVariable Long id, @RequestParam("corce")Long corce, Model model, HttpSession session){

       Course course = courseService.grtById(corce);
        Set<Course> personCourseSet = (Set)session.getAttribute("testObject");
        Set<Course> courseSet =new HashSet<>();


        person.setCourseSet(personCourseSet);
        person.getCourseSet().add(course);
       /* if(person.getCourseSet()==null){
            courseSet.add(course);
            person.setCourseSet(courseSet);
        }else{
            person.getCourseSet().add(course);
        }*/

        personDAO.edit(person);

        return "redirect:/people";
    }



    @GetMapping("/show/{id}")
    public String showPersonDetale(@PathVariable Long id, Model model){
        Person person =personService.grtById(id);

        Set<Course> courseSet = person.getCourseSet();

        model.addAttribute("person",person);


        model.addAttribute("course", courseSet);

        return "people/show";
    }
    /*@GetMapping("/test/{id}")
    public String testController (Model model,@ModelAttribute("person") Person person,@PathVariable Long id2, @RequestParam("couce") Long id){
        Course course = courseDAO.grtById(id);
        model.addAttribute("cource",course.getCourses());
        return "test";
    }*/



   /* @GetMapping("/{id}")
    public String edit (@PathVariable("id") int id, Model model){
        Person person  = personService.grtById(id);
        model.addAttribute("person",person);
        return "people/edit";

    }


    @RequestMapping()
    public ModelAndView create (@ModelAttribute("person") Person person){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/people");
        personService.add(person);
        return modelAndView;
    }*/
}
