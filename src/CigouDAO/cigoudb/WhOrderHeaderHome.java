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
 * Home object for domain model class WhOrderHeader.
 * @see CigouDAO.cigoudb.WhOrderHeader
 * @author Hibernate Tools
 */
public class WhOrderHeaderHome {

	private static final Log log = LogFactory.getLog(WhOrderHeaderHome.class);

	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	protected SessionFactory getSessionFactory() {
		
		return sessionFactory;
	}

	public void persist(WhOrderHeader transientInstance) {
		log.debug("persisting WhOrderHeader instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WhOrderHeader instance) {
		log.debug("attaching dirty WhOrderHeader instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WhOrderHeader instance) {
		log.debug("attaching clean WhOrderHeader instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WhOrderHeader persistentInstance) {
		log.debug("deleting WhOrderHeader instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WhOrderHeader merge(WhOrderHeader detachedInstance) {
		log.debug("merging WhOrderHeader instance");
		try {
			WhOrderHeader result = (WhOrderHeader) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WhOrderHeader findById(java.lang.String id) {
		log.debug("getting WhOrderHeader instance with id: " + id);
		try {
			WhOrderHeader instance = (WhOrderHeader) sessionFactory.getCurrentSession()
					.get("CigouDAO.cigoudb.WhOrderHeader", id);
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

	public List<WhOrderHeader> findByExample(WhOrderHeader instance) {
		log.debug("finding WhOrderHeader instance by example");
		try {
			List<WhOrderHeader> results = (List<WhOrderHeader>) sessionFactory.getCurrentSession()
					.createCriteria("CigouDAO.cigoudb.WhOrderHeader").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	
}
