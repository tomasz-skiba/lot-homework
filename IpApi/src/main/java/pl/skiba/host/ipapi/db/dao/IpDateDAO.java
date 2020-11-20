package pl.skiba.host.ipapi.db.dao;

import java.sql.Timestamp;
import java.util.Map;

import pl.skiba.host.ipapi.db.model.IpDate;

public interface IpDateDAO {

	public void save(IpDate entity);

	public Map<Timestamp, Long> getRecordCoutByDay();
}
