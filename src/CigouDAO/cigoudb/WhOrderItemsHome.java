package CigouDAO.cigoudb;
// Generated 2016-4-16 23:41:33 by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class WhOrderItems.
 * @see CigouDAO.cigoudb.WhOrderItems
 * @author Hibernate Tools
 */
public class WhOrderItemsHome {

	private static final Log log = LogFactory.getLog(WhOrderItemsHome.class);

	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	protected SessionFactory getSessionFactory() {
		
		return sessionFactory;
	}

	public void persist(WhOrderItems transientInstance) {
		log.debug("persisting WhOrderItems instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WhOrderItems instance) {
		log.debug("attaching dirty WhOrderItems instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WhOrderItems instance) {
		log.debug("attaching clean WhOrderItems instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WhOrderItems persistentInstance) {
		log.debug("deleting WhOrderItems instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WhOrderItems merge(WhOrderItems detachedInstance) {
		log.debug("merging WhOrderItems instance");
		try {
			WhOrderItems result = (WhOrderItems) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WhOrderItems findById(CigouDAO.cigoudb.WhOrderItemsId id) {
		log.debug("getting WhOrderItems instance with id: " + id);
		try {
			WhOrderItems instance = (WhOrderItems) sessionFactory.getCurrentSession()
					.get("CigouDAO.cigoudb.WhOrderItems", id);
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

	public List<WhOrderItems> findByExample(WhOrderItems instance) {
		log.debug("finding WhOrderItems instance by example");
		try {
			List<WhOrderItems> results = (List<WhOrderItems>) sessionFactory.getCurrentSession()
					.createCriteria("CigouDAO.cigoudb.WhOrderItems").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<WhOrderItems> findByOrderID(String orderId) {
		log.debug("finding Order_ID");
		try {
			Query query =    sessionFactory.getCurrentSession().createQuery("from WhOrderItems where order_id=:orderId");
			query.setString("orderId", orderId); 
			List<WhOrderItems> results = query.list();
			log.debug("find by Order_ID successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
