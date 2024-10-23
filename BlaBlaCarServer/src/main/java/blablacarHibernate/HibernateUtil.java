package blablacarHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static Session session;

	public static void buildSessionFactory() {
	
		Configuration configuration = new Configuration();
		configuration.configure();
                configuration.addAnnotatedClass(Coche.class);
                configuration.addAnnotatedClass(Trayecto.class);
                configuration.addAnnotatedClass(Usuario.class);
                configuration.addAnnotatedClass(Viaje.class);
                configuration.addAnnotatedClass(Reserva.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
						configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public static void openSession() {
            if(sessionFactory == null)
                buildSessionFactory();
            
            session = sessionFactory.openSession();
	}
	
	public static Session getCurrentSession() {	
            if ((session == null) || (!session.isOpen()))
                    openSession();

            return session;
	}

	public static void closeSessionFactory() {
		if (session != null)
			session.close();
		
		if (sessionFactory != null)
			sessionFactory.close();
	}
}