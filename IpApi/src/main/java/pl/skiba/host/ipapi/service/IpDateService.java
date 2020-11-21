package pl.skiba.host.ipapi.service;

import java.util.List;

import pl.skiba.host.ipapi.controller.dto.IPCountByDayDTO;
import pl.skiba.host.ipapi.controller.dto.IpDateDTO;

/**
 * The Interface IpDateService provides a strategy for data delivery to a REST
 * API controller.
 * 
 * @author Tomasz Skiba
 */
public interface IpDateService {

	/**
	 * Save.
	 *
	 * @param ipDate the ip date
	 */
	public void save(IpDateDTO ipDate);

	/**
	 * Gets the statistics.
	 *
	 * @return the statistics
	 */
	public List<IPCountByDayDTO> getStatistics();
}
