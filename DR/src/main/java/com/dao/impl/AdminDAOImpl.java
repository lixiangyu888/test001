package com.dao.impl;

import com.dao.AdminDAO;
import com.povo.AdminEntity;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Repository("adminDAO")
@Transactional
public class AdminDAOImpl implements AdminDAO {
	private static final Logger log = LoggerFactory.getLogger(AdminDAOImpl.class);
	// property constants
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	//根据ID查询
	public AdminEntity findById(String id) {
		log.debug("getting AdminEntity instance with id: " + id);
		try {
			AdminEntity instance = (AdminEntity) sessionFactory.getCurrentSession().get("com.povo.AdminEntity", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	//管理员条件查询
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Admin instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from AdminEntity as model where model." + propertyName + "= ?";
			Query queryObject = sessionFactory.getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
}