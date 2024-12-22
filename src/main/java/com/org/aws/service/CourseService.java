package com.org.aws.service;

import com.org.aws.dto.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private static Logger logger = LoggerFactory.getLogger(CourseService.class);
    List<Course> listCourse = new ArrayList<>();

    public Course saveCourse(Course course) {
        listCourse.add(course);
        return course;
    }

    public List<Course> getAllCourseDetails() {
        return listCourse;
    }

    public Course getCourseByName(String name) {
        List<Course> course= listCourse.stream().filter(s -> s.getName().equalsIgnoreCase(name)).toList();
       if(CollectionUtils.isEmpty(course)){
           throw new RuntimeException("The Matched record found");
       }
       else {
           return  course.get(0);
       }
    }
}
