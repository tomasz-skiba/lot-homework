package pl.skiba.host.ipapi.db.dao;

import java.util.List;

import pl.skiba.host.ipapi.db.model.IpDate;

public interface IpDateDAO {

	public void save(IpDate entity);

	public List<IpDate> getCoutByDay();
}
