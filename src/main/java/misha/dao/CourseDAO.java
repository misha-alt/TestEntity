package misha.dao;



import misha.model.Course;
import misha.model.Person;

import java.util.List;

public interface CourseDAO {
    List<Course> allCourse();
   // void add(Course course, Long id);
    void delete(Course course);
    Course grtById(Long id);
}
