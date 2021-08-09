package com.dao.impl;

import com.dao.WorkerDAO;
import com.povo.WorkerEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Repository("workerDAO")
@Transactional
public class WorkerDAOImpl implements WorkerDAO {
	private static final Logger log = LoggerFactory.getLogger(WorkerDAOImpl.class);
	// property constants
	public static final String SCOPE = "scope";
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	//更新维修工信息
	public void update(WorkerEntity worker) {
		try {
			sessionFactory.getCurrentSession().update(worker);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void save(WorkerEntity transientInstance) {
		log.debug("saving WorkerEntity instance");
		try {
			sessionFactory.getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(WorkerEntity persistentInstance) {
		log.debug("deleting WorkerEntity instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WorkerEntity findById(String id) {
		log.debug("getting WorkerEntity instance with id: " + id);
		try {
			WorkerEntity instance = (WorkerEntity) sessionFactory.getCurrentSession().get("com.povo.WorkerEntity", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(WorkerEntity instance) {
		log.debug("finding WorkerEntity instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.povo.WorkerEntity").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding WorkerEntity instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from WorkerEntity as model where model." + propertyName + "= ?";
			Query queryObject = sessionFactory.getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByScope(Object scope) {
		return findByProperty(SCOPE, scope);
	}

	public List findAll() {
		log.debug("finding all WorkerEntity instances");
		try {
			String queryString = "from WorkerEntity";
			Query queryObject = sessionFactory.getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}