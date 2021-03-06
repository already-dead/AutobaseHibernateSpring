
/*package util;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateUtil {
    private static HibernateUtil util = null;

    private static Logger log = Logger.getLogger(HibernateUtil.class);

    private final ThreadLocal<Session> sessions = new ThreadLocal<Session>();
    
    @Autowired
    private static SessionFactory sessionFactory = null; 
  
    
    private HibernateUtil() {
        try {
        	 Configuration configuration = new Configuration().configure();
             StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
             sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (Throwable ex) {
            log.error("Initial SessionFactory creation failed." + ex);
            System.exit(0);
        }
    }

    public Session getSession () {
        Session session = (Session) sessions.get();
        if (session == null) {
            session = sessionFactory.openSession();
            sessions.set(session);
        }
        return session;
    }

    public static synchronized HibernateUtil getHibernateUtil(){
        if (util == null){
            util = new HibernateUtil();
        }
        return util;
    }

}*/
