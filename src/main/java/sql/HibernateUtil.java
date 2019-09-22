package sql;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        Properties properties = configuration.getProperties();
        sessionFactory = configuration.buildSessionFactory(new ServiceRegistryBuilder().applySettings(properties).buildServiceRegistry());
    }

    public static  void closeSession(Session session) {
        session.close();
    }

    /**
     * The main utility method to be used to retreive the transaction.
     *
     * @return {@link Transaction} The transaction of the current session
     */
    public static Session currentSession() throws Exception {
        Session s = sessionFactory.openSession();
        return s;
    }

}