package com.dao.impl;

import com.dao.EquipmentDAO;
import com.povo.EquipmentEntity;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Repository("equipmentDAO")
@Transactional
public class EquipmentDAOImpl implements EquipmentDAO {
	private static final Logger log = LoggerFactory.getLogger(EquipmentDAOImpl.class);
	// property constants
	public static final String BUILDING = "building";
	public static final String FLOOR = "floor";
	public static final String ROOM = "room";
	public static final String SCOPE = "scope";
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public void save(EquipmentEntity transientInstance) {
		log.debug("saving EquipmentEntity instance");
		try {
			sessionFactory.getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(EquipmentEntity persistentInstance) {
		log.debug("deleting EquipmentEntity instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EquipmentEntity findById(Integer id) {
		log.debug("getting EquipmentEntity instance with id: " + id);
		try {
			EquipmentEntity instance = (EquipmentEntity) sessionFactory.getCurrentSession().get("com.povo.EquipmentEntity", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public EquipmentEntity findByEquimpent(EquipmentEntity equipment) {
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.povo.EquipmentEntity").add(Example.create(equipment)).list();
			if(results!=null&&results.size()>0)
				return (EquipmentEntity) results.get(0);
			else
				return equipment=null;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByExample(EquipmentEntity instance) {
		log.debug("finding EquipmentEntity instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.povo.EquipmentEntity").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding EquipmentEntity instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from EquipmentEntity as model where model." + propertyName + "= '"+value+"'";
			Query queryObject = sessionFactory.getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByBuilding(Object building) {
		return findByProperty(BUILDING, building);
	}

	public List findByFloor(Object floor) {
		return findByProperty(FLOOR, floor);
	}

	public List findByRoom(Object room) {
		return findByProperty(ROOM, room);
	}

	public List findByScope(Object scope) {
		return findByProperty(SCOPE, scope);
	}

	public List findAll() {
		log.debug("finding all EquipmentEntity instances");
		try {
			String queryString = "from EquipmentEntity";
			Query queryObject = sessionFactory.getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public EquipmentEntity merge(EquipmentEntity detachedInstance) {
		log.debug("merging EquipmentEntity instance");
		try {
			EquipmentEntity result = (EquipmentEntity) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(EquipmentEntity instance) {
		log.debug("attaching dirty EquipmentEntity instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EquipmentEntity instance) {
		log.debug("attaching clean EquipmentEntity instance");
		try {
			sessionFactory.getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}