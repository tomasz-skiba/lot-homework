package pl.skiba.host.ipapi.db.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pl.skiba.host.ipapi.db.dao.IpDateDAO;
import pl.skiba.host.ipapi.db.model.IpDate;

@Repository("IpDateBasicDAO")
public class IpDateBasicDAO implements IpDateDAO {
	Logger log = LoggerFactory.getLogger(IpDateBasicDAO.class);

	@Override
	public void save(IpDate entity) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		try (Session session = sessionFactory.openSession();) {
			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
		} catch (Throwable e) {
			log.error("Problem executing save: ", e);
		}
	}

	@Override
	public List<IpDate> getCoutByDay() {
		// TODO Auto-generated method stub
		return null;
	}

}
