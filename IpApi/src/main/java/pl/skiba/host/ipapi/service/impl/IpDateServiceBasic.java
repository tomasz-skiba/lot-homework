package pl.skiba.host.ipapi.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pl.skiba.host.ipapi.controller.dto.IPCountByDayDTO;
import pl.skiba.host.ipapi.controller.dto.IpDateDTO;
import pl.skiba.host.ipapi.db.dao.IpDateDAO;
import pl.skiba.host.ipapi.db.model.IpDate;
import pl.skiba.host.ipapi.service.IpDateService;

@Service
public class IpDateServiceBasic implements IpDateService {

	private final IpDateDAO dao;

	@Autowired
	public IpDateServiceBasic(@Qualifier("IpDateBasicDAO") IpDateDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public void save(IpDateDTO ipDate) {
		IpDate entity = new IpDate();
		entity.setIp(ipDate.ip);
		entity.setRegisterDate(ipDate.registerDate);
		dao.save(entity);
	}

	@Override
	public List<IPCountByDayDTO> getStatistics() {
		Map<java.sql.Date, Long> coutByDay = dao.getRecordCountByDay();
		List<IPCountByDayDTO> coutByDayDTO = coutByDay.entrySet().stream()
				.map(entry -> new IPCountByDayDTO(new Date(entry.getKey().getTime()), entry.getValue()))
				.collect(Collectors.toList());

		return coutByDayDTO;
	}

}
