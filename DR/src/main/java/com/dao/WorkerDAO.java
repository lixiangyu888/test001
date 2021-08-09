package com.dao;

import com.povo.WorkerEntity;

import java.util.List;

public interface WorkerDAO {
    public void update(WorkerEntity workerEntity);
    public void save(WorkerEntity workerEntity);
    public void delete(WorkerEntity workerEntity);
    public WorkerEntity findById(String id);
    public List findByExample(WorkerEntity workerEntity);
    public List findByProperty(String propertyName, Object value);
    public List findByScope(Object scope);
    public List findAll();
}
