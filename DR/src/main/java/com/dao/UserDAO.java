package com.dao;

import com.povo.UserEntity;

import java.util.List;

public interface UserDAO {
    public void save(UserEntity userEntity);
    public void update(UserEntity userEntity);
    public void delete(UserEntity userEntity);
    public UserEntity findById(String id);
    public List findByExample(UserEntity userEntity);
    public List findByProperty(String propertyName, Object value);
    public List findAll();
}
