package com.theironyard.services;

import com.theironyard.entities.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by michaelplott on 10/26/16.
 */
public interface ReviewRepository extends CrudRepository<Review, Integer> {
    List<Review> findAll();
}
