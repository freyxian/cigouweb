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
 * Home object for domain model class ShopncOrder.
 * @see CigouDAO.cigoudb.ShopncOrder
 * @author Hibernate Tools
 */
public class ShopncOrderHome {

	private static final Log log = LogFactory.getLog(ShopncOrderHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ShopncOrder transientInstance) {
		log.debug("persisting ShopncOrder instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ShopncOrder instance) {
		log.debug("attaching dirty ShopncOrder instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ShopncOrder instance) {
		log.debug("attaching clean ShopncOrder instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ShopncOrder persistentInstance) {
		log.debug("deleting ShopncOrder instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ShopncOrder merge(ShopncOrder detachedInstance) {
		log.debug("merging ShopncOrder instance");
		try {
			ShopncOrder result = (ShopncOrder) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ShopncOrder findById(int id) {
		log.debug("getting ShopncOrder instance with id: " + id);
		try {
			ShopncOrder instance = (ShopncOrder) sessionFactory.getCurrentSession().get("CigouDAO.cigoudb.ShopncOrder",
					id);
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

	public List<ShopncOrder> findByExample(ShopncOrder instance) {
		log.debug("finding ShopncOrder instance by example");
		try {
			List<ShopncOrder> results = (List<ShopncOrder>) sessionFactory.getCurrentSession()
					.createCriteria("CigouDAO.cigoudb.ShopncOrder").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
