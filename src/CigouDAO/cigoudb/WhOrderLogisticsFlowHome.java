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
 * Home object for domain model class WhOrderLogisticsFlow.
 * @see CigouDAO.cigoudb.WhOrderLogisticsFlow
 * @author Hibernate Tools
 */
public class WhOrderLogisticsFlowHome {

	private static final Log log = LogFactory.getLog(WhOrderLogisticsFlowHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(WhOrderLogisticsFlow transientInstance) {
		log.debug("persisting WhOrderLogisticsFlow instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WhOrderLogisticsFlow instance) {
		log.debug("attaching dirty WhOrderLogisticsFlow instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WhOrderLogisticsFlow instance) {
		log.debug("attaching clean WhOrderLogisticsFlow instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WhOrderLogisticsFlow persistentInstance) {
		log.debug("deleting WhOrderLogisticsFlow instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WhOrderLogisticsFlow merge(WhOrderLogisticsFlow detachedInstance) {
		log.debug("merging WhOrderLogisticsFlow instance");
		try {
			WhOrderLogisticsFlow result = (WhOrderLogisticsFlow) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WhOrderLogisticsFlow findById(CigouDAO.cigoudb.WhOrderLogisticsFlowId id) {
		log.debug("getting WhOrderLogisticsFlow instance with id: " + id);
		try {
			WhOrderLogisticsFlow instance = (WhOrderLogisticsFlow) sessionFactory.getCurrentSession()
					.get("CigouDAO.cigoudb.WhOrderLogisticsFlow", id);
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

	public List<WhOrderLogisticsFlow> findByExample(WhOrderLogisticsFlow instance) {
		log.debug("finding WhOrderLogisticsFlow instance by example");
		try {
			List<WhOrderLogisticsFlow> results = (List<WhOrderLogisticsFlow>) sessionFactory.getCurrentSession()
					.createCriteria("CigouDAO.cigoudb.WhOrderLogisticsFlow").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
