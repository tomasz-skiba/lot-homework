package pl.skiba.host.ipapi.db.dao;

import java.sql.Date;
import java.util.Map;

import pl.skiba.host.ipapi.db.model.IpDate;

public interface IpDateDAO {

	public void save(IpDate entity);

	public Map<Date, Long> getRecordCountByDay();
}
