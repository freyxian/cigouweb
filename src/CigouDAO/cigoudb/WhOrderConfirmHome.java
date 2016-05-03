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
 * Home object for domain model class WhOrderConfirm.
 * @see CigouDAO.cigoudb.WhOrderConfirm
 * @author Hibernate Tools
 */
public class WhOrderConfirmHome {

	private static final Log log = LogFactory.getLog(WhOrderConfirmHome.class);

	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	protected SessionFactory getSessionFactory() {
		
		return sessionFactory;
	}

	public void persist(WhOrderConfirm transientInstance) {
		log.debug("persisting WhOrderConfirm instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WhOrderConfirm instance) {
		log.debug("attaching dirty WhOrderConfirm instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WhOrderConfirm instance) {
		log.debug("attaching clean WhOrderConfirm instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WhOrderConfirm persistentInstance) {
		log.debug("deleting WhOrderConfirm instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WhOrderConfirm merge(WhOrderConfirm detachedInstance) {
		log.debug("merging WhOrderConfirm instance");
		try {
			WhOrderConfirm result = (WhOrderConfirm) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WhOrderConfirm findById(java.lang.String id) {
		log.debug("getting WhOrderConfirm instance with id: " + id);
		try {
			WhOrderConfirm instance = (WhOrderConfirm) sessionFactory.getCurrentSession()
					.get("CigouDAO.cigoudb.WhOrderConfirm", id);
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

	public List<WhOrderConfirm> findByExample(WhOrderConfirm instance) {
		log.debug("finding WhOrderConfirm instance by example");
		try {
			List<WhOrderConfirm> results = (List<WhOrderConfirm>) sessionFactory.getCurrentSession()
					.createCriteria("CigouDAO.cigoudb.WhOrderConfirm").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
