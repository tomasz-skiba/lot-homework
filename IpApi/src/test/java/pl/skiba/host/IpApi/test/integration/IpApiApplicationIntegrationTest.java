package pl.skiba.host.IpApi.test.integration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

import pl.skiba.host.ipapi.controller.IpApiRestController;
import pl.skiba.host.ipapi.controller.dto.IPCountByDayDTO;
import pl.skiba.host.ipapi.db.dao.IpDateDAO;
import pl.skiba.host.ipapi.service.IpDateService;

/**
 * Work in progress
 * 
 * @author Tomasz Skiba
 *
 */
@RunWith(SpringRunner.class)
public class IpApiApplicationIntegrationTest {

	@Rule
	public GenericContainer redis = new GenericContainer(DockerImageName.parse("mariadb:10.4")).withExposedPorts(3306)
			.withEnv("MYSQL_DATABASE", "lot-maria-db-test").withEnv("MYSQL_ROOT_USER", "root")
			.withEnv("MYSQL_ROOT_PASSWORD", "toor");

	private MockMvc mockMvc;

	@InjectMocks
	private IpApiRestController controller;

	@Mock
	private IpDateService service;

	@Mock
	private IpDateDAO dao;

	@Before
	public void init() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

	}

	@Test
	public void given_NoData_when_getStatisticsCalled_then_ReturnEmptyListAsJSON() throws Exception {
		List<IPCountByDayDTO> data = new ArrayList<>();
		Mockito.when(service.getStatistics()).thenReturn(data);
		mockMvc.perform(MockMvcRequestBuilders.get("/statistics")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json("[]"));
	}

	@Test
	public void given_FebruaryOutOfIndexDate_when_getSaveCalled_then_BadRequest() throws Exception {
		// TODO implement JSON object mapping
		String jsonValue = "{\"ip\":\"212.34.52.103\", \"registerDate\":\"2020-02-30\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/save").contentType(MediaType.APPLICATION_JSON).content(jsonValue))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	public void given_ProperDate_when_getSaveCalled_then_Ok() throws Exception {
		// TODO implement JSON object mapping
		String jsonValue = "{\"ip\":\"212.34.52.103\", \"registerDate\":\"2020-02-20\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/save").contentType(MediaType.APPLICATION_JSON).content(jsonValue))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void given_3Results_when_getStatisticsCalled_then_ReturnListAsJSON() throws Exception {
		List<IPCountByDayDTO> data = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		data.add(new IPCountByDayDTO(LocalDate.parse("2020-05-13", formatter), 2L));
		data.add(new IPCountByDayDTO(LocalDate.parse("2020-05-12", formatter), 3L));
		data.add(new IPCountByDayDTO(LocalDate.parse("2020-05-11", formatter), 4L));
		// TODO implement JSON object mapping
		String jsonValue = "[{\"date\":\"2020-05-13\", \"count\":2},{\"date\":\"2020-05-12\", \"count\":3},{\"date\":\"2020-05-11\", \"count\":4}]";
		System.out.println(jsonValue);
//		Mockito.when(service.getStatistics()).thenReturn(data);
		mockMvc.perform(MockMvcRequestBuilders.get("/statistics")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(jsonValue));
	}
}
