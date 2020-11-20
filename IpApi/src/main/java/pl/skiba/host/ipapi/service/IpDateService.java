package pl.skiba.host.ipapi.service;

import java.util.List;

import pl.skiba.host.ipapi.db.model.IpDate;

public interface IpDateService {

	public void save(IpDate entity);

	public List<IpDate> getCoutByDay();
}
