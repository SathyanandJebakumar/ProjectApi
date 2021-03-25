package com.ul.api.controller.functionality.test;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ul.api.app.enums.Status;
import com.ul.api.request.model.ProjectCreationReqObj;
import com.ul.api.response.model.ProjectResponseObj;
import com.ul.api.services.ProjectServices;

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
public class ApplicationControllerTest {

	private static final ObjectMapper om = new ObjectMapper();

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	ProjectServices projectServices;

	@Before
	public void init() {
		ProjectResponseObj project1 = new ProjectResponseObj(1L, "Endpoint Testing", Status.IN_PROGRESS,
				LocalDateTime.now(), false);

		ProjectResponseObj project2 = new ProjectResponseObj(2L, "Endpoint Testing2", Status.IN_PROGRESS,
				LocalDateTime.now(), true);

		List<ProjectResponseObj> projectArrayList = new ArrayList<>();
		projectArrayList.add(project1);
		projectArrayList.add(project2);

		when(projectServices.saveProject(new ProjectCreationReqObj())).thenReturn((project1));
		when(projectServices.getAllProjects()).thenReturn(projectArrayList);
		when(projectServices.updateProject(1L)).thenReturn((project2));
	}

	/*@Test
	public void save_Product() throws Exception {

		ProjectCreationReqObj newProjectReq = new ProjectCreationReqObj();
		newProjectReq.setName("Functional Testing");
		newProjectReq.setStatus(Status.IN_PROGRESS);

		mockMvc.perform(post("/projects").content(om.writeValueAsString(newProjectReq)).header(HttpHeaders.CONTENT_TYPE,
				MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.name", is("Endpoint Testing")));

	}*/

	@Test
	public void update_Product() throws Exception {

		mockMvc.perform(put("/projects/1").header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$.id", is(2)))
				.andExpect(jsonPath("$.archived", is(true)));

	}

	@Test
	public void getAll_Product() throws Exception {

		mockMvc.perform(get("/projects").header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful());

	}

}
