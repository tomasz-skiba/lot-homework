package pl.skiba.host.ipapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import pl.skiba.host.ipapi.db.dao.IpDateDAO;
import pl.skiba.host.ipapi.db.model.IpDate;
import pl.skiba.host.ipapi.service.IpDateService;

public class IpDateServiceBasic implements IpDateService {

	private final IpDateDAO ipDate;

	@Autowired
	public IpDateServiceBasic(@Qualifier("IpDateBasicDAO") IpDateDAO ipDate) {
		super();
		this.ipDate = ipDate;
	}

	@Override
	public void save(IpDate entity) {
		ipDate.save(entity);
	}

	@Override
	public List<IpDate> getCoutByDay() {
		return ipDate.getCoutByDay();
	}

}
