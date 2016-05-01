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
 * Home object for domain model class WhGoodsEntry.
 * @see CigouDAO.cigoudb.WhGoodsEntry
 * @author Hibernate Tools
 */
public class WhGoodsEntryHome {

	private static final Log log = LogFactory.getLog(WhGoodsEntryHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(WhGoodsEntry transientInstance) {
		log.debug("persisting WhGoodsEntry instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WhGoodsEntry instance) {
		log.debug("attaching dirty WhGoodsEntry instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WhGoodsEntry instance) {
		log.debug("attaching clean WhGoodsEntry instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WhGoodsEntry persistentInstance) {
		log.debug("deleting WhGoodsEntry instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WhGoodsEntry merge(WhGoodsEntry detachedInstance) {
		log.debug("merging WhGoodsEntry instance");
		try {
			WhGoodsEntry result = (WhGoodsEntry) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WhGoodsEntry findById(java.lang.String id) {
		log.debug("getting WhGoodsEntry instance with id: " + id);
		try {
			WhGoodsEntry instance = (WhGoodsEntry) sessionFactory.getCurrentSession()
					.get("CigouDAO.cigoudb.WhGoodsEntry", id);
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

	public List<WhGoodsEntry> findByExample(WhGoodsEntry instance) {
		log.debug("finding WhGoodsEntry instance by example");
		try {
			List<WhGoodsEntry> results = (List<WhGoodsEntry>) sessionFactory.getCurrentSession()
					.createCriteria("CigouDAO.cigoudb.WhGoodsEntry").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
