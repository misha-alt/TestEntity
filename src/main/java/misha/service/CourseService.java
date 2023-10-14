package misha.service;

import misha.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> allCourse();
   // void add(Course course, Long id);
    void delete(Course course);
    Course grtById(Long id);

}
