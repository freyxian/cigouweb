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
 * Home object for domain model class WhOrderLogistics.
 * @see CigouDAO.cigoudb.WhOrderLogistics
 * @author Hibernate Tools
 */
public class WhOrderLogisticsHome {

	private static final Log log = LogFactory.getLog(WhOrderLogisticsHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(WhOrderLogistics transientInstance) {
		log.debug("persisting WhOrderLogistics instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WhOrderLogistics instance) {
		log.debug("attaching dirty WhOrderLogistics instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WhOrderLogistics instance) {
		log.debug("attaching clean WhOrderLogistics instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WhOrderLogistics persistentInstance) {
		log.debug("deleting WhOrderLogistics instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WhOrderLogistics merge(WhOrderLogistics detachedInstance) {
		log.debug("merging WhOrderLogistics instance");
		try {
			WhOrderLogistics result = (WhOrderLogistics) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WhOrderLogistics findById(java.lang.String id) {
		log.debug("getting WhOrderLogistics instance with id: " + id);
		try {
			WhOrderLogistics instance = (WhOrderLogistics) sessionFactory.getCurrentSession()
					.get("CigouDAO.cigoudb.WhOrderLogistics", id);
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

	public List<WhOrderLogistics> findByExample(WhOrderLogistics instance) {
		log.debug("finding WhOrderLogistics instance by example");
		try {
			List<WhOrderLogistics> results = (List<WhOrderLogistics>) sessionFactory.getCurrentSession()
					.createCriteria("CigouDAO.cigoudb.WhOrderLogistics").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
