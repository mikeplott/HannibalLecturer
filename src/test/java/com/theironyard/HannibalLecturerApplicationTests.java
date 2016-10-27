package com.theironyard;

import com.theironyard.entities.Lecturer;
import com.theironyard.services.LecturerRepository;
import com.theironyard.services.ReviewRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HannibalLecturerApplicationTests {

	@Autowired
	LecturerRepository lecturers;

	@Autowired
	ReviewRepository reviews;

	@Autowired
	WebApplicationContext wac;

	MockMvc mockMvc;

	@Before
	public void before() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void addLecturer() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.post("/lecturers")
					.param("name", "Zach")
					.param("topic", "Java")
					.param("image", "adsljkfalsk")
		);

		Assert.assertTrue(lecturers.count() == 1);
	}

	@Test
	public void addReview() throws Exception {
		Lecturer lecturer = lecturers.findOne(1);
		mockMvc.perform(
				MockMvcRequestBuilders.post("/reviews")

					.param("author", "Mike")
					.param("text", "akljsdfjaslfdk")
					.param("isGood", "true")
					.param("lecturer", lecturer.toString())
		);
	}

}
