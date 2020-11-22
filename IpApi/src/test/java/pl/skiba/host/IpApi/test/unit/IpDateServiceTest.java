package pl.skiba.host.IpApi.test.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import pl.skiba.host.ipapi.controller.dto.IPCountByDayDTO;
import pl.skiba.host.ipapi.db.dao.IpDateDAO;
import pl.skiba.host.ipapi.service.IpDateService;
import pl.skiba.host.ipapi.service.impl.IpDateServiceBasic;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { IpDateServiceBasic.class })
public class IpDateServiceTest {

	@Autowired
	private IpDateService service;
	@MockBean
	private IpDateDAO dao;

	@Test
	public void given_NoData_when_getStatisticsCalled_then_ReturnEmptyList() {
		Mockito.when(dao.getRecordCountByDay()).thenReturn(new HashMap<>());
		List<IPCountByDayDTO> data = service.getStatistics();
		assertEquals(true, data.isEmpty());
	}

	@Test
	public void given_NullMapKey_when_getStatisticsCalled_then_ReturnEmptyList() {
		Map<java.sql.Date, Long> in = new HashMap<>();
		in.put(null, 10L);
		Mockito.when(dao.getRecordCountByDay()).thenReturn(in);
		List<IPCountByDayDTO> data = service.getStatistics();
		assertEquals(true, data.isEmpty());
	}

	@Test
	public void given_3DifferentDates_when_getStatisticsCalled_then_Return3Entries() {
		Map<java.sql.Date, Long> in = new HashMap<>();
		long aDate = 1606048800108L; // 2020-11-22
		in.put(new java.sql.Date(aDate), 5L);
		in.put(new java.sql.Date(aDate - TimeUnit.DAYS.toMillis(1)), 6L);
		in.put(new java.sql.Date(aDate - TimeUnit.DAYS.toMillis(2)), 7L);
		Mockito.when(dao.getRecordCountByDay()).thenReturn(in);
		List<IPCountByDayDTO> data = service.getStatistics();
		assertEquals(3, data.size());
	}

}
