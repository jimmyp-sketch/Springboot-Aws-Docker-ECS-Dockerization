package com.org.aws.controller;

import com.org.aws.dto.Course;
import com.org.aws.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    Logger logger = LoggerFactory.getLogger(CourseController.class);
    @Autowired
    private CourseService courseService;

    @PostMapping("/saveCourse")
    public ResponseEntity<Object> enrollCourse(@RequestBody @Validated Course course) {
        Course savedCourse = null;
        try {
            savedCourse = courseService.saveCourse(course);
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
        return ResponseEntity.ok(savedCourse);
    }

    @GetMapping("/getCourse")
    public ResponseEntity<Object> getCourseByName(@PathVariable String name) {
        Course course = null;
        try {
            course = courseService.getCourseByName(name);
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(course);
    }

    @GetMapping("/getAllCourse")
    public ResponseEntity<Object> getAllCourse() {
        List<Course> courseList = null;
        try {
            courseList = courseService.getAllCourseDetails();
        } catch (Exception e) {
            logger.error("There is issue in fetching all course details {}", e.getMessage());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(courseList);
    }
}
