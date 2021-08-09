package com.dao.impl;

import com.dao.UserDAO;
import com.povo.UserEntity;
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
@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
	// property constants
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	//注册及增加学生
	public void save(UserEntity transientInstance) {
		log.debug("saving UserEntity instance");
		try {
			sessionFactory.getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	//更新学生信息
	public void update(UserEntity user) {
	    try {
	         sessionFactory.getCurrentSession().update(user);
	    } catch (RuntimeException re) {
	         throw re;
	    }
	}
	//删除学生
	public void delete(UserEntity persistentInstance) {
		log.debug("deleting UserEntity instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	//根据id查找用户
	public UserEntity findById(String id) {
		log.debug("getting UserEntity instance with id: " + id);
		try {
			UserEntity instance = (UserEntity) sessionFactory.getCurrentSession().get("com.povo.UserEntity", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UserEntity instance) {
		log.debug("finding UserEntity instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.povo.UserEntity").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding UserEntity instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from UserEntity as model where model." + propertyName + "= ?";
			Query queryObject = sessionFactory.getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all UserEntity instances");
		try {
			String queryString = "from UserEntity";
			Query queryObject = sessionFactory.getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}