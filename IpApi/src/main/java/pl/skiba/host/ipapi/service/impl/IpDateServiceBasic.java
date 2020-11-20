package pl.skiba.host.ipapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
	public List<IpDateDTO> getStatistics() {
		List<IpDateDTO> result = new ArrayList<>();
		List<IpDate> coutByDay = dao.getCoutByDay();
		if (coutByDay != null) {
			result = coutByDay.stream().map(data -> new IpDateDTO(data.getIp(), data.getRegisterDate()))
					.collect(Collectors.toList());
		}
		return result;
	}

}
