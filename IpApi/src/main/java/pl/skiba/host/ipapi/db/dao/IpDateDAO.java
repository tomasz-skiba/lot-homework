package pl.skiba.host.ipapi.db.dao;

import java.sql.Date;
import java.util.Map;

import pl.skiba.host.ipapi.db.model.IpDate;

// TODO: Auto-generated Javadoc
/**
 * The Interface IpDateDAO provides a strategy for operations on {@link IpDate}
 * model.
 * 
 * @author Tomasz Skiba
 */
public interface IpDateDAO {

	/**
	 * Save.
	 *
	 * @param entity the entity
	 */
	public void save(IpDate entity);

	/**
	 * Gets the record count by day.
	 *
	 * @return the record count by day
	 */
	public Map<Date, Long> getRecordCountByDay();
}
