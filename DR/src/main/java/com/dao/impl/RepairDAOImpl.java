package com.dao.impl;

import com.dao.RepairDAO;
import com.povo.RepairEntity;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Repository("repairDAO")
@Transactional
public class RepairDAOImpl implements RepairDAO {
	private static final Logger log = LoggerFactory.getLogger(RepairDAOImpl.class);
	// property constants
	public static final String SCOPE = "scope";
	public static final String STATE = "state";
	public static final String SCORE = "score";

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public void save(RepairEntity transientInstance) {
		log.debug("saving RepairEntity instance");
		try {
			sessionFactory.getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void update(RepairEntity transientInstance) {
		log.debug("updating RepairEntity instance");
		try {
			sessionFactory.getCurrentSession().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("supdate failed", re);
			throw re;
		}
	}
	
	public void delete(RepairEntity persistentInstance) {
		log.debug("deleting RepairEntity instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RepairEntity findById(Integer id) {
		log.debug("getting RepairEntity instance with id: " + id);
		try {
			RepairEntity instance = (RepairEntity) sessionFactory.getCurrentSession().get("com.povo.RepairEntity", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public List findByUid(String uid) {
		log.debug("getting RepairEntity instance with uid: " + uid);
		try {
			String queryString = "from RepairEntity as model where model.uid= '"+uid+"'";
			Query queryObject = sessionFactory.getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public List findByWid(String wid) {
		log.debug("getting RepairEntity instance with wid: " + wid);
		try {
			String queryString = "from RepairEntity as model where model.wid= '"+wid+"'";
			Query queryObject = sessionFactory.getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(RepairEntity instance) {
		log.debug("finding RepairEntity instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.povo.RepairEntity").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding RepairEntity instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from RepairEntity as model where model." + propertyName + "= '"+value+"'";
			Query queryObject = sessionFactory.getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByScope(String scope) {
		return findByProperty(SCOPE, scope);
	}

	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findByScore(Object score) {
		return findByProperty(SCORE, score);
	}

	public List findAll() {
		log.debug("finding all RepairEntity instances");
		try {
			String queryString = "from RepairEntity";
			Query queryObject = sessionFactory.getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RepairEntity merge(RepairEntity detachedInstance) {
		log.debug("merging RepairEntity instance");
		try {
			RepairEntity result = (RepairEntity) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RepairEntity instance) {
		log.debug("attaching dirty RepairEntity instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RepairEntity instance) {
		log.debug("attaching clean RepairEntity instance");
		try {
			sessionFactory.getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}