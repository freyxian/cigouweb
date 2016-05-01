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
 * Home object for domain model class ShopncOrderAddress.
 * @see CigouDAO.cigoudb.ShopncOrderAddress
 * @author Hibernate Tools
 */
public class ShopncOrderAddressHome {

	private static final Log log = LogFactory.getLog(ShopncOrderAddressHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ShopncOrderAddress transientInstance) {
		log.debug("persisting ShopncOrderAddress instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ShopncOrderAddress instance) {
		log.debug("attaching dirty ShopncOrderAddress instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ShopncOrderAddress instance) {
		log.debug("attaching clean ShopncOrderAddress instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ShopncOrderAddress persistentInstance) {
		log.debug("deleting ShopncOrderAddress instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ShopncOrderAddress merge(ShopncOrderAddress detachedInstance) {
		log.debug("merging ShopncOrderAddress instance");
		try {
			ShopncOrderAddress result = (ShopncOrderAddress) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ShopncOrderAddress findById(int id) {
		log.debug("getting ShopncOrderAddress instance with id: " + id);
		try {
			ShopncOrderAddress instance = (ShopncOrderAddress) sessionFactory.getCurrentSession()
					.get("CigouDAO.cigoudb.ShopncOrderAddress", id);
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

	public List<ShopncOrderAddress> findByExample(ShopncOrderAddress instance) {
		log.debug("finding ShopncOrderAddress instance by example");
		try {
			List<ShopncOrderAddress> results = (List<ShopncOrderAddress>) sessionFactory.getCurrentSession()
					.createCriteria("CigouDAO.cigoudb.ShopncOrderAddress").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
