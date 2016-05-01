package CigouDAO.cigoudb;
// Generated 2016-4-16 23:41:33 by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class WhOrderDelivery.
 * @see CigouDAO.cigoudb.WhOrderDelivery
 * @author Hibernate Tools
 */
public class WhOrderDeliveryHome {

	private static final Log log = LogFactory.getLog(WhOrderDeliveryHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(WhOrderDelivery transientInstance) {
		log.debug("persisting WhOrderDelivery instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WhOrderDelivery instance) {
		log.debug("attaching dirty WhOrderDelivery instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WhOrderDelivery instance) {
		log.debug("attaching clean WhOrderDelivery instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WhOrderDelivery persistentInstance) {
		log.debug("deleting WhOrderDelivery instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WhOrderDelivery merge(WhOrderDelivery detachedInstance) {
		log.debug("merging WhOrderDelivery instance");
		try {
			WhOrderDelivery result = (WhOrderDelivery) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WhOrderDelivery findById(java.lang.String id) {
		log.debug("getting WhOrderDelivery instance with id: " + id);
		try {
			WhOrderDelivery instance = (WhOrderDelivery) sessionFactory.getCurrentSession()
					.get("CigouDAO.cigoudb.WhOrderDelivery", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<WhOrderDelivery> findByExample(WhOrderDelivery instance) {
		log.debug("finding WhOrderDelivery instance by example");
		try {
			List<WhOrderDelivery> results = (List<WhOrderDelivery>) sessionFactory.getCurrentSession()
					.createCriteria("CigouDAO.cigoudb.WhOrderDelivery").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
