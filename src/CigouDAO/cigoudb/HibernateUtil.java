package CigouDAO.cigoudb;


import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory factory;
//to disallow creating objects by other classes.
 
    private HibernateUtil() {
    }
//maling the Hibernate SessionFactory object as singleton
 
    public static synchronized SessionFactory getSessionFactory() {
 
        if (factory == null) {
            factory = new Configuration().configure("resource/hibernate.cfg.xml").
                    buildSessionFactory();
        }
        return factory;
    }
}
