package com.dao;

import com.povo.AdminEntity;
import java.util.List;

public interface AdminDAO {
    AdminEntity findById(String id);
    List findByProperty(String propertyName, Object value);
}
