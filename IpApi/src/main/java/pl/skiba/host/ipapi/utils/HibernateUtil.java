package pl.skiba.host.ipapi.utils;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 * This Class is a configuration for Hibernate.
 *
 * @author Tomasz Skiba
 */
public class HibernateUtil {

	/**
	 * Gets the configured current session.
	 *
	 * @return {@link Session}
	 * @throws HibernateException
	 */
	public static Session getCurrentSession() throws HibernateException {
		Map<String, String> settings = new HashMap<>();
		settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/lot-maria-db");
		settings.put("hibernate.connection.username", "root");
		settings.put("hibernate.connection.password", "toor");
		settings.put("connection.driver_class", "com.mysql.jdbc.Driver");
		settings.put("dialect", "org.hibernate.dialect.MySQL57Dialect");
		settings.put("hibernate.show_sql", "true");
		settings.put("hibernate.format_sql", "true");
		settings.put("hibernate.hbm2ddl.auto", "update");
		settings.put("hibernate.naming.physical-strategy",
				"org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");
		settings.put("hibernate.current_session_context_class", "thread");

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(settings).build();

		MetadataSources metadataSources = new MetadataSources(serviceRegistry);
		metadataSources.addAnnotatedClass(pl.skiba.host.ipapi.db.model.IpDate.class);

		Metadata metadata = metadataSources.buildMetadata();
		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
}
