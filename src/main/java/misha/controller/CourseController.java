package misha.controller;


import misha.dao.PersonDAO;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@Transactional
@RequestMapping("/course")
public class CourseController {


    private CourseService courseService;
    private PersonDAO personDAO;

    @Autowired
    public CourseController(CourseService courseService, PersonDAO personDAO) {
        this.courseService = courseService;
        this.personDAO = personDAO;
    }

    @GetMapping("/stades/{id}")
    public String courseIndex(@PathVariable("id")Long id, Model model) {



        Person person = personDAO.grtById(id);
       List<Course> list= courseService.allCourse();


       if(person.getCourseSet().isEmpty()||person.getCourseSet().equals(null)){
          model.addAttribute("courceSetEmpty", "Not course");
       }else{model.addAttribute("courceSet", person.getCourseSet());}


        model.addAttribute("person", person);
        model.addAttribute("cources",list);
        return "people/stades";
    }


    @PostMapping("/{id}")
    public String Create(@PathVariable Long id, @RequestParam("cateorySelect") Long cateorySelect) {

       Course cour = courseService.grtById(cateorySelect);
       Person person = personDAO.grtById(id);

       if(person.getCourseSet().isEmpty()||person.getCourseSet().equals(null)){
           Set<Course> set =  new HashSet<>();
           set.add(cour);
           person.setCourseSet(set);
       }else{
           person.getCourseSet().add(cour);
       }
       personDAO.edit(person);

        return "redirect:/course/stades/"+id;
    }

   /* @PatchMapping("/{id}")
    public String udate(@ModelAttribute("coursess") Course course, @PathVariable Long id) {
        courseService.add(course, id);
        return "redirect:/course";


    }*/
}
