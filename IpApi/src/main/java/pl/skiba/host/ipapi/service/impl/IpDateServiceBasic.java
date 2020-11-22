package pl.skiba.host.ipapi.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.skiba.host.ipapi.controller.dto.IPCountByDayDTO;
import pl.skiba.host.ipapi.controller.dto.IpDateDTO;
import pl.skiba.host.ipapi.db.dao.IpDateDAO;
import pl.skiba.host.ipapi.db.model.IpDate;
import pl.skiba.host.ipapi.service.IpDateService;

/**
 * The Class IpDateServiceBasic.
 * 
 * @author Tomasz Skiba
 */
@Service
public class IpDateServiceBasic implements IpDateService {

	/** The dao. */
	private final IpDateDAO dao;

	/**
	 * Instantiates a new ip date service basic.
	 *
	 * @param dao the dao
	 */
	@Autowired
	public IpDateServiceBasic(IpDateDAO dao) {
		super();
		this.dao = dao;
	}

	/**
	 * Convert {@link IpDateDTO} to {@link IpDate} and CREATE entry in database.
	 *
	 * @param ipDate the ip date
	 */
	@Override
	public void save(IpDateDTO ipDate) {
		IpDate entity = new IpDate();
		entity.setIp(ipDate.ip);
		entity.setRegisterDate(ipDate.registerDate);
		dao.save(entity);
	}

	/**
	 * Performs READ for coutByDay
	 *
	 * @return the statistics as a {@link List} of {@link IPCountByDayDTO}
	 */
	@Override
	public List<IPCountByDayDTO> getStatistics() {
		Map<java.sql.Date, Long> coutByDay = dao.getRecordCountByDay();
		List<IPCountByDayDTO> coutByDayDTO = coutByDay.entrySet().stream().filter(entry -> entry.getKey() != null)
				.map(entry -> new IPCountByDayDTO(entry.getKey().toLocalDate(), entry.getValue()))
				.collect(Collectors.toList());
		return coutByDayDTO;
	}

}
