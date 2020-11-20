package pl.skiba.host.ipapi.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import pl.skiba.host.ipapi.db.dao.IpDateDAO;
import pl.skiba.host.ipapi.db.model.IpDate;

@Repository("IpDateBasicDAO")
public class IpDateBasicDAO implements IpDateDAO {

	@Override
	public void save(IpDate entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<IpDate> getCoutByDay() {
		// TODO Auto-generated method stub
		return null;
	}

}
