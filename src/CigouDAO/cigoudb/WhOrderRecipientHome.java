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
 * Home object for domain model class WhOrderRecipient.
 * @see CigouDAO.cigoudb.WhOrderRecipient
 * @author Hibernate Tools
 */
public class WhOrderRecipientHome {

	private static final Log log = LogFactory.getLog(WhOrderRecipientHome.class);

	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	protected SessionFactory getSessionFactory() {
		
		return sessionFactory;
	}

	public void persist(WhOrderRecipient transientInstance) {
		log.debug("persisting WhOrderRecipient instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WhOrderRecipient instance) {
		log.debug("attaching dirty WhOrderRecipient instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WhOrderRecipient instance) {
		log.debug("attaching clean WhOrderRecipient instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WhOrderRecipient persistentInstance) {
		log.debug("deleting WhOrderRecipient instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WhOrderRecipient merge(WhOrderRecipient detachedInstance) {
		log.debug("merging WhOrderRecipient instance");
		try {
			WhOrderRecipient result = (WhOrderRecipient) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WhOrderRecipient findById(java.lang.String id) {
		log.debug("getting WhOrderRecipient instance with id: " + id);
		try {
			WhOrderRecipient instance = (WhOrderRecipient) sessionFactory.getCurrentSession()
					.get("CigouDAO.cigoudb.WhOrderRecipient", id);
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

	public List<WhOrderRecipient> findByExample(WhOrderRecipient instance) {
		log.debug("finding WhOrderRecipient instance by example");
		try {
			List<WhOrderRecipient> results = (List<WhOrderRecipient>) sessionFactory.getCurrentSession()
					.createCriteria("CigouDAO.cigoudb.WhOrderRecipient").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
