package com.theironyard.services;

import com.theironyard.entities.Lecturer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by michaelplott on 10/26/16.
 */
public interface LecturerRepository extends CrudRepository<Lecturer, Integer> {
    List<Lecturer> findAll();
}
