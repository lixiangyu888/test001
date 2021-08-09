package com.dao;

import com.povo.RepairEntity;
import java.util.List;

public interface RepairDAO {
    public void save(RepairEntity repairEntity);
    public void update(RepairEntity repairEntity);
    public RepairEntity findById(Integer id);
    public List findByProperty(String propertyName, Object value);
    public List findByScope(String scope);
    public List findAll();
    public List findByUid(String uid);
    public List findByWid(String wid);
}
