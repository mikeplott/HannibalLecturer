package com.theironyard.contollers;

import com.theironyard.entities.Lecturer;
import com.theironyard.entities.Review;
import com.theironyard.services.LecturerRepository;
import com.theironyard.services.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by michaelplott on 10/26/16.
 */
@RestController
public class HannibalLecturerController {
    @Autowired
    LecturerRepository lecturers;

    @Autowired
    ReviewRepository reviews;

    @RequestMapping(path = "/lecturers", method = RequestMethod.GET)
    public List<Lecturer> getLecturers() {
        return lecturers.findAll();
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.GET)
    public List<Review> getReviews() {
        return reviews.findAll();
    }

    @RequestMapping(path = "/lecturers", method = RequestMethod.POST)
    public void addLecturer(String name, String topic, String image) {
        lecturers.save(new Lecturer(name, topic, image));
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.POST)
    public void addReview(String author, String text, int lecturerId, boolean isGood) {
        Lecturer l = lecturers.findOne(lecturerId);
        reviews.save(new Review(author, text, isGood, l));
    }
}
