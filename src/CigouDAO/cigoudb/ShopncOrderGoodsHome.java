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
 * Home object for domain model class ShopncOrderGoods.
 * @see CigouDAO.cigoudb.ShopncOrderGoods
 * @author Hibernate Tools
 */
public class ShopncOrderGoodsHome {

	private static final Log log = LogFactory.getLog(ShopncOrderGoodsHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ShopncOrderGoods transientInstance) {
		log.debug("persisting ShopncOrderGoods instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ShopncOrderGoods instance) {
		log.debug("attaching dirty ShopncOrderGoods instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ShopncOrderGoods instance) {
		log.debug("attaching clean ShopncOrderGoods instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ShopncOrderGoods persistentInstance) {
		log.debug("deleting ShopncOrderGoods instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ShopncOrderGoods merge(ShopncOrderGoods detachedInstance) {
		log.debug("merging ShopncOrderGoods instance");
		try {
			ShopncOrderGoods result = (ShopncOrderGoods) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ShopncOrderGoods findById(CigouDAO.cigoudb.ShopncOrderGoodsId id) {
		log.debug("getting ShopncOrderGoods instance with id: " + id);
		try {
			ShopncOrderGoods instance = (ShopncOrderGoods) sessionFactory.getCurrentSession()
					.get("CigouDAO.cigoudb.ShopncOrderGoods", id);
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

	public List<ShopncOrderGoods> findByExample(ShopncOrderGoods instance) {
		log.debug("finding ShopncOrderGoods instance by example");
		try {
			List<ShopncOrderGoods> results = (List<ShopncOrderGoods>) sessionFactory.getCurrentSession()
					.createCriteria("CigouDAO.cigoudb.ShopncOrderGoods").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
