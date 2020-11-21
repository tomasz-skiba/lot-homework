package pl.skiba.host.ipapi.db.dao.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
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
	public Map<Timestamp, Long> getRecordCountByDay() {
		Map<Timestamp, Long> result = new HashMap<>();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		try (Session session = sessionFactory.openSession();) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Object[]> cQuery = builder.createQuery(Object[].class);
			Root<IpDate> root = cQuery.from(IpDate.class);
			cQuery.multiselect(root.get(IpDate.REGISTER_DATE_CNAME), builder.count(root.get(IpDate.IP_CNAME)));
			Query<Object[]> query = session.createQuery(cQuery);
			List<Object[]> resultList = query.getResultList();
			for (Object[] o : resultList) {
				result.put((Timestamp) o[0], (Long) o[1]);
			}
		} catch (Throwable e) {
			log.error("Problem executing getRecordCoutByDay: ", e);
		}
		return result;
	}

}
